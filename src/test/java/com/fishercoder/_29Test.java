package com.fishercoder;

import com.fishercoder.solutions._29;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _29Test {
    private static _29.Solution1 solution1;
    private static _29.Solution2 solution2;

    @BeforeEach
    public void setup() {
        solution1 = new _29.Solution1();
        solution2 = new _29.Solution2();
    }

    @Test
    public void test1() {
        assertEquals(1, solution1.divide(4, 3));
    }

    @Test
    public void test2() {
        assertEquals(Integer.MAX_VALUE, solution1.divide(Integer.MIN_VALUE, -1));
    }

    public void test3() {assertEquals(-1, solution1.divide(-4, 3));}

    @Test
    public void test4() {assertEquals(-1, solution1.divide(4, -3));}

    @Test
    public void test5() {assertEquals(1, solution1.divide(-4, -3));}

    @Test
    public void test6() {assertEquals(-1, solution1.divide(-10, 10));}

    @Test
    public void test7() {assertEquals(0, solution1.divide(0, 3));}
}
