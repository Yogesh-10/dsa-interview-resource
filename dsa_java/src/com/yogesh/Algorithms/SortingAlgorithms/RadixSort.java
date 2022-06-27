package com.yogesh.Algorithms.SortingAlgorithms;

//Radix sort takes O(l*(n + k)) time and O(n+k) space
//Radix Sort is better than Counting Sort
//Radix Sort internally uses Counting Sort
public class RadixSort {
    public void sort(int[] arr){
        //Find the max element in an array. To find highest number of digits
        int max = arr[0];
        for (int i : arr)
            max = Math.max(max, i);

        //exp is multiplied by 10 in each loop, For eg: if we have number 319, in first iteration we pass exp as 1, so 319/1, in second iteration 319/10
        //in third iteration 319/100, in 4th iteration 319/100 is not > 0, so we stop loop
        //we pass exp as an parameter to countSort because we need to sort by single digit in each loop,
        //so we do a simple math, for eg: 319, in first iteration, exp = 1, we divide digit by 1(exp) and modulo by 10, we get last digit, 9
        //in second iteration, exp = 10, we divide digit by 10(exp) and modulo by 10, we get second last digit, 1
        //in third iteration, exp = 100, we divide digit by 100(exp) and modulo by 10, we get first digit, 3
        for (int exp = 1; max/exp > 0; exp *= 10)
            countSort(arr, exp);
    }

    public void countSort(int[] arr, int exp){
        //we initialize to 10, because we sort every digit, and every digit ranges from 0 to 9
        int[] count = new int[10];
        int[] output = new int[arr.length];

        //store count of occurrences in count[]
        for (int i = 0; i < arr.length; i++)
            count[(arr[i] / exp ) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position (position - 1 = index) of this digit in output[]
        for (int i = 1; i < 10; i++)
            count[i] = count[i - 1] + count[i];

        //Build output array using count array
        for (int i = arr.length - 1; i >= 0; i--){
            output[count[(arr[i] / exp )% 10] - 1] = arr[i];
            count[(arr[i] / exp )% 10]--;
        }

        for (int i = 0; i < arr.length; i++)
            arr[i] = output[i];
    }
}

/*Radix sort takes O(l*(n + k)) time and O(n+k) space, where n is the number of items to sort, l is the number of digits in each item, and k is the number of values each digit can have.
This time complexity comes from the fact that we're calling counting sort one time for each of the l digits in the input numbers, and counting sort has a time complexity of O(n+k).

The space complexity also comes from counting sort, which requires O(n + k) space to hold the counts, indices, and output arrays.
In many implementations, including ours, we assume that the input consists of 64-bit integers. This means that the number of digits, l is a constant (64). With a binary number, each digit can either be a zero or a one, meaning that K is also a constant (2). With these assumptions, radix sort becomes O(n) time and O(n) space.
 */