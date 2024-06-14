package com.fishercoder.solutions;
import java.util.HashMap;
import java.util.Map;


public class _29 {

    public static class Solution1 {

        private static Map<String, Boolean> branchCoverage = new HashMap<>();

        static {
            branchCoverage.put("flag1", false);
            branchCoverage.put("flag2", false);
            branchCoverage.put("flag3", false);
            branchCoverage.put("flag4", false);
            branchCoverage.put("flag5", false);
            branchCoverage.put("flag6", false);
            branchCoverage.put("flag7", false);
        }

        public void printCoverage() {
            for (Map.Entry<String, Boolean> entry : branchCoverage.entrySet()) {
                System.out.println(entry.getKey() + " was " + (entry.getValue() ? "hit" : "not hit"));
            }
        }

        /**
         * credit: https://leetcode.com/problems/divide-two-integers/solution/ solution 1
         * <p>
         * Key notes:
         * 1. dividend = Integer.MAX_VALUE and divisor = -1 is a special case which will be handled separately;
         * 2. because within the given range, [-2_31 to 2_31 - 1], every positive integer could be mapped to a corresponding negative integer while the opposite is not true
         * because of the smallest number: Integer.MIN_VALUE = -2147483648 doesn't have one (Integer.MAX_VALUE is 2147483647). So we'll turn both dividend and divisor into negative numbers to do the operation;
         * 3. division, in its essence, is subtraction multiple times until it cannot be subtracted any more
         * <p>
         * Time: O(n)
         * Space: O(1)
         */
        public int divide(int dividend, int divisor) {
            if (dividend == Integer.MIN_VALUE && divisor == -1) { //1
                branchCoverage.put("flag1", true);
                return Integer.MAX_VALUE;
            }
            int negativeCount = 0;
            if (dividend < 0) {  //2
                branchCoverage.put("flag2", true);
                negativeCount++;
            } else { //3
                branchCoverage.put("flag3", true);
                dividend = -dividend;
            }
            if (divisor < 0) { //4
                branchCoverage.put("flag4", true);
                negativeCount++;
            } else { //5
                branchCoverage.put("flag5", true);
                divisor = -divisor;
            }

            int quotient = 0;
            while (dividend <= divisor) { //6
                branchCoverage.put("flag6", true);
                dividend -= divisor;
                quotient++;
            }
            if (negativeCount == 1) { //7
                branchCoverage.put("flag7", true);
                quotient = -quotient;
            }
            printCoverage();
            return quotient;
        }
    }

    public static class Solution2 {
        /**
         * credit: https://leetcode.com/problems/divide-two-integers/solution/ solution 2
         * <p>
         * 1. exponetial growth to check to speed up
         * 2. we still turn all numbers into negatives because negatives are a superset of all numbers in the positives.
         * <p>
         * Time: O(log2n)
         * Space: O(1)
         */
        private static final int HALF_INT_MIN = Integer.MIN_VALUE / 2;

        public int divide(int dividend, int divisor) {
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }
            int negativeCount = 0;
            if (dividend < 0) {
                negativeCount++;
            } else {
                dividend = -dividend;
            }
            if (divisor < 0) {
                negativeCount++;
            } else {
                divisor = -divisor;
            }
            int quotient = 0;
            while (dividend <= divisor) {
                int powerOfTwo = -1;
                int value = divisor;
                while (value >= HALF_INT_MIN && value + value >= dividend) {
                    value += value;
                    powerOfTwo += powerOfTwo;
                }
                quotient += powerOfTwo;
                dividend -= value;
            }
            if (negativeCount != 1) {
                quotient = -quotient;
            }
            return quotient;
        }
    }
}
