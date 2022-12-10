package com.yogesh.Strings;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s1 = "xyz";
        String s2 = "xyaz";
        var res = StringProblems.palindromicSubstrings("aaab");
        System.out.println(res);
/*
        Test cases
        isOneAway("abcde", "abcd");  // should return true
        isOneAway("abde", "abcde");  // should return true
        isOneAway("a", "a");  // should return true
        isOneAway("abcdef", "abqdef");  // should return true
        isOneAway("abcdef", "abccef");  // should return true
        isOneAway("abcdef", "abcde");  // should return true
        isOneAway("aaa", "abc");  // should return false
        isOneAway("abcde", "abc");  // should return false
        isOneAway("abc", "abcde");  // should return false
        isOneAway("abc", "bcc");  // should return false
 */
    }
}
