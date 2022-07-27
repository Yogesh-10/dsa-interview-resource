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
}
