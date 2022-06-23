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
        int boundary = lomutoPartition(arr, start, end);
        //Sort left subarray
        sort(arr, start, boundary - 1); //pass only boundary instead of boundary-1 for Hoare's Partition
        //Sort right subarray
        sort(arr, boundary + 1, end);
    }

    //Time-O(n), Aux Space - O(1)
    //Select Last element as pivot
    private int lomutoPartition(int[] arr, int start, int end){
        int pivot = arr[end];
        int boundary = start - 1;

        for (int i = start; i <= end; i++)
            if (arr[i] <= pivot)
                swap(arr, i, ++boundary);

        return boundary;
    }

    //Time-O(n), Aux Space - O(1). Hoare's partition works much better than Lomuto's Partition
    //Select First element as pivot
    private int hoaresPartition(int[] arr, int start, int end){
        int pivot = arr[start];
        int i = start - 1;
        int j = end + 1;
        while (true){
            do {
                i++;
            }while (arr[i] < pivot);

            do {
                j--;
            }while (arr[j] > pivot);

            if (i >= j) return j;
            swap(arr, i ,j);
        }
    }

    //Time-O(n), Aux Space - O(n)
    private void naivePartition(int[] arr, int start, int end, int pivot){
        int[] temp = new int[end - start + 1];
        int index = 0;

        //copying elements smaller than or equal to pivot to temp
        for (int i = start; i <= end; i++)
            if (arr[i] <= arr[pivot])
                temp[index++] = arr[i];

        //copying elements larger than pivot to temp
        for (int i = start; i <= end; i++)
            if (arr[i] > arr[pivot])
                temp[index++] = arr[i];

        //copying elements back to original arr
        for (int i = start; i <= end; i++)
            arr[i] = temp[i - start];
    }

    private void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
