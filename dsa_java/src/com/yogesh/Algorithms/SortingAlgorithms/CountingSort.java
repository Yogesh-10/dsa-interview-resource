package com.yogesh.Algorithms.SortingAlgorithms;

//Time - O(n + k)
//Space - O(n + k)
//Stable algorithm
public class CountingSort {
    //This will work only for integers, will not work if we sort objects
    //max is greatest element in array
    public void sort(int[] arr, int max){
        int[] count = new int[max + 1];
        for (int items : arr)
            count[items]++;

        int k = 0;
        for (int i = 0; i < count.length; i++)
            for (int j = 0; j < count[i]; j++)
                arr[k++] = i;
    }

    //Another implementation which will work both for integers and also sort objects, (for eg,compare student object with marks scored)
    public void countSort(int[] arr, int max){
        int maxValue = max + 1;
        int[] count = new int[maxValue];
        for (int i = 0; i < arr.length; i++)
            count[arr[i]]++;

        for (int i = 1; i < maxValue; i++)
            count[i] = count[i - 1] + count[i];

        int[] output = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--){
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        for (int i = 0; i < arr.length; i++)
            arr[i] = output[i];
    }
}
