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
    //I/P-"abcdfgabcd", pattern-abcd- abc, O/P-0 6, abc occurs in 0 and 6th position
    //I/P-"aaaaa", pattern-aaa, O/P-0 1 2, //I/P-"abcde", pattern-aaa, O/P - (print nothing)
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

    //9. Rabin Karp Algorithm - For String Pattern Matching
    //Like naive algorithm, we slide the pattern one by one and instead of calculating hash value sum for each character, we use rolling hash technique to calculate hash value. Calculate hash value for next window of text: Remove leading digit, add trailing digit
    //i.e we subtract last character of previous window and add last character of current window
    //compare hash values of pattern and current window. if hash values match, then only compare individual characters
    public static void RabinKarpAlgorithm(String str, String pattern){
        final int d = 256; //256 ascii characters
        final int q = 101; //prime number, we use this for modulo %q, reason for this is to use is, the weighted sum can become really large even for smaller strings, so we compute this under modulo, so we can store in integer variable
                           //we should also select the prime number q as large as possible, so there are less spurious hits, (spurious hits is a condition in which the sum of pattern and text match, but the character in it do not match),
                           //for eg: string-dog and pattern-god. lets consider a-1, b-2, c-3.....f-6, g-7,o-15. If we calculate sum, dog will be 26 and for god sum will be 26, the values match but pattern do not. this is called spurious hit
        int n = str.length(); int m = pattern.length();
        int h = 1; // d^(m-1) % q
        int p = 0; //hash value of pattern
        int t = 0; //hash value of current window(m) of text

        //compute d^(m-1) % q, once and use it while matching patterns, otherwise we have to compute d^(m-1) % q in every iteration
        for (int i = 1; i <= m - 1; i++)
            h = (h * d) % q;

        //compute hash value of pattern and hash value of first m(window) text
        for (int i = 0; i < m; i++) {
            p = (p * d + pattern.charAt(i)) % q;
            t = (t * d + str.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (int i = 0; i <= n - m; i++) {
            //if hash value of string(t) and pattern(p) match, then check if the characters are matching.
            if (p == t){
                int j;
                for (j = 0; j < m; j++)
                    if (str.charAt(i + j) != pattern.charAt(j))
                        break;
                if (j == m)
                    System.out.print(i + " ");
            }
            //slide to next window by rolling hash formula
            //Compute ti+1 using ti
            if (i < n - m){
                //rolling hash formula, t = d(t - str[i] * d^m-1) + str[i+m]
                // Calculate hash value for next window of text: Remove leading digit, add trailing digit
                //i.e we subtract last character of previous window and add last character of current window
                t = ((d * (t - str.charAt(i) * h)) + str.charAt(i + m)) % q;
                //some times t can be a negative value, in that case we convert it to positive by adding t by t+q
                if (t < 0)
                    t = t + q;
            }
        }
    }

    //10. Constructing and LPS array(Longest prefix suffix)
    //I/P - ababacab, O/P - [0, 0, 1, 2, 3, 0, 1, 2]
    //Naive approach, O(n^3)
    public static void fillLPSNaive(String str){
        int[] lps = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            lps[i] = longestPrefixSuffix(str, i + 1);
        }

        System.out.println(Arrays.toString(lps));
    }
    private static int longestPrefixSuffix(String str, int n){
        for (int len = n - 1; len > 0; len--) {
            boolean flag = true;
            for (int i = 0; i < len; i++) {
                int j = n - len + i;
                if (str.charAt(i) != str.charAt(j))
                    flag = false;
            }
            if (flag) return len;
        }
        return 0;
    }

    //11. KMP(Knuth-Morris-Pratt) Algorithm for pattern matching.
    //TC-O(n+m)- n for searching, m-for constructing lps array,
    //SC-O(m), where m is size of pattern
    //In naive approach we check every single pattern and match pattern. In KMP the idea is to preprocess the
    //prefix and suffix count, so we can reduce count of comparison, in lps[i] we store the proper prefix of pattern[0...i] which is also a suffix
    //so as we move on when a character in pattern and string doesn't match, we dont need to go back to start of string and start searching again, instead we look at lps[patternLength - 1], we go to that index
    //and start matching again, because we have stored length of prefix which is also a suffix, so if ab is suffix ab is also suffix, so we dont need to match ab again from start.
    public static void KMPAlgorithm(String str, String pattern){
        int n = str.length();
        int m = pattern.length();
        int i = 0, j = 0;
        //we construct lps array
        int[] lps = fillLPS(pattern);
        //iterate till length of string
        while (i < n){
            //if char at string and pattern matches, move both i and j
            if (str.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }
            //if j == m, that means we have reached end of pattern and matched all characters, so print it
            //and we set j to lps[j-1] to match other occurrence in string
            if (j == m){
                System.out.print(i - j + " ");
                j = lps[j - 1];
            }
            //if char doesn't match, and j is still 0, then increase i by 1
            //else set j to lps[j-1], and we start our matching from that position, instead of searching from start
            else if (i < n && str.charAt(i) != pattern.charAt(j)){
                if (j == 0)
                    i++;
                else
                    j = lps[j - 1];
            }
        }
    }
    //helper method to construct LPS Array for kmp algorithm
    private static int[] fillLPS(String pattern){
        int[] lps = new int[pattern.length()];
        int i = 1, j = 0;
        lps[0] = 0; //first position/char will be always 0
        while (i < pattern.length()){
            //if both characters are same in pattern then move set lps[i] to current j + 1, this will give length of proper prefix which is also suffix
            if (pattern.charAt(i) == pattern.charAt(j)){
                lps[i] = j + 1;
                i++;
                j++;
            }
            else{
                //if j is 0 there is no match, set lps[i] to 0 and move i
                //else, set j to lps[j-1], so that instead of searching from start, we start matching from lps[j-1], and store length of proper prefix and suffix
                if (j == 0) {
                    lps[i] = 0;
                    i++;
                } else
                    j = lps[j - 1];
            }
        }
        return lps;
    }

    //12. Check is one string is rotation of other (rotation can be clockwise or anti clockwise)
    //I/P- s1-abcd, s2-cdab, O/P-true, because  if we rotate abcd anti clockwise two times, we get bcda in first rotation and cdab in second rotation, so o/p is true
    //I/P- s1-abaaa, s2-baaaa, O/P-true
    //I/P- s1-abab, s2-abba, O/P-false
    public static boolean isStringARotation(String s1, String s2){
        //O(n^2) solution
 /*       if (s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < s1.length(); i++) {
            boolean flag = true;
            stringBuilder.append(s1, i, s1.length());
            stringBuilder.append(s1, 0, i);
            for (int j = 0; j < s2.length(); j++) {
                if (stringBuilder.charAt(j) != s2.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if (flag) return true;
            stringBuilder.delete(0, s1.length());
        }
        return false;
  */
        //Tc- O(n) -concatenation is O(n) and finding if string is present, is also O(n) so overall O(n),
        //SC-O(n) space for concatenation of strings
        if (s1.length() != s2.length()) return false;
        return ((s1 + s1).contains(s2)); //or, return ((s1 + s1).indexOf(s2) != -1);
    }

    //13. Anagram substring search,
    //I/P- str-FGHIJKBCDA, pattern-ABCD, O/P-true, because the substring at index 6, is BCDA, which is anagram of the pattern ABCD
    //I/P- str-BACDGABCDA, pattern-ABCD, O/P-true, because the substring is at index 0, 5, 6 all are  anagram of the pattern ABCD
    //I/P- str-AAABABAA, pattern-AABA, O/P-true, because the substring is at index 0, 1, 4 all are anagram of the pattern ABCD
    //I/P- str-ABCDEFGH, pattern-BEGH, O/P-false, because BEGH  is not anagram in the string str
    public static boolean anagramSearch(String str, String pattern){
        //Tc-overall O(n), O(m + (n-m) * char),where n is str and m is pattern, we can drop m since it's smaller than n, so overall
        //TC-will be O(n*char), if we consider char-256 as constant then it's O(n)
        //SC-O(m), where m is pattern,  if we consider char-256 as constant then it's O(1)
        final int CHAR = 256; //all ascii characters
        int[] stringCountArray = new int[CHAR]; //frequency for string
        int[] patternCountArray = new int[CHAR]; //frequency for pattern

        //fill the stringCountArray with string frequency and patternCountArray with pattern frequency
        //O(m)
        for (int i = 0; i < pattern.length(); i++) {
            stringCountArray[str.charAt(i)]++;
            patternCountArray[pattern.charAt(i)]++;
        }

        //unlike instead of checking every pattern is a anagram, we use sliding window technique
        //we add last character of current window and remove first character of previous window
        //O(n)
        for (int i = pattern.length(); i < str.length(); i++) {
            //check if values in both arrays are equal
            if (areCountMatching(stringCountArray, patternCountArray))
                return true;

            //else move the window to next position,
            //we add last character of current window and remove first character of previous window
            stringCountArray[str.charAt(i)]++;
            stringCountArray[str.charAt(i - pattern.length())]--;
        }
        //check explicitly for last window in str.
        if (areCountMatching(stringCountArray, patternCountArray))
            return true;

        return false;
    }
    //check the values are equal in both arrays, if not equal anagram is not found
    private static boolean areCountMatching(int[] stringCountArray, int[] patternCountArray) {
        final int CHAR = 256;
        //O(char)
        for (int i = 0; i < CHAR; i++)
            if (stringCountArray[i] != patternCountArray[i])
                return false;

        return true;
    }

    //14. Find length of longest substring with distinct characters
    //I/P- abcadbd, O/P-4, because longest substring with distinct character is 4, bcad or cadb
    //I/P- aaa, O/P-1, because longest substring with distinct character is 1, a
    public static int longestSubstringDistinct(String str){
        //TC-O(n), SC-O(CHAR), or O(1) if CHAR is considered constant
        final int CHAR=256;
        int[] prevVisitedArray = new int[CHAR]; //initialize a array
        Arrays.fill(prevVisitedArray, -1); //fill array with -1
        int windowStart = 0; int maxLength = 0;
        //iterate thru the string and find max len for every character. return the highest len
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            //starting window size with 0, increasing windowEnd by 1 in every iteration, if character at current iteration is already visited
            //update windowStart by value of prevArray at that index
            windowStart = Math.max(windowStart, prevVisitedArray[str.charAt(windowEnd)] + 1);
            //calculating maxLength
            int maxEnd = windowEnd - windowStart + 1;
            maxLength = Math.max(maxLength, maxEnd);
            //set prevVisitedArray[str.charAt(windowEnd)] to windowEnd, so next time if char is already visited, move windowStart to that location;
            prevVisitedArray[str.charAt(windowEnd)] = windowEnd;
        }
        return maxLength;
    }
}
