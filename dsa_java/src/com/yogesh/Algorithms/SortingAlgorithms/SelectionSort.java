package com.yogesh.Algorithms.SortingAlgorithms;

//Time Complexity - O(n^2), Space Complexity - O(1)
public class SelectionSort {
    public void sort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            int minIndex = i;
            for (int j = i; j < arr.length; j++)
                if (arr[j] < arr[minIndex])
                    minIndex = j;

            //swap current index with minIndex
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
