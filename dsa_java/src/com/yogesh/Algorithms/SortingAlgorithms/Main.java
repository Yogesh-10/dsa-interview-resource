package com.yogesh.Algorithms.SortingAlgorithms;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {50,40,30,20,10};
        var sorter = new BucketSort();
        sorter.sort(arr,3);
        System.out.println(Arrays.toString(arr));
    }
}
