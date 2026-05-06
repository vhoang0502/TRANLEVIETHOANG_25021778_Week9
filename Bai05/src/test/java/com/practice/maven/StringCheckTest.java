package com.practice.maven;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringCheckTest {
    @Test
    public void testIsPalindrome() {
        StringCheck checker = new StringCheck();
        assertTrue(checker.isPalindrome("madam"));
    }
}