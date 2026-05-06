package com.practice.maven;

public class StringCheck {
    public boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    public boolean isLongString(String str) {
        return str != null && str.length() > 10;
    }
}