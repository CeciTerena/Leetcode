package com.fishercoder.solutions;

import com.fishercoder.common.classes.ListNode;
import java.util.HashMap;
import java.util.Map;

public class _24 {
    public static class Solution1 {
        /**
         * Recursive solution.
         */
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode second = head.next;
            ListNode third = second.next;
            second.next = head;
            head.next = swapPairs(third);
            return second;
        }
    }

    public static class Solution2 {
        /**
         * Iterative approach:
         * My completely original on 10/24/2021.
         */
        private static Map<String, Boolean> branchCoverage = new HashMap<>();

        static {
            branchCoverage.put("flag1", false);
            branchCoverage.put("flag2", false);
            branchCoverage.put("flag3", false);
        }

        public ListNode swapPairs(ListNode head) {
            ListNode pre = new ListNode(-1);
            pre.next = head;
            ListNode tmp = pre;
            while (head != null) {
                branchCoverage.put("flag1", true);
                ListNode third;
                ListNode first = head;
                ListNode second = head.next;
                if (second == null) {
                    branchCoverage.put("flag2", true);
                    break;
                } else {
                    branchCoverage.put("flag3", true);
                    third = head.next.next;
                    second.next = first;
                    first.next = third;
                    tmp.next = second;
                    tmp = tmp.next.next;
                }
                head = third;
            }
            printCoverage();
            return pre.next;
        }

        public void printCoverage() {
            for (Map.Entry<String, Boolean> entry : branchCoverage.entrySet()) {
                System.out.println(entry.getKey() + " was " + (entry.getValue() ? "hit" : "not hit"));
            }
        }
    }
}
