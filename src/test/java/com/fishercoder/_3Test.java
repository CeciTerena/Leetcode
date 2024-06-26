package com.fishercoder;

import com.fishercoder.solutions._3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _3Test {
    private static _3.Solution1 solution1;
    private static _3.Solution2 solution2;
    private static _3.Solution3 solution3;
    private static _3.Solution4 solution4;
    private static _3.Solution5 solution5;
    private static _3.Solution6 solution6;
    private static int expected;
    private static String s;

    @BeforeEach
    public void setup() {
        solution1 = new _3.Solution1();
        solution2 = new _3.Solution2();
        solution3 = new _3.Solution3();
        solution4 = new _3.Solution4();
        solution5 = new _3.Solution5();
        solution6 = new _3.Solution6();
    }

    @Test
    public void test1() {
        expected = 3;
        s = "abcabcbb";
        assertEquals(expected, solution1.lengthOfLongestSubstring(s));
        assertEquals(expected, solution2.lengthOfLongestSubstring(s));
        assertEquals(expected, solution3.lengthOfLongestSubstring(s));
        assertEquals(expected, solution4.lengthOfLongestSubstring(s));
        assertEquals(expected, solution5.lengthOfLongestSubstring(s));
        assertEquals(expected, solution6.lengthOfLongestSubstring(s));
    }

    @Test
    public void IrinaTest() {
        assertEquals(0, solution1.lengthOfLongestSubstring(""));
        assertEquals(0, solution2.lengthOfLongestSubstring(""));
        assertEquals(0, solution3.lengthOfLongestSubstring(""));
        assertEquals(0, solution4.lengthOfLongestSubstring(""));
        assertEquals(0, solution5.lengthOfLongestSubstring(""));
        assertEquals(0, solution6.lengthOfLongestSubstring(""));
    }

}