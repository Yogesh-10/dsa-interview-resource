package com.yogesh.Strings;

import java.util.*;

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

    //5. Check for anagram strings. //An anagram of a string is another string that contains the same characters, only the order of characters can be different. For example, “abcd” and “dabc” are an anagram of each other.
    //I/P- s1-rat, s2-car, O/P-false //I/P- s1-anagram, s2-nagaram, O/P-true
    public static boolean isAnagram(String str1, String str2){
        //TC - O(n), SC-O(1)
        if (str1.length() != str2.length())
            return false;

        int[] count = new int[26];
        //O(n)
        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i) - 'a']++;
            count[str2.charAt(i) - 'a']--;
        }

        //this loop is considered as constant operation of length 26. If we consider this loop, then TC will be O(n+m), where m is len of count array
        for (int i = 0; i < count.length; i++)
            if (count[i] != 0)
                return false;

        return true;
    }

    //6. Find the index of Leftmost Repeating Character in a string
    //I/P-abbcc, O/P-1, //I/P-aba, O/P-1,
    public static int leftMostRepeatingCharacter(String s){
        //Naive Approach O(n^2)
/*        for (int i = 0; i < s.length(); i++)
            for (int j = i + 1; j < s.length(); j++)
                if (s.charAt(i) == s.charAt(j))
                    return i;

        return -1;
 */
        //Better Approach O(n) solution - but two traversals, SC-O(1) constant 256 char space
/*        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i)]++;

        for (int i = 0; i < s.length(); i++)
            if (count[s.charAt(i)] > 1)
                return i;

        return -1;
 */
        //Efficient Solution-1 single traversal- O(n)
/*        final int CHAR = 256;
        int res = Integer.MAX_VALUE;
        int[] count = new int[CHAR];
        Arrays.fill(count, -1);
        for (int i = 0; i < s.length(); i++) {
            int firstIndex = count[s.charAt(i)];
            if (firstIndex == -1)
                count[s.charAt(i)] = i;
            else
                res = Math.min(res, firstIndex);
        }
        return (res == Integer.MAX_VALUE) ? -1 : res;
 */
        //More Efficient Solution-2 single traversal- O(n)
        //In this solution we do less comparisons than previous one, between res and min
        final int CHAR = 256;
        boolean[] visited = new boolean[CHAR];
        int res = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            //we set res to i, because we iterate from last, so we come to left most index at last and update the result. so we do little comparison than previous solution
            if (visited[s.charAt(i)])
                res = i;
            else
                visited[s.charAt(i)] = true;
        }
        return res;
    }

    //7. Reverse words in a string
    // I/P - "coding is great" O/P - "great is coding"
    public static String reverseAString(String s){
        //TC-O(n), SC-O(n)
        int start = 0;
        char[] chars = s.toCharArray();
        //iterate thru arr and if there is a empty space found, then reverse the word before that space
        for (int end = 0; end < s.length(); end++) {
            if (chars[end] == ' '){
                reverse(chars, start, end - 1); //gnidoc si
                start = end + 1;
            }
        }
        //reverse last word in a string. because there may be no space after last word, so we explicitly reverse
        reverse(chars, start, s.length() - 1); //gnidoc si taerg
        //reverse whole string now.
        reverse(chars, 0 , s.length() - 1);  //great is coding

        //convert char array to string and return
        return new String(chars);
    }

    //reverse helper function
    private static void reverse(char[] arr, int low, int high){
        while (low < high) {
            char tmp = arr[low];
            arr[low++] = arr[high];
            arr[high--] = tmp;
        }
    }

    //8. String Searching Patterns - Naive Searching Pattern
    //I/P-"abceabefabcd", pattern-abcd O/P-8, abcd occurs in 8th index
    //I/P-"abcedfgabc", pattern-abcd- abc, O/P-0 7, abc occurs in 0 and 7th position
    //I/P-"aaaaa", pattern-aaa, O/P-0 1 2
    public static void naivePatternSearching(String str, String pattern){
        //TC-O((n-m+1)*m) Quadratic Solution
/*        int n = str.length();
        int m = pattern.length();
        //O(n-m+1)
        for (int i = 0; i <= n - m; i++) {
            int j;
            //O(m)
            for (j = 0; j < m; j++)
                if (str.charAt(i + j) != pattern.charAt(j))
                    break;

            if (m == j)
                System.out.print(i + " ");
        }
 */
        //Improved Naive Solution(for distinct characters in pattern)
        //TC-O(n) linear Solution, this is a linear solution because,
        //we are running j loop m times inside, and we are also saving m loops(i=i+j) skipping some iterations.
        //so overall we can consider this as O(n) Solution
        int n = str.length();
        int m = pattern.length();
        for (int i = 0; i <= n - m; ) {
            int j;
            for (j = 0; j < m; j++)
                if (str.charAt(i + j) != pattern.charAt(j))
                    break;

            if (m == j)
                System.out.print(i + " ");
            if (j == 0)
                i++;
            else
                i = (i + j);
        }
    }
}
