package com.fishercoder.solutions;
import java.util.HashMap;
import java.util.Map;

public class _11 {
    public static class Solution1 {
        /**
         * Time: O(n^2)
         * This brute force solution is NOT accepted on LeetCode due to TLE.
         */
        public int maxArea(int[] height) {
            int maxArea = 0;
            for (int left = 0; left < height.length - 1; left++) {
                for (int right = height.length - 1; left < right; right--) {
                    int area = (right - left) * Math.min(height[left], height[right]);
                    maxArea = Math.max(maxArea, area);
                }
            }
            return maxArea;
        }
    }

    public static class Solution2 {
        /**
         * Two pointer technique.
         * Well explained here: https://leetcode.com/problems/container-with-most-water/discuss/6100/Simple-and-clear-proofexplanation
         */
        private static Map<String, Boolean> branchCoverage = new HashMap<>();

        static {
            branchCoverage.put("flag1", false);
            branchCoverage.put("flag2", false);
            branchCoverage.put("flag3", false);
        }

        public int maxArea(int[] height) {
            int max = 0;
            int left = 0;
            int right = height.length - 1;
            while (left < right) {
                branchCoverage.put("flag1", true);
                max = Math.max(Math.min(height[left], height[right]) * (right - left), max);
                if (height[left] <= height[right]) {
                    /**if this height is shorter, then we'll need to move it to the right to find a higher one so that it's possible to find a larger area.*/
                    branchCoverage.put("flag2", true);
                    left++;
                } else {
                    branchCoverage.put("flag3", true);
                    right--;
                }
            }
            printCoverage();
            return max;
        }

        public void printCoverage() {
            for (Map.Entry<String, Boolean> entry : branchCoverage.entrySet()) {
                System.out.println(entry.getKey() + " was " + (entry.getValue() ? "hit" : "not hit"));
            }
        }
    }

}
