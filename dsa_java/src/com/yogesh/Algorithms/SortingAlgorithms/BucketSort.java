package com.yogesh.Algorithms.SortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public void sort(int[] arr, int numberOfBuckets){
        List<List<Integer>> buckets = createBuckets(arr, numberOfBuckets);
        int i = 0;
        for (List<Integer> bucket: buckets){
            Collections.sort(bucket);
            for (int item : bucket)
                arr[i++] = item;
        }
    }

    private List<List<Integer>> createBuckets(int[] arr, int numberOfBuckets){
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < numberOfBuckets; i++)
            buckets.add(new ArrayList<>());

        for (var item : arr)
            buckets.get(item / numberOfBuckets).add(item);

        return buckets;
    }
}
