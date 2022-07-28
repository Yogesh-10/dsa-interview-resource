package com.yogesh.Strings;

import java.util.HashMap;
import java.util.Map;

public class StringProblems {
    //1. Return first non repeating characters
    //Input : "a green apple", output: g
    public static char firstNonRepeatingCharacter(String str){
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char ch : chars)
            charFrequencyMap.put(ch, charFrequencyMap.getOrDefault(ch, 0) + 1);

        for (char ch : chars)
            if (charFrequencyMap.get(ch) == 1)
                return ch;

        return Character.MIN_VALUE;
    }

    //2. Print frequencies in (sorted order of alphabets), in a string of lower case alphabets.
    //I/P-"aabbcc", O/P-a2 b2 c2
    public static void printFrequenciesInSortedOrder(String str){
        //TC-O(n), SC-O(1)
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i) - 'a']++;

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0)
                System.out.println((char)(i + 'a') + " " + count[i]);
        }
    }

    //3. Check if a string is Palindrome
    //I/P-"madam", O/P-true, //I/P-"abcd", O/P-false
    public static boolean isPalindrome(String str){
        //TC-O(n), SC-O(1)
        for (int i = 0; i < str.length()/2; i++)
            if (str.charAt(i) != str.charAt(str.length() - i - 1))
                return false;

        return true;

        //Another Solution with while loop
/*      int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }
       return true;
 */
    }

    //4. Check if a string is subsequence of other
    //subsequence should be in same order as in string, (each string will have 2^n subsequence)
    //I/P- str1-abc str2-ac, O/P-true, I/P- str1-abcde str2-ace O/P-true,  I/P- str1-abcde str2-aec O/P-true
    public static boolean isStringSubsequenceOfOther(String str1, String str2){
        //O(n+m), m+n because we are running loop for both n and m, where n is str1 and m is str2
        if (str2.length() > str1.length())
            return false;

        int j = 0;
        for (int i = 0; i < str1.length() && j < str2.length(); i++)
            if (str1.charAt(i) == str2.charAt(i))
                j++;

        return j == str2.length();

        //Using While Loop
/*        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()){
            if (str1.charAt(i) == str2.charAt(j)){
                i++;
                j++;
            } else
                i++;
        }
        return j == str2.length();
 */
    }
}
