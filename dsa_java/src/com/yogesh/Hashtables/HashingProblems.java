package com.yogesh.Hashtables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HashingProblems {
    //1. Find the first non-repeated character
    //Eg: I/P - programming is awesome, O/P - p
    public char firstNonRepeatedChar(String str){
        HashMap<Character, Integer> map = new HashMap<>();

        char[] chars = str.toCharArray();
        //we iterate the loop and check if char is present in hashmap already,
        //if yes, we return the value of that char in hashmap, and add it to map with count
        // if no, we return 0 and then add to map with count
        //if no, we
        for (char ch : chars){
            int count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
            //or we can write above 2 lines as - map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        //return first char with value 1
        for (char ch : chars)
            if(map.get(ch) == 1)
                return ch;

        //if we didn't find value with 1, then we have all char repeated more than once
        //so we return char.MIN_VALUE which is like kind of null
        return Character.MIN_VALUE;
    }

    //Find the first repeated character
    //Eg: I/P - programming is awesome, O/P - r
    public char firstRepeatedChar(String str){
        Set<Character> set = new HashSet<>();

        for (char ch : str.toCharArray()) {
            if (set.contains(ch))
                return ch;

            set.add(ch);
        }
        return Character.MIN_VALUE;
    }
}
