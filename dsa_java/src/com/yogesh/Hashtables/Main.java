package com.yogesh.Hashtables;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {30, 10, 20, 20, 20, 10, 40, 30, 30};
        int[] arr2 = {1, 0, 1, 0, 0, 1}; //[0, 1, 0, 1, 1, 1, 1], arr2-[1, 1, 1, 1, 1, 0, 1]
        HashingProblems.printNbyKOccurrences(arr1, 4);
//        System.out.println(res);

//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(1, 10);
//        map.put(2, 20);
//        map.put(3, 30);
//        map.put(4, 40);
//
/*      HashTable hashTable = new HashTable();
        hashTable.put(6,"a");
        hashTable.put(6,"a-1");
        hashTable.put(8,"b");
        hashTable.put(11,"c");
        hashTable.remove(6);
        System.out.println("done");
 */
    }
}
