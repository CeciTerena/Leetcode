package com.fishercoder.solutions;
import java.util.HashMap;
import java.util.Map;

public class _3038 {

    private static Map<String, Boolean> branchCoverage = new HashMap<>();
    public static class Solution1 {

        static {
            branchCoverage.put("flag1", false);
            branchCoverage.put("flag2", false);
            branchCoverage.put("flag3", false);
            branchCoverage.put("flag4", false);
        }

        public void printCoverage() {
            for (Map.Entry<String, Boolean> entry : branchCoverage.entrySet()) {
                System.out.println(entry.getKey() + " was " + (entry.getValue() ? "hit" : "not hit"));
            }
        }

        public int maxOperations(int[] nums) {
            int maxOps = 0;
            if (nums == null || nums.length < 2) { //1
                branchCoverage.put("flag1", true); //1 should not be hit
                return maxOps;
            }
            maxOps++;
            int sum = nums[0] + nums[1];
            for (int i = 2; i < nums.length - 1; i += 2) { //2
                branchCoverage.put("flag2", true);
                if (nums[i] + nums[i + 1] == sum) { //3
                    branchCoverage.put("flag3", true); //3 should not be hit
                    maxOps++;
                } else { //4
                    branchCoverage.put("flag4", true);
                    break;
                }
            }
            printCoverage();
            return maxOps;
        }
    }
}

