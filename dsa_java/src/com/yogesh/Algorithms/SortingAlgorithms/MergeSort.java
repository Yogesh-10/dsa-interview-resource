package com.yogesh.Algorithms.SortingAlgorithms;

//Time Complexity - O(n log n), Space Complexity - O(1)
public class MergeSort {
    public void sort(int[] arr){
        if (arr.length < 2)
            return;

        int mid = arr.length/2;

        int[] left = new int[mid];
        for (int i = 0; i < mid; i++)
            left[i] = arr[i];

        int[] right = new int[arr.length - mid];
        for (int i = mid; i < arr.length; i++)
            right[i - mid] = arr[i];

        sort(left);
        sort(right);
        merge(left, right, arr);
    }

    private void merge(int[] left, int[] right, int[] result) {
        int i = 0; int j = 0; int k = 0;
        while (i < left.length && j < right.length){
            if (left[i] <= right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }

        //add remaining items to array
        while (i < left.length)
            result[k++] = left[i++];

        while (j < right.length)
            result[k++] = right[j++];
    }
}
