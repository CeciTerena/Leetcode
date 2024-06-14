package com.fishercoder.solutions;
import java.util.HashMap;
import java.util.Map;


public class _487 {

    public static class Solution1 {
        /**
         * I implemented this on my own after a quick read from https://leetcode.com/problems/max-consecutive-ones-ii/solution/
         */
        public static int findMaxConsecutiveOnes(int[] nums) {
            int left = 0;
            int right = 0;
            int zeroes = 0;
            int ans = 0;
            while (right < nums.length) {
                if (nums[right] == 0) {
                    zeroes++;
                }
                if (zeroes <= 1) {
                    ans = Math.max(ans, right - left + 1);
                } else {
                    while (left < nums.length && zeroes > 1) {
                        if (nums[left] == 0) {
                            zeroes--;
                        }
                        left++;
                    }
                }
                right++;
            }
            return ans;
        }
    }

    public static class Solution2 {
        /**
         * This is a more generic solution adapted from https://leetcode.com/problems/max-consecutive-ones-iii/, just set k = 1 here.
         */

        private static Map<String, Boolean> branchCoverage = new HashMap<>();
        static {
            branchCoverage.put("flag1", false);
            branchCoverage.put("flag2", false);
            branchCoverage.put("flag3", false);
            branchCoverage.put("flag4", false);
        }

        public int findMaxConsecutiveOnes(int[] nums) {
            int len = nums.length;
            int left = 0;
            int right = 0;
            int ans = 0;
            int k = 1;
            for (; right < len; right++) {
                branchCoverage.put("flag1", true);
                if (nums[right] == 0) {
                    branchCoverage.put("flag2", true);
                    k--;
                }
                while (k < 0) {
                    branchCoverage.put("flag3", true);
                    if (nums[left] == 0) {
                        branchCoverage.put("flag4", true);
                        k++;
                    }
                    left++;
                }
                ans = Math.max(ans, right - left + 1);
            }
            printCoverage();
            return ans;
        }

        public void printCoverage() {
            for (Map.Entry<String, Boolean> entry : branchCoverage.entrySet()) {
                System.out.println(entry.getKey() + " was " + (entry.getValue() ? "hit" : "not hit"));
            }
        }
    }
}
