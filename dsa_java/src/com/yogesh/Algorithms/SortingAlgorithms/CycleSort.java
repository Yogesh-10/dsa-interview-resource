package com.yogesh.Algorithms.SortingAlgorithms;

import java.util.Arrays;
import java.util.Collections;

//O(n^2) Algorithm - Best for less memory writes, because here we know where the item should be placed exactly(we know the index)
//Space - O(1)
public class CycleSort {
    //does not handle duplicates
    public void sortDistinct(int[] arr){
        //cs - cycle start
        for (int cs = 0; cs < arr.length - 1; cs++){
            int item = arr[cs];
            int pos = cs;
            for (int i = cs + 1; i < arr.length; i++)
                if (arr[i] < item)
                    pos++;
            int temp = item;
            item = arr[pos];
            arr[pos] = temp;

            while (pos != cs){
                pos = cs;
                for (int i = cs + 1; i < arr.length; i++)
                    if (arr[i] < item)
                        pos++;
                int temp1 = item;
                item = arr[pos];
                arr[pos] = temp1;
            }
        }
    }
}
