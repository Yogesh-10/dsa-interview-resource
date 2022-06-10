package com.yogesh.Algorithms.SortingAlgorithms;

//Time Complexity - Best and Average case O(n log n), Worst Case - O(n^2)
//Space Complexity - O(log n)
public class QuickSort {
    public void sort(int[] arr){
        sort(arr,0, arr.length - 1);
    }

    private void sort(int[] arr, int start, int end){
        if (start >= end) return;
        //Partition array
        int boundary = partition(arr, start, end);
        //Sort left subarray
        sort(arr, start, boundary - 1);
        //Sort right subarray
        sort(arr, boundary + 1, end);
    }

    private int partition(int[] arr, int start, int end){
        int pivot = arr[end];
        int boundary = start - 1;

        for (int i = start; i <= end; i++){
            if (arr[i] <= pivot)
                swap(arr, i, ++boundary);
        }
        return boundary;
    }

    private void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
