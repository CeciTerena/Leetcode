package com.fishercoder;

import com.fishercoder.solutions._3038;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _3038Test {
    private static _3038.Solution1 solution1;
    private static int[] nums;

    @BeforeEach
    public void setup() {
        solution1 = new _3038.Solution1();
    }

    @Test
    public void test1() {
        nums = new int[]{2, 2, 3, 2, 4, 2, 3, 3, 1, 3};
        assertEquals(1, solution1.maxOperations(nums));
    }

    @Test
    public void test2() {
        int[] nums = null;
        assertEquals(0, solution1.maxOperations(nums));
    }

    @Test
    public void test3() {
        int[] nums = new int[]{1};
        assertEquals(0, solution1.maxOperations(nums));
    }

    @Test
    public void test4() {
        int[] nums = new int[]{1, 2, 2, 3, 3, 4};
        assertEquals(1, solution1.maxOperations(nums));
    }

    @Test
    public void test5() {
        int[] nums = new int[]{2, 2, 1, 3};
        assertEquals(2, solution1.maxOperations(nums));
    }

    @Test
    public void test6() {
        int[] nums = new int[]{5, 5, 5, 5, 5, 5};
        assertEquals(3, solution1.maxOperations(nums));
    }
}