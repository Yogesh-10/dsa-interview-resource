package com.yogesh.Algorithms.SortingAlgorithms;

//Time Complexity - O(n^2), Space Complexity - O(1)
public class InsertionSort {
    public void sort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }
}
