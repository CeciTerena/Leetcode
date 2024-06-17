package com.fishercoder.solutions;
import java.util.HashMap;
import java.util.Map;

public class _58 {
    public static class Solution1 {
        private static Map<String, Boolean> branchCoverage = new HashMap<>();

        static {
            branchCoverage.put("flag1", false);
            branchCoverage.put("flag2", false);
        }

        public int lengthOfLastWord(String s) {
            if (s == null || s.length() == 0) {
                branchCoverage.put("flag1", true);
                printCoverage();
                return 0;
            }
            s = s.trim();
            int n = s.length() - 1;
            while (n >= 0 && s.charAt(n) != ' ') {
                branchCoverage.put("flag2", true);
                n--;
            }
            printCoverage();
            return s.length() - n - 1;
        }
        public void printCoverage() {
            for (Map.Entry<String, Boolean> entry : branchCoverage.entrySet()) {
                System.out.println(entry.getKey() + " was " + (entry.getValue() ? "hit" : "not hit"));
            }
        }
    }
}
