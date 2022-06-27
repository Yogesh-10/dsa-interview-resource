package com.yogesh.Algorithms.SortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Bucket sort is best to use when data is uniformly distributed across the range
//Time Complexity - Best case O(n),
// Worst case - When all items go in a single bucket, if we use insertion sort to sort individual buckets then O(n^2)
//if we use O(n log n) algorithm to sort individual buckets then O(n log n)
//Space Complexity - O(n + k), k is number of buckets
public class BucketSort {
    public void sort(int[] arr, int numberOfBuckets){
        //find maximum value in bucket
        int maxVal = arr[0];
        for (int i = 1; i < arr.length ; i++)
            maxVal = Math.max(maxVal, arr[i]);

        //create buckets, we increment maxVal by 1, because for example if maxVal is 80, numberOfBuckets is 4(zero indexed), we do (numberOfBuckets * i) / maxVal
        //if we use 80, without incrementing by 1,we have (4 * 80)/80 = 320/80 = 4, which is out of bounds
        //so we do, (4 * 80)/81 = 320/81 = 3, now we have correct index 3, for bucketSize 4
        List<List<Integer>> buckets = createBuckets(arr, numberOfBuckets, ++maxVal);
        //Sort individual buckets and combine all buckets to get sorted array
        int i = 0;
        for (List<Integer> bucket: buckets){
            Collections.sort(bucket);
            for (int item : bucket)
                arr[i++] = item;
        }
    }

    private List<List<Integer>> createBuckets(int[] arr, int numberOfBuckets, int maxVal){
        List<List<Integer>> buckets = new ArrayList<>();
        //Initialize buckets, or we will get null pointer exception, while using buckets.get
        for (int i = 0  ; i < numberOfBuckets; i++)
            buckets.add(new ArrayList<>());

        //add items to appropriate buckets
        for (int i : arr){
            //formula to calculate which item should go in to which bucket
            int bucketItem = (numberOfBuckets * i) / maxVal;
            buckets.get(bucketItem).add(i);
        }

        return buckets;
    }
}
