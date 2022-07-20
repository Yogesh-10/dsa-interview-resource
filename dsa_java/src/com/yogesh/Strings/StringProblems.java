package com.yogesh.Strings;

import java.util.HashMap;
import java.util.Map;

public class StringProblems {
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
}
