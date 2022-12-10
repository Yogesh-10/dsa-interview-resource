package com.yogesh.Arrays;

public class Main {
    public static void main(String[] as) {
        int[] arr1 = {-3,-1,1,2};
        int[] arr2 = {1, 3, 2, 0, -1, 7, 10};
        var res = ArrayProblems.minimumWindowSort(arr2);
        System.out.println(res);
    }
}
