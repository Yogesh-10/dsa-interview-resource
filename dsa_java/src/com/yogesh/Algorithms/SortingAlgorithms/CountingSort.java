package com.yogesh.Algorithms.SortingAlgorithms;

public class CountingSort {
    public void sort(int[] arr, int max){
        int[] count = new int[max + 1];
        for (int items : arr)
            count[items]++;

        int k = 0;
        for (int i = 0; i < count.length; i++)
            for (int j = 0; j < count[i]; j++)
                arr[k++] = i;
    }
}
