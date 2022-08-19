package com.yogesh.Arrays;

import java.util.*;

public class ArrayProblems {
    //1. Largest element in an array
    //I/p: [10, 50, 20, 8], O/P - 1(index of largest element in array)
    //I/p: [10, 20, 30, 80], O/P - 3(index of largest element in array)
    public static int largestElement(int[] arr) {
        //TC-O(n^2), SC-O(1)
/*        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > arr[i]){
                    flag = false;
                    break;
                }
            }
            if (flag) return i;
        }
        return -1;
 */
        //O(n) solution - Efficient solution, SC-O(1)
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = i;
        }
        return max;
    }

    //2. Second Largest element in an array
    //I/p: [10, 50, 20, 8], O/P - 2(index of largest element in array)
    //I/p: [10, 20, 30, 80], O/P - 2(index of largest element in array)
    public static int secondLargestElement(int[] arr) {
        //O(n) solution - Efficient solution
        int largest = 0;
        int secondLargest = -1; //we initialize second largest -1 because, we may have same values in array, eg: {10,10,10}. so here only we can have largest value. we cannot have second largest value. so we simply return -1
        //we traverse from first element, and check curr element is greater than arr[largest], if yes, we set current element to largest, and largest element to second largest
        for (int i = 1; i < arr.length; i++) {
            //the idea is to find largest element, and update secondLargest as largest element, and current element as largest element, because we have found a largest element, which is greater then previous largest element, so we set previous largest as second largest, and largest to current element
            //if curr element is greater than largest element, update secondLargest to largest and update current element as largest
            if (arr[i] > arr[largest]) {
                secondLargest = largest; //update secondLargest to largest
                largest = i; //update largest to current element
            } else if (arr[i] != arr[largest]) { //if curr element is equal to largest, we dont want to update. so we simply ignore
                // if curr element is not greater than largest, and not equal to largest or if secondLargest remains -1, in this example{10, 10, 10, 9}, then we update secondLargest
                if (secondLargest == -1 || arr[i] > arr[secondLargest])
                    secondLargest = i;
            }
        }
        return secondLargest;
    }

    //3. Check if array is sorted
    //I/P-[10, 20, 20, 20, 4, 30, 40, 50], Output - false //I/P-[10, 20, 20, 20, 30, 40, 50], Output - true
    public static boolean isArraySorted(int[] arr) {
        //O(n^2) Solution
/*        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j])
                    return false;
            }
        }
        return true;
 */
        //O(n) Solution
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }
        return true;
    }

    //4. Reverse an array
    public static int[] reverseArray(int[] arr) {
        //TC-O(n), SC-O(1)
        int low = 0; int high = arr.length - 1;
        while (low < high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        return arr;
        //using for loop
/*        for (int i = arr.length - 1, j = 0; i > j; j++, i--) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        return arr;
 */
    }

    //5. remove duplicates from sorted array
    //Input: [2, 3, 3, 3, 6, 9, 9] Output: 4(len of arr) Explanation: The elements after removing the duplicates will be [2, 3, 6, 9].
    //Input: [2, 2, 2, 11], Output: 2 Explanation: The elements after removing the duplicates will be [2, 11].
    public static int removeDuplicates(int[] arr) {
        //TC-O(n), SC-O(1)
        int res = 1;
        //we use a two pointer approach, if current element i and res-1 are not same, then copy arr[i] to arr[res], else move i
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[res - 1]) {
                arr[res] = arr[i];
                res++;
            }
        }
        return res; //return len of array
    }

    //6. Move zeros to end.
    //I/P - [0, 1, 0, 2, 0, 3, 0, 4, 0, 5], O/P-[1, 2, 3, 4, 5, 0, 0, 0, 0, 0]
    //I/P - [10,5,0,0,8,0,9,0], O/P-[10, 5, 8, 9, 0, 0, 0, 0]
    public static int[] moveZerosToEnd(int[] arr) {
        //TC-O(n^2), SC-O(1)
/*       for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0){
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] != 0){
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        break;
                    }
                }
            }
        }
        return arr;
 */
        //TC-O(n), SC-O(1)
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                //swap zero and non-zero number
                int temp = arr[count];
                arr[count] = arr[i];
                arr[i] = temp;

                count++;
            }
        }
        return arr;
    }

    //7. Left Rotate Array.
    //I/P-[10, 20, 30, 40, 50, 60], O/P-[20, 30, 40, 50, 60, 10]
    public static int[] leftRotate(int[] arr) {
        //TC-O(n), SC-O(1)
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = arr[i + 1];
            arr[i + 1] = arr[i];
            arr[i] = temp;
        }

        return arr;
        //another approach
/*      int temp = arr[0];
        for (int i = 1; i < arr.length; i++)
            arr[i - 1] = arr[i];

        arr[arr.length - 1] = temp;
 */
    }

    //8.Right Rotate Array.
    //I/P-[10, 20, 30, 40, 50, 60], O/P- [60, 10, 20, 30, 40, 50]
    public static int[] rightRotate(int[] arr){
        //TC-O(n), SC-O(1)
        for (int i = arr.length - 1; i > 0; i--){
            int temp = arr[i - 1];
            arr[i - 1] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    //9. Left Rotate Array by d times
    //Input: arr[] = {1, 2, 3, 4, 5, 6, 7}, d=2 Output: 3 4 5 6 7 1 2
    //Input: arr[] = {3, 4, 5, 6, 7, 1, 2}, d=3 Output: 6 7 1 2 3 4 5
    public static int[] leftRotateByDTimes(int[] arr, int d) {
        //solution 1 - O(nd) time, Aux space - O(1)
//        for (int i = 0; i < d; i++) {
//            leftRotate(arr);
//        }
//        System.out.println(Arrays.toString(arr));

        //solution 2 - O(n) time, Aux space - O(d)
//        int[] temp = new int[d];
//        for (int i = 0; i < d; i++)
//            temp[i] = arr[i];
//        for (int i = d; i < arr.length; i++)
//            arr[i - d] = arr[i];
//        for (int i = 0; i < d; i++)
//            arr[arr.length - d + i] = temp[i];
//        return arr;

        //solution-3 Reversal algo for array rotation
        //O(n) time and O(1) space
        reverse(arr, 0, d - 1); //reverse the first d-1 elements
        reverse(arr, d, arr.length - 1);//reverse the remaining elements from d to end of array
        reverse(arr, 0, arr.length - 1);//reverse entire array
        return arr;
    }
    private static void reverse(int[] arr, int low, int high){
        while (low < high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    //10. Leaders in an array - An element is leader if it is greater than all the elements to its right side. And the rightmost element is always a leader. For example in the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
    //I/P-[16, 17, 4, 3, 5, 2], O/P - 17 5 2
    public static void leaderInArray(int[] arr) {
        //TC-O(n^2), SC-O(1)
/*        for (int i = 0; i < arr.length; i++){
            boolean flag = false;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[i] <= arr[j]) {
                    flag = true;
                    break;
                }
            }
            if (!flag){
                System.out.print(arr[i] + " ");
            }
        }
 */
        //O(n) - solution NOTE:This solution prints the values in reverse order, if we want to print as same order in array, we can use a stack or store values in arr and reverse them.
        int currLeader = arr[arr.length - 1]; //last element is always a leader, so we set it as currLeader
        System.out.print(currLeader + " ");

        //we traverse from secondLast element, if current element is greater than currLeader, then set currElement as currLeader and print it
        //we scan from right to left, and keep track of maxvalue from right, if currElement is greater than currLeader, that means we have a leader that is greater than the elements to the right side of it
        for (int i = arr.length - 2; i >= 0; i--){
            if (currLeader < arr[i]) {
                currLeader = arr[i];
                System.out.print(currLeader + " ");
            }
        }
    }

    //11. Find maximum difference of arr[j] - arr[i], such that j > i.
    //Input:[7,9,5,6,3,2], Output-2, because the max difference is 9-7=2
    //Input:[2,3,10,6,4,8,1], Output-8, because the max difference is 10-2=8
    public static int maximumDifference(int[] arr){
//        O(n ^ 2) solution,  Aux Space - O(1)
/*        int max = arr[1] - arr[0];
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                max = Math.max(max, arr[j] - arr[i]);
            }
        }
        System.out.println(max);
 */
        //O(n) solution, Space - O(1)
        int minValue = arr[0]; //we set minValue as first ele in arr
        int res = arr[1] - arr[0]; //we set res as difference of arr[1] - arr[0]

        //we iterate from 1st element and check, if currentElement - minvalue is greater than result,if yes we update res, and update minvalue to currentElement if currentElement is smaller than minVal
        //since (currentElement(if it is a greater element)-minvalue) in the array gives the maximum difference, we set minvalue as first element and iterate through array and check difference of (currentElement-minvalue),
        //if it greater than previous res we update res, and update minValue if it smaller than previous minvalue, because we need max difference
        for (int i = 1; i < arr.length; i++){
            res = Math.max(res, arr[i] - minValue);
            minValue = Math.min(minValue, arr[i]);
        }
        return res;
    }

    //12. count frequency of element in sorted array
    //I/P - [10, 10, 20, 20, 20, 30], O/P- 10 2, 20 2, 30 1
    public static void frequencyInSortedArray(int[] arr){
        //TC-O(n), SC-O(1) , NOTE: This solution is for sorted array, for unsorted array check hashingproblems.java (4. printFrequency)
        int count = 1;
        for (int i = 0; i < arr.length - 1; i++){
            if (arr[i] == arr[i + 1])
                count++;
            else  {
                System.out.println(arr[i] + " " + count);
                count = 1;
            }
        }
        System.out.println(arr[arr.length-1] + " " + count);
    }

    //13. Stock Buy Sell to Maximize Profit - The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in those days
    //For example, if the given array is {100, 180, 260, 310, 40, 535, 695}, the maximum profit can earn by buying on day 0, selling on day 3. Again, buy on day 4 and sell on day 6.
    //Input: [1,5,3,8,12], Output-13, we buy stock on day 0 and sell on day 1, so (5-1)=4, and buy stock on day 2 and sell on day 4, so (12-3)=9, total profit is 4+9=13
    //Input: [10,20,30], Output-20 Input: [30,20,10], Output-0
    //Input: [1,5,3,1,2,8], Output-11
    public static int maxProfit(int[] price, int start, int end){
       //O(n^2) solution, Space - O(n) for recursive call stack
/*     if (end <= start)
            return 0;

        int profit = 0;
        for (int i = start; i < end; i++){
            for (int j = i + 1; j <= end; j++){
                //we check if price at j is greater than price at i
                if (price[j] > price[i]){
                    //if yes we calculate current profit by, taking difference between j and i
                    //and we recursively call left of i and for right of j, so we check all pairs and get max profit
                    int currProfit = price[j] - price[i] +
                            maxProfit(price, start, i - 1) +
                            maxProfit(price, j + 1, end);

                    //finally we update the max profit
                    profit = Math.max(profit, currProfit);
                }
            }
        }
        return profit;
        */

        //O(n) solution, Aux Space - O(1)
        //valley peak approach - The key point is we need to consider every peak immediately following a valley to maximize the profit
        //In this approach, we just need to find the next greater element and subtract it from the current element so that the difference keeps increasing until we reach a minimum
        int profit = 0;
        //the idea is simple, we iterate through array, when i is greater than i-1,
        //we simply subtract (i and i-1) and add it to the profit. this means that
        //we buy when stock is low and sell when stock is high(we keep on adding as we iterate through the array).
        for (int i = 1; i < price.length; i++)
            if (price[i] > price[i - 1])
                profit += price[i] - price[i - 1];

        return profit;
    }

    //14. Trapping Rain Water - Given an array of non-negative integers representation elevation of ground. Your task is to find the water that can be trapped after rain.
    //Input: height= [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6
    //Input:  [4,2,0,3,2,5] Output:9
    public static int trapRainWater(int[] arr){
/*      //TC-O(n^2), SC-O(1)
        int res = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            //find the left max bar
            //traverse through left of i and find max height bar on left
            int lMax = arr[i];
            for (int j = 0; j < i; j++)
                lMax = Math.max(lMax, arr[j]);

            //find the right max bar
            //traverse through right of i and find max height bar on right
            int rMax = arr[i];
            for (int j = i + 1; j < arr.length; j++)
                rMax = Math.max(rMax, arr[j]);

            //Find the min height of bar between, rmax and lmax, and subtract with current i
            //that gives the amount of water that can be trapped at that point
            res += (Math.min(lMax, rMax) - arr[i]);
        }
        return res;
*/
      //O(n) solution, Aux Space - O(n)
/*    int res = 0;
      int n = arr.length;
      int[] lMax = new int[n];
      int[] rMax = new int[n];

      //computing lmax and storing it in lmax array
      lMax[0] = arr[0];
      for (int i = 1; i < n; i++)
          lMax[i] = Math.max(lMax[i - 1], arr[i]);

      //computing rmax and storing it in rmax array
      rMax[n - 1] = arr[n - 1];
      for (int i = n - 2; i >= 0; i--)
          rMax[i] = Math.max(rMax[i + 1], arr[i]);

      //finding the amount of water trapped in between rmax and lmax bars
      for (int i = 1; i < n; i++)
          res += (Math.min(lMax[i], rMax[i]) - arr[i]);

      return res;
 */
        //TC-O(n), SC-O(1) //Two pointer approach
        //The intuition is we use two pointers and set leftMax and rightMax as 0, in previous solution we used a prefix array to store height of buildings, but we calculate buildings height on the go
        //we check if left building is smaller or equal to right building, because one building(right or left) will be limiting the amount of water trapped, i.e, if left building is smaller and right is larger, the maximum amount of water we can store is, only height of left building, after that water will overflow
        //so, if left building is smaller than right building and current building at left is smaller than leftMax, then we can store water here
        //similarly, if right building is smaller or equal to left building and current building at right is smaller than rightMax, we can store water here
        int left = 0; //left pointer
        int right = arr.length - 1; //right pointer
        int leftMax = 0; //maximum building on left
        int rightMax = 0;//maximum building on right
        int res = 0; //units of water stored
        while (left <= right){
            //if left building is smaller than right building
            if (arr[left] <= arr[right]){
                //if current building is greater than left max building, update leftMax
                if (arr[left] > leftMax)
                    leftMax = arr[left];
                //else if current building is smaller than leftMax building, that means we can store a water here, because we are in a condition where(arr[left] <= arr[right]) i.e,left building is smaller or equal to right building
                //and current building is smaller than leftMax building, so we can definitely store water here(because we have buildings greater than currentBuilding on left and right side), we can get water stored in current building trap is by taking
                //difference between leftMax and current building at left
                else
                    res += (leftMax - arr[left]);
                left++; //move the pointer
            }
            else{ // else if arr[left] > arr[right], that means left building is greater than right building
                //if currentBuilding a right is greater than rightMax building then update rightMax
                if (arr[right] > rightMax)
                    rightMax = arr[right];
                //else if current building is smaller than rightMax building, that means we can store water here, because we are inside a condition(arr[left] > arr[right]), i.e,right building is smaller than left building
                //and current building is smaller than rightMax building, so we can definitely store water here(because we have buildings greater than currentBuilding on left and right side), we can get water stored in current building trap is by taking
                //difference between rightMax and current building at right
                else
                    res += (rightMax - arr[right]);
                right--; //decrement right pointer
            }
        }
        return res;
    }

    public static int maxConsecutiveOnes(int[] arr){
        //O(n^2) solution
        /*
        int res = 0;
        for (int i = 0; i < arr.length; i++){
            int curr = 0;
            for (int j = i; j < arr.length; j++){
                if (arr[j] == 1) curr++;
                else break;
            }
            res = Math.max(res, curr);
        }
        return res;
*/
        //O(n) solution
        int res = 0;
        int curr = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 0)
                curr = 0;
            else{
                curr++;
                res = Math.max(res, curr);
            }
        }
        return res;
    }

    public static int maxSubarraySum(int[] arr){
        int res = arr[0];
        int maxEnding = arr[0];
        for (int i = 1; i < arr.length; i++){
            //we extend the previous subarray by (arr[i] + maxending), or we start new subarray from arr[i]
            maxEnding = Math.max(arr[i] + maxEnding, arr[i]);
            res = Math.max(res, maxEnding);
        }

        return res;
    }

    public static int longestEvenOddSubarray(int[]arr){
        //O(n^2) solution
//        int res = 1;
//        for (int i = 0; i < arr.length; i++){
//            int curr = 1;
//            for (int j = i + 1; j < arr.length; j++){
//                if (arr[j] % 2 == 0 && arr[j - 1] % 2 != 0 || arr[j] %2 != 0 && arr[j - 1] % 2 == 0)
//                    curr++;
//                else break;
//            }
//            res = Math.max(res, curr);
//        }
//        return res;

        //O(n) solution - kadane's algorithm
        int res = 1;
        int curr = 1;
        for (int i = 1; i < arr.length; i++){
            //if it's alternative we extend previous subarray and increase curr
            if (arr[i] % 2 == 0 && arr[i - 1] % 2 != 0 || arr[i] %2 != 0 && arr[i - 1] % 2 == 0){
                curr++;
                res = Math.max(res, curr);
            }
            //or else we start new subarray and reset curr to 1
            else curr = 1;
        }
        return res;
    }

    public static int maximumCircularSubarraySum(int[] arr){
//        O(n^2) solution
//        int res = arr[0];
//        for (int i = 0; i < arr.length; i++) {
//            int currMax = arr[i];
//            int currSum = arr[i];
//            for (int j = 1; j < arr.length; j++){
//                //when calculate index, so that index comes back to first position in array, after reaching the last
//                int index = (i + j) % arr.length;
//                currSum += arr[index];
//                currMax = Math.max(currMax, currSum);
//            }
//            res = Math.max(res, currMax);
//        }
//        return res;

        //O(n^2) solution
        //in this solution we can find maxsubarray sum in circular array by finding min sum value in subarray and subtracting it with total sum of array
        //we first find the max subarray sum in the array, without checking circular array.(using kadane's algorithm)
        int maxNormalSubarray = maxSubarraySum(arr);

        //if it's negative then all elements in array is negative, so we return max of normal subarray sum
        if (maxNormalSubarray < 0)
            return maxNormalSubarray;

        //we find the total sum of array, and subtract it with min subarray value
        //instead of writing other function for finding min subarray sum, we can reuse max subarray sum
        //the trick here is, we invert all the elements of the array and find max subarray sum value, which is a result of
        //min value of subarray sum
        int arrSum = 0;
        for (int i = 0; i < arr.length; i++){
            arrSum += arr[i];
            arr[i] = -arr[i];
        }

        //instead of subtracting we add, because we have inverted and found the max value(which is minvalue), for eg:-6 is value of minsum, but we have inverted and found result as 6, so we add
        int maxCircularSubarray = arrSum + maxSubarraySum(arr);
        return Math.max(maxNormalSubarray, maxCircularSubarray);
    }

    public static int majorityElement(int[] arr){
//        O(N^2) solution
//        for (int i = 0; i < arr.length;i++){
//            int count = 1;
//            for (int j = i + 1; j < arr.length;j++){
//                if (arr[i] == arr[j]){
//                    count++;
//                }
//            }
//            if (count > arr.length/2) return i;
//        }
//        return -1;

        //O(n) solution - Moore's voting algorithm
        int res = 0;
        int count = 1;
        //find the candidate, that appears maximum
        for (int i = 1; i < arr.length; i++){
            if (arr[res] == arr[i]) count++;
            else count--;

            if (count == 0) {
                count = 1;
                res = i;
            }
        }

        //check if the candidate is actually a majority
        count = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[res] == arr[i])
                count++;
        }
        if (count <= arr.length / 2) res = -1;

        return res;
    }

    public static boolean equilibriumPoint(int[] arr){
//        //Using Prefix sum technique - O(n^2) Solution
//        for (int i = 0; i < arr.length; i++){
//            int leftSum = 0; int rightSum = 0;
//            for (int j = 0; j < i; j++)
//                leftSum += arr[j];
//
//            for (int k = i + 1; k < arr.length; k++)
//                rightSum += arr[k];
//
//            if (leftSum == rightSum) return true;
//        }
//        return false;

        //Using Prefix sum technique - O(n) solution
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];

        int lSum = 0;
        for (int i = 0; i < arr.length; i++){
            //we calculate lSum as we traverse and we ger right sum by,
            //subtracting sum - arr[i] in each iteration, which will gives us rightSum
            int rightSum = sum - arr[i];
            if (lSum == rightSum)
                return true;

            lSum += arr[i];
            sum -= arr[i];
        }
        return false;
    }

    public static int mostFreqItem(int[] arr){
        int res = 1;
        int maxCount = 1;
        for (int i = 0; i < arr.length; i++){
            int count = 1;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] == arr[j]) count++;

            if (count > maxCount){
                maxCount = count;
                res = arr[i];
            }
        }
        return res;
    }

    public static void commonElementsIn2SortedArrays(int[] arr1, int[] arr2){
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length){
            if (arr1[i] < arr2[j])
                i++;
            else if (arr1[i] > arr2[j])
                j++;
            else {
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }
        }
    }

    public static boolean isRotation(int[] arr1, int[] arr2){
        int m = arr1.length; int n = arr2.length;
        if (n != m) return false;

        int target = arr1[0]; int key = -1;
        for (int k= 0; k < n; k++){
            if (arr2[k] == target){
                key = k;
                break;
            }
        }
        if (key == -1) return false;

        for (int i = 0; i < m; i++){
            int index = (key + i) % n; //or use (key % n) and increment key++ in every iteration
            if (arr1[i] != arr2[index]) return false;
        }

        return true;
    }

    public static void removeEvenItems(int[] arr){
        int index = 0;
        int size = arr.length;
        for (int i = 0; i < arr.length; i++){
           if (arr[i] % 2 == 1){
               arr[index] = arr[i];
               if (i > index) {
                   arr[i] = 0;
               }
               index++;
           }else{
               arr[i] = 0;
               size--;
           }
        }
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }

    public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2){
        //Time Complexity : O(n1 + n2)
        //Auxiliary Space : O(n1 + n2)
        int i = 0; int j = 0; int index = 0;
        int[] temp = new int[arr1.length + arr2.length];

        while (i < arr1.length && j < arr2.length){
            if (arr1[i] > arr2[j]){
                temp[index++] = arr2[j];
                j++;
            }
            else {
                temp[index++] = arr1[i];
                i++;
            }
        }
        while (i < arr1.length) temp[index++] = arr1[i++];
        while (j < arr2.length) temp[index++] = arr2[j++];
        return temp;
    }

    public static int[] findSumAddUpToN(int[] arr, int sum){
//        O(n^2) solution
//        int[] res = new int[2];
//        for (int i = 0; i < arr.length; i++){
//            for (int j = i + 1; j < arr.length; j++){
//                if (arr[i] + arr[j] == sum) {
//                    res[0] = arr[i];
//                    res[1] = arr[j];
//                    return result;
//                }
//            }
//        }
//        return new int[]{};

        //O(n logn) solution - sorting takes O(nlogn) and the algorithm to find two numbers takes O(n) time, the overall time complexity of this code is O(nlogn).
        Arrays.sort(arr);
        int[] res = new int[2];
        int leftPointer = 0;
        int rightPointer = arr.length - 1;
        while (leftPointer != rightPointer){
            if (arr[leftPointer] + arr[rightPointer] == sum){
                res[0] = arr[leftPointer];
                res[1] = arr[rightPointer];
                return res;
            }
            else if(arr[leftPointer] + arr[rightPointer] < sum)
                leftPointer++;
            else // A[i] + A[j] > sum
                rightPointer--;
        }
        return new int[]{};
    }

    public static int[] findProduct(int[] arr){
//        O(n^2) solution
//        int[] res = new int[arr.length];
//        int index = 0;
//        for (int i = 0; i < arr.length; i++){
//            int prod = 1;
//            for (int j = 0; j < arr.length; j++){
//                if (i != j) prod *= arr[j];
//            }
//            res[index++] = prod;
//        }
//        return res;

        //O(n) solution
        int n = arr.length;
        int i, temp = 1;

        // Allocation of result array
        int[] result = new int[n];

        // Initializing the result array by 1
        for(int j=0; j < n; j++)
            result[j] = 1;

        // Product of elements on left side excluding arr[i]
        for (i = 0; i < n; i++)
        {
            result[i] = temp;
            temp *= arr[i];
        }

        // Initializing temp to 1 for product on right side
        temp = 1;

        // Product of elements on right side excluding arr[i]
        for (i = n - 1; i >= 0; i--)
        {
            result[i] *= temp;
            temp *= arr[i];
        }

        return result;
    }

    public static int smallestElement(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    public static int findFirstUnique(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) return arr[i];
        }

        return -1;
    }

    public static int[] reArrangePositiveAndNegativeValues(int[] arr){
//        //O(n^2) Solution
//        for (int i = 0; i < arr.length; i++){
//           for (int j = i + 1; j < arr.length; j++){
//               if (arr[i] > arr[j]){
//                   int temp = arr[j];
//                   arr[j] = arr[i];
//                   arr[i] = temp;
//               }
//           }
//        }
        //O(n) solution
        //In this solution, we keep two variables i and j. Both of them are 0 initially. i iterates over the array
        //while j keeps track of the position where next encountered negative number should be placed. When we come
        //across a negative number, the values at i and j indexes are swapped, and j is incremented. This continues until the end of the array is reached.
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {   // if negative number found
                if (i != j) {
                    int temp = arr[i];
                    arr[i] = arr[j]; // swapping with leftmost positive
                    arr[j] = temp;
                }
                j++;
            }
        }
        return arr;
    }

    public static int[] maxMinOrder(int[] arr){
        //O(n^2) solution
        int[] result = new int[arr.length];
        int last = arr[(arr.length - 1)/2];
        int i = 0; int j = arr.length - 1;
        int index = 0;
        while (i < j){
            result[index++] = arr[j--];
            result[index++] = arr[i++];
        }
        result[result.length-1] = last;
        return result;
    }

    //Binary Search Problems

    public static int binarySearch(int[] arr, int low, int high, int x){
        while (low <= high){
            int mid = (low + high) / 2;
            if (arr[mid] == x)
                return mid;
            else if (arr[mid] > x)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static int firstOccurrence(int[] arr, int low, int high, int x){
        //normal binary search
        if (low > high)
            return -1;

        int mid = (low + high) / 2;

        if (arr[mid] < x)
            return firstOccurrence(arr, mid+1, high, x);
        else if (arr[mid] > x)
            return firstOccurrence(arr, low, mid-1,x);
        //special case for first occurrence
        else{
            //if mid is 0, it means it is the first element
            //and we check if arr[mid] is first occurrence, if yes we return mid
            if (mid == 0 || arr[mid - 1] != arr[mid])
                return mid;
            else
                //else we recursively go to left side to find first occurrence
                return firstOccurrence(arr, low, mid - 1, x);
        }
    }

    public static int lastOccurrence(int[] arr, int low, int high, int x){
//        for (int i = arr.length - 1; i >= 0; i--){
//            if (arr[i] == x)
//                return i;
//            else if(arr[i] < x)
//                break;
//        }
//        return -1;
//        if (low > high) return -1;
//
//        int mid = (low + high) / 2;
//        if (arr[mid] < x)
//            return lastOccurrence(arr, mid + 1, high, x);
//        else if(arr[mid] > x)
//            return lastOccurrence(arr, low, mid - 1, x);
//        else{
//            if (mid == arr.length - 1 || arr[mid] != arr[mid + 1])
//                return mid;
//            else
//                return lastOccurrence(arr, mid + 1, high, x);
//        }

        //O(log n) solution
        while (low <= high){
            int mid = (low + high) / 2;

            if (arr[mid] > x)
                high = mid - 1;
            else if (arr[mid] < x)
                low = mid + 1;
            else{
                if (mid == arr.length - 1 || arr[mid] != arr[mid + 1])
                    return mid;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }

    public static int countOccurrence(int[] arr, int x){
//        O(n) Solution
//        int count = 0;
//        for (int i = 0; i < arr.length; i++)
//            if (arr[i] == x)
//                count++;
//
//        return count;

        //O(log n) Solution -  finding first occurrence is O(log n) + last occurrence is O(log n)- totally O(log n)
        int first = firstOccurrence(arr, 0, arr.length - 1, x);
        if (first == -1)
            return 0;
        else
            //first occurrence - last occurrence + 1 - will give total number of occurrence of x
            return (lastOccurrence(arr, 0, arr.length - 1, x) - first + 1);
    }

    public static int countOnes(int[] arr){
        //O(n) Solution
//        int count = 0;
//        for (int i = 0; i < arr.length; i++)
//            if (arr[i] == 1) count++;
//
//        return count;

        //O(log n) Solution
        int low = 0; int high = arr.length - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            //If arr[mid] is zero, we have to find one. since array is sorted we move right side
            if (arr[mid] == 0)
                low = mid + 1;
            else{
                //if mid is 0, then it is the first element, so we return or if arr[mid-1] is not zero, we move left side to find first occurrence of 1
                if (mid == 0 || arr[mid - 1] == 0)
                    return arr.length - mid;
                else
                    high = mid - 1;
            }
        }
        return 0;
    }

    public static int squareRoot(int[] arr, int x){
        //O(x^1/2) solution
//        int i = 1;
//        while (i * i <= x)
//            i++;
//
//        return i - 1;

        //O(log x) solution
        int low = 1; int high = x; int ans = -1;
        while (low <= high){
            int mid = (low + high) / 2;
            int sq = mid * mid;
            if (sq == x) return mid;
            else if (sq > x) high = mid - 1;
            else{
                low = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }

    //Search in a infinite sized array
    public static int searchInfiniteSizedArray(int[] arr, int x){
/*      //O(x) time, where x is position
        int i = 0;
        while (true){
            if (arr[i] == x) return i;
            if (arr[i] > x) return -1;
            i++;
        }
 */
        //O(log x) solution
        if (x > arr[arr.length - 1]) return -1;
        if (arr[0] == x) return 0;

        int i = 1;
        //we double the i in each step, as soon as x > arr[i] we stop.
        while (arr[i] < x)
            i = i * 2;

        //at this point if arr[i] == x, we return i
        if (arr[i] == x) return i;

        //else, we do a binary search for a specific range
        //In this example {1,10,15,20,40,60,80,100,200,500.....}, our i is at 8,(stopped this in while loop)
        //so we can start binary search from, index 0 to 8, or we can further optimize this search,
        //we can start from (i/2)+1 because, if we do (i/2) we can go to previously where i was, because we are doubling (i*2)
        //so we start from (i/2)+1, because (i/2) will be definitely smaller than x, we need to search next from i/2,
        //similarly we end at i-1, because i will be definitely greater than x.
        //for this binary search, low- (i/2)+1, high- (i-1)
        return binarySearch(arr, (i / 2) + 1, i - 1, x);
    }

    public static int searchInSortedRotatedArray(int[] arr, int x){
        //normal binary search
        int low = 0; int high = arr.length - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            if (arr[mid] == x) return mid;
            //checking if left half is sorted, since it is sorted rotational array, so one side must be sorted definitely
            if (arr[mid] > arr[low]){
                //if it is left sorted, we check if x exists between that range
                if (x >= arr[low] && x < arr[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            //checking if right half is sorted, , since it is sorted rotational array, so one side must be sorted definitely
            else{
                if (x > arr[mid] && x <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }

    //A element is a peak element, if it's neighbour(left and right) element are smaller than current element
    public static int peakElement(int[] arr){
          //O(n) solution
/*        if (arr[0] > arr[1])
            return arr[0];

        if (arr[arr.length - 1] > arr[arr.length - 2])
            return arr[arr.length - 1];

        for (int i = 1; i < arr.length - 1; i++){
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1])
                return arr[i];
        }
        return -1;
       */

        //O(log n) Solution
        int low = 0; int high = arr.length - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            if ((mid == 0 || arr[mid] >= arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] >= arr[mid + 1]))
                return arr[mid];
            if (mid > 0 && arr[mid - 1] >= arr[mid])
                high = mid -1;
            else
                low = mid + 1;
        }
        return -1;
    }

    //Given Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
    //Input: [1, 2, 3, 4, 6], target=6 Output: [1, 3] Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
    //Input: [2, 5, 9, 11], target=11 Output: [0, 2] Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
    //(check hashing problems section - pairWithGivenSum for unsorted two sum array problem)
    public static int[] twoSumInSortedArray(int[] arr,int x){
        //Two pointer approach(sorted array)
        //TC-O(n), SC-O(1)
        int left = 0; int right = arr.length - 1;
        while (left < right){
            int currentSum = arr[left] + arr[right];
            if (currentSum == x)
                return new int[]{left, right};

            if(currentSum > x)
                right--;
            else
                left++;
        }
        return new int[]{-1, -1};
    }

    //Find Repeating elements
    //Slow and Fast Pointer Approach
    public static int repeatingElements(int[] arr){
        //O(n) Solution, O(1) Space, Original array is not modified
        //we increase slow and fast by +1 because, if we don't do it, it will cause unnecessary loops within it.
        //for eg: {0,2,1,3,5,4,6,2} - here first element is 0, so if we dont increase slow by 1, we will begin with first element, we will go to zero
        // again we will find a value with index zero, so we will have a self loop here
        //Let's see another example, {1,0,2,2,2} - we begin with first element, we go to index 1, and we find value zero, so we go to index 1,
        //again we see value 1, so we go to index 0, so the loop will be continuing between 0->1
        int slow = arr[0] + 1;
        int fast = arr[0] + 1;
        do{
            slow = arr[slow] + 1;
            fast = arr[arr[fast] + 1] + 1;
        }while (slow != fast);

        slow = arr[0] + 1;
        while (slow != fast){
            slow = arr[slow] + 1;
            fast = arr[fast] + 1;
        }
        return slow - 1;
    }

    private static boolean isPossible(ArrayList < Integer > A, int pages, int students) {
        int cnt = 0;
        int sumAllocated = 0;
        for (int i = 0; i < A.size(); i++) {
            if (sumAllocated + A.get(i) > pages) {
                cnt++;
                sumAllocated = A.get(i);
                if (sumAllocated > pages) return false;
            } else {
                sumAllocated += A.get(i);
            }
        }
        if (cnt < students) return true;
        return false;
    }

    //Allocate minimum number of pages.
    public static int minPages(int[] arr, int k){
        int n = arr.length;
        int sum = 0; int max = 0;
        for (int i = 0; i < n; i++){
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }
        int low = max; int high = sum; int res = -1;
        while (low <= high){
            int mid = (low + high) / 2;
            if (isPossible(arr, mid, k)){
                res = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return res;
    }

    private static boolean isPossible(int[] arr, int mid, int k) {
        int requiredStudent = 1; int sum = 0;
        for (int i = 0; i < arr.length; i++){
            if (sum + arr[i] > mid){
                requiredStudent++;
                sum = arr[i];
            }
            else sum += arr[i];
        }
        return (requiredStudent <= k);
    }

    public static void intersectionOfTwoSortedArrays(int[] arr1, int[] arr2){
        //O(n * m) Solution
        /*for (int i = 0; i < arr1.length; i++){
            if (i > 0 && arr1[i] == arr1[i - 1]) continue;
            for (int j = 0; j < arr2.length; j++){
                if (arr1[i] == arr2[j]){
                    System.out.print(arr1[i] + " ");
                    break;
                }
            }
        }
         */

        //O(m + n) Solution
        int i = 0; int j = 0;
        while (i < arr1.length && j < arr2.length){
            if (i > 0 && arr1[i] == arr1[i - 1]){
                i++;
                continue;
            }
            if (arr1[i] > arr2[j]) j++;
            else if (arr1[i] < arr2[j]) i++;
            else{
                System.out.print(arr1[i] + "  ");
                i++;
                j++;
            }
        }
    }

    public static void unionOfTwoSortedArrays(int[] arr1, int[] arr2){
        //O(m + n) Solution
        int i = 0; int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (i > 0 && arr1[i] == arr1[i - 1]){
                i++;
                continue;
            }
            if (j > 0 && arr2[j] == arr2[j - 1]){
                j++;
                continue;
            }
            if (arr1[i] < arr2[j])
                System.out.print(arr1[i++] + " ");
            else if (arr1[i] > arr2[j])
                System.out.print(arr2[j++] + " ");
            else if (arr1[i] == arr2[j]) {
                System.out.print(arr1[i] + " ");
                i++; j++;
            }
        }

        while (i < arr1.length){
            if (i > 0 && arr1[i] == arr1[i - 1])
                i++;
            else System.out.print(arr1[i++] + " ");
        }

        while (j < arr2.length){
            if (j > 0 && arr2[j] == arr2[j - 1])
                j++;
            else System.out.print(arr2[j++] + " ");
        }
    }

    //Count Inversions in an array
    public static int countInversions(int[] arr, int left, int right){
        //O(n^2) Solution
        /* int res = 0;
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] > arr[j])
                    res++;

        return res;
         */

        //Time - O(n log n), Space - O(n)
       int res = 0;
        if (left < right){
            int mid =  left + (right - left) / 2; //or left + (right - left) / 2
            res += countInversions(arr,left, mid);
            res += countInversions(arr, mid + 1, right);
            res += countAndMerge(arr, left, mid, right);
        }
        return res;
    }
    private static int countAndMerge(int[] arr, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[left + i];
        for (int i = 0; i < n2; i++)
            rightArr[i] = arr[mid + 1 + i];

        int res = 0; int i = 0; int j = 0; int k = left;
        while (i < n1 && j < n2){
            if (leftArr[i] <= rightArr[j])
                arr[k] = leftArr[i++];
            else{
                arr[k] = rightArr[j++];
                res = res + (n1 - i);
            }
            k++;
        }
        while (i < n1){
            arr[k] = leftArr[i++];
            k++;
        }

        while (j < n2){
            arr[k] = rightArr[j++];
            k++;
        }
        return res;
    }

    //Find Kth smallest element in an array
    //input - [10, 5, 30, 12], k = 2, Output - Kth smallest element is 10
    //input - [30, 20, 5, 10, 8], k = 4, Output - Kth smallest element is 20
    public static int KthSmallestElement(int[] arr, int k) {
        //Naive Solution - O(n log n)
/*      Arrays.sort(arr);
        return arr[k - 1];
*/
        //O(n^2) Solution - even though it's n^2, this solution works much better than naive solution on average
        //This algorithm is called QuickSelect
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int p = lomutoPartition(arr, left, right);
            if (p == k - 1) return arr[p];
            else if (p > k - 1) right = p - 1;
            else left = p + 1;
        }
        return -1;
    }
    public static int lomutoPartition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int boundary = start - 1;

        for (int i = start; i <= end; i++)
            if (arr[i] <= pivot)
                swap(arr, i, ++boundary);

        return boundary;
    }
    private static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    //Chocolate distribution problem
    //input1-[7,3,2,4,9,12,56], m = 3, output = 2
    //input2-[3,4,1,9,56,7,9,12], m = 5, output = 6
    //Explanation - input array contains number of chocolates in a packet, we need to distribute a packet to m children
    //each child can be given only one packet. we should minimise the difference between minimum chocolate a child gets and max chocolate another child gets
    //in this example, we distribute chocolate to 3 children 3,2,4, and difference between max and min chocolate is minimum, 4-2 = 2
    //2 is the minimum value among all combinations
    //Time - O(n log n), Space - O(1)
    public static int chocolateDistribution(int[] arr, int m){
        Arrays.sort(arr);
        int res = arr[m - 1] - arr[0];
        for (int i = 1; (i + m - 1) < arr.length - 1; i++)
            res = Math.min(res, (arr[i + m - 1] - arr[i]));
        return res;
    }

    //sort array with two types of elements
    public static void separatePositiveAndNegative(int[] arr){
        //O(n) Time and O(1) Space
        if (arr[0] > 0)
            swap(arr, 0, 1);

        int j = 1;
        for (int i = 1; i < arr.length; i++)
            if (arr[i] < 0)
                swap(arr, j++, i);

        System.out.println(Arrays.toString(arr));
    }

    //Sort an array of 0s, 1s and 2s - sort array with three types of elements (Dutch National flag Problem)
    //Given an array A[] consisting only 0s, 1s and 2s. The task is to write a function that sorts the given array. The functions should put all 0s first, then all 1s and all 2s in last.
    //Input: [1, 0, 2, 1, 0] Output: [0 0 1 1 2],  Input: [2, 2, 0, 1, 2, 0]Output: [0 0 1 2 2 2 ]
    public static void sortZerosOnesAndTwos(int[] arr){
        //TC- O(n), SC-O(1)
        //Dutch National flag Problem - The algorithm states that, all the zeros will be in the range [0 to low-1]i.e, before low and all the two's will be in range [high+1 to n]i.e, after high and all the ones will be in [low to mid-1]i.e, between 0's and 2's
        //We can use a Two Pointers approach while iterating through the array. Let’s say the two pointers are called low and high which are pointing to the first and the last element of the array respectively.
        //So while iterating, we will move all 0s before low and all 2s after high so that in the end, all 1s will be between low and high.
        int low = 0; //low pointer to swap 0's
        int mid = 0; //mid pointer to check value of current element, and swap with low and high
        int high = arr.length - 1; //high pointer to swap 2's

        //if mid is greater than high, then we have sorted the array, so break the loop
        while (mid <= high){
            //if currentElement is zero, we swap low with mid, because we move zeros before low. after swapping increment low and mid
            if (arr[mid] == 0)
                swap(arr, low++, mid++);
            //if currentElement is mid, then we just increase the mid, because one's should be in-between zero's and two's
            else if (arr[mid] == 1)
                mid++;
            //if currentElement is two, we swap low with high, because we move two's after high, after swapping decrement high
            else
                swap(arr, mid, high--);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int minimumDifferenceInArray(int[] arr){
        //O(n^2) Solution
/*      int res = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                res = Math.min(res, Math.abs(arr[i] - arr[j]));

        return res;
 */
        //O(n log n) Solution
        int res = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++)
            res = Math.min(res, arr[i] - arr[i - 1]);

        return res;
    }

    //Merge Overlapping intervals
    public static void mergeIntervals(Interval[] arr) {
        //O(n log n) Solution
        Arrays.sort(arr, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        int index = 0;
        for (int i = 1; i < arr.length; i++){
            if (arr[index].end >= arr[i].start){
                arr[index].start = Math.min(arr[index].start, arr[i].start);
                arr[index].end = Math.max(arr[index].end, arr[i].end);
            }
            else{
                index++;
                arr[index] = arr[i];
            }
        }
        for (int i = 0; i <= index; i++)
            System.out.print("[" + arr[i].start + "," + arr[i].end + "]");
    }

    //Meeting the maximum guests
    public static int maxGuests(int[] arrival, int[] departure){
        //O(n log n) Solution
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int res = 1; int arrivalIndex = 1; int departureIndex = 0; int curr = 1;

        while (arrivalIndex < arrival.length && departureIndex < departure.length){
            if (arrival[arrivalIndex] <= departure[departureIndex]){
                curr++;
                arrivalIndex++;
            } else{
                curr--;
                departureIndex++;
            }
            res = Math.max(res, curr);
        }
        return res;
    }

    /* Sliding window Problems */

    //find the average of all contiguous subarrays of size ‘K’ in it.
    //Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
    //For the first 5 numbers (subarray from index 0-4), the average is: (1+3+2+6-1)/5 => 2.2(1+3+2+6−1)/5=>2.2
    //The average of next 5 numbers (subarray from index 1-5) is: (3+2+6-1+4)/5 => 2.8(3+2+6−1+4)/5=>2.8
    //For the next 5 numbers (subarray from index 2-6), the average is: (2+6-1+4+1)/5 => 2.4(2+6−1+4+1)/5=>2.4 and so on.
    //Output: [2.2, 2.8, 2.4, 3.6, 2.8]
    public static double[] averageOfSubarrayOfSizeK(int[] arr, int k){
        //O(N ∗ K) where ‘N’ is the number of elements in the input array, Space - O(k)
/*      double[] res =  new double[arr.length - k + 1];
        for (int i = 0; i <= arr.length - k; i++){
            double sum = 0;
            for (int j = i; j < i + k; j++)
                sum += arr[j];

            res[i] = sum / k;
        }
        return res;
 */
        //O(n) Solution - sliding window, O(k) Space
        double[] res = new double[arr.length - k + 1];
        int windowStart = 0; double windowSum = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            windowSum += arr[windowEnd];
            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if (windowEnd >= k - 1){
                res[windowStart] = windowSum / k; // calculate the average
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }
        return res;
    }

    //Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
    //Input: [2, 1, 5, 1, 3, 2], k=3     Output: 9
    //Explanation: Subarray with maximum sum is [5, 1, 3].
    public static int findMaxSubArraySumOfSizeK(int[] arr, int k) {
        // Naive Solution - time complexity O(N * K)
/*      int maxSum = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
 */
        //O(n) Solution - Sliding window pattern
        int windowSum = 0; int maxSum = 0; int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            windowSum += arr[windowEnd];  // add the next element
            if (windowEnd >= k - 1) {
                maxSum = Math.max(windowSum, maxSum);
                windowSum -= arr[windowStart++]; // subtract the element going out and slide the window ahead by windowStart++
            }
        }
        return maxSum;
    }

    //Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
    //Input: [2, 1, 5, 2, 3, 2], S=7 //Output: 2 //Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2]
    //Input: [2, 1, 5, 2, 8], S=7 //Output: 1 //Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
    //Input: [3, 4, 1, 1, 6], S=8 //Output: 3 //Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].
    public static int findMinSubArrayLengthEqualToK(int[] array, int k){
        //O(n^2)
   /*     int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++){
            int sum = array[i];
            if (array[i] >= k) return 1;
            for (int j = i + 1; j < array.length; j++){
                sum += array[j];
                if (sum >= k) {
                    minLength = Math.min(minLength, (j - i) + 1);
                    break;
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    */

        //The time complexity of the above algorithm will be O(N). The outer for loop runs for all elements and the inner while loop processes
        //each element only once, therefore the time complexity of the algorithm will be O(N+N) which is asymptotically equivalent to O(N).
        int windowStart = 0; int windowSum = 0; int minLength = Integer.MAX_VALUE;
        for (int windowEnd = 0; windowEnd < array.length; windowEnd++){
            windowSum += array[windowEnd];
            while (windowSum >= k){
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= array[windowStart++];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    //Longest Substring with K Distinct Characters - Given a string, find the length of the longest substring in it with no more than K distinct(unique) characters.
    //Input: String="araaci", K=2 //Output: 4 //Explanation: The longest substring with no more than '2' distinct characters is "araa".
    //Input: String="araaci", K=1 //Output: 2 //Explanation: The longest substring with no more than '1' distinct characters is "aa".
    //Input: String="cbbebi", K=3 //Output: 5 //Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
    public static int LongestSubstringKDistinct(String str, int k) {
        //The time complexity of the above algorithm will be O(N). The outer for loop runs for all elements and the inner while loop processes
        //each element only once, therefore the time complexity of the algorithm will be O(N+N) which is asymptotically equivalent to O(N).
        //The space complexity of the algorithm is O(K), as we will be storing a maximum of ‘K+1’ characters in the HashMap.
        if (str == null || str.length() == 0 || str.length() < k)
            throw new IllegalArgumentException();

        Map<Character, Integer> frequencyMap = new HashMap<>();
        int maxLength = 0; int windowStart = 0;
        // in the following loop we'll try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            frequencyMap.put(rightChar, frequencyMap.getOrDefault(rightChar, 0) + 1);
            // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
            while (frequencyMap.size() > k){
                char leftChar = str.charAt(windowStart);
                frequencyMap.put(leftChar, frequencyMap.get(leftChar) - 1);
                if (frequencyMap.get(leftChar) == 0)
                    frequencyMap.remove(leftChar);
                windowStart++; // shrink the window
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static int longestNoRepeatSubstring(String s){
        int maxLength = 0; int windowStart = 0;
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            if (frequencyMap.containsKey(rightChar)){
                windowStart = Math.max(windowStart, frequencyMap.get(rightChar) + 1);
            }
            frequencyMap.put(rightChar, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    //Longest Substring with Same Letters after Replacement
    //Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.
    //Input: String="aabccbb", k=2 //Output: 5 //Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
    //Input: String="abbcb", k=1 //Output: 4 //Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
    //Input: String="abccde", k=1 //Output: 3 //Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
    public static int characterReplacement (String str, int k){
        //The time complexity of the above algorithm will be O(N) where ‘N’ is the number of letters in the input string.
        //space complexity will be O(26), to store each letter’s frequency in the HashMap, which is asymptotically equal to O(1).
        int windowStart = 0; int maxLength = 0; int maxRepeatLetterCount = 0;
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char currChar = str.charAt(windowEnd);
            frequencyMap.put(currChar, frequencyMap.getOrDefault(currChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, frequencyMap.get(currChar));

            // current window size is from windowStart to windowEnd, overall we have a letter which is
            // repeating 'maxRepeatLetterCount' times, this means we can have a window which has one letter repeating 'maxRepeatLetterCount' times and the remaining letters we should replace.
            // if the remaining letters are more than 'k', it is the time to shrink the window as we are not allowed to replace more than 'k' letters
            if (windowEnd - windowStart + 1 - maxRepeatLetterCount > k){
                char leftChar = str.charAt(windowStart);
                frequencyMap.put(leftChar, frequencyMap.get(leftChar) - 1);
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    //Longest Subarray with Ones after Replacement
    //Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s.
    //Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2 //Output: 6 //Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
    //Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3 //Output: 9 //Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.
    public static int replacingOnes(int[] arr, int k){
        //Time Complexity - O(N), Space Complexity - O(1)
        int windowStart = 0; int maxLength = 0; int maxOnesCount = 0;

        // try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            if (arr[windowEnd] == 1)
                maxOnesCount++;

            // current window size is from windowStart to windowEnd, overall we have a maximum of 1s repeating a maximum of 'maxOnesCount' times, this means that we can have a window with
            // 'maxOnesCount' 1s and the remaining are 0s which should replace with 1s. now, if the remaining 0s are more than 'k', it is the time to shrink the window as we are not allowed to replace more than 'k' Os
            if (windowEnd - windowStart + 1 - maxOnesCount > k){
                if (arr[windowStart] == 1)
                    maxOnesCount--;

                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    //Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’ in-place and return the new length of the array.
    //Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3 Output: 4 Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].
    //Input: [2, 11, 2, 2, 1], Key=2 Output: 2 Explanation: The first two elements after removing every 'Key' will be [11, 1].
    public static int removeKeysInArray(int[] arr, int key){
        //TC-O(n), SC-O(1)
        int res = 0;
        //iterate through array, and if curr element is not key, shift that to arr[res] and increment res. Finally return len of res(size of modified arr)
        for (int i = 0; i < arr.length; i++)
           if (arr[i] != key)
               arr[res++] = arr[i];

        return res;
    }

    //Squaring a Sorted Array
    //Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.
    //Input: [-2, -1, 0, 2, 3], Output: [0, 1, 4, 4, 9]  //Input: [-3, -1, 0, 1, 2] Output: [0 1 1 4 9]
    public static int[] makeSquaresInSortedArr(int[] arr) {
       //TC-O(n), SC-O(n)
       int[] squares = new int[arr.length];
       int highestSquareIndex = arr.length - 1;
       int left = 0;
       int right = arr.length - 1;
       while (left <= right){
           int leftSquare = arr[left] * arr[left];
           int rightSquare = arr[right] * arr[right];
           //if left square is higher insert left square value at square[highestSquareIndex] and increment left
           if (leftSquare > rightSquare){
               squares[highestSquareIndex--] = leftSquare;
               left++;
           }
           //else if right square is higher insert right square value at square[highestSquareIndex] and decrement left
           else {
               squares[highestSquareIndex--] = rightSquare;
               right--;
           }
       }
       return squares;
    }

    //Triplet Sum to Zero - Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
    //Input: [-3, 0, 1, 2, -1, 1, -2] Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1] Explanation: There are four unique triplets whose sum is equal to zero.
    //Input: [-5, 2, -1, -2, 3] Output: [[-5, 2, 3], [-2, -1, 3]] Explanation: There are two unique triplets whose sum is equal to zero.
    public static List<List<Integer>> tripletSumToZero(int[] arr){
        //TC-O(n^2) - Sorting the array will take O(N* logN).  Overall it will take O(N * logN + N^2), which is asymptotically equivalent to O(N^2)
        //SC - O(N)
        //Idea is first, we will sort the array and then iterate through it taking one number at a time. Let’s say during our iteration we are at number ‘X’, so we need to find ‘Y’ and ‘Z’ such that X + Y + Z == 0.
        //At this stage, our problem translates into finding a pair whose sum is equal to “−X” (as from the above equation Y + Z == −X).
        Arrays.sort(arr); //Sort the array first
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            // skip same element to avoid duplicate triplets, for eg: [-2, 0, 2] and [0, 2, -2]
            if (i > 0 && arr[i - 1] == arr[i])
                continue;

            searchPairs(arr, -arr[i], i + 1, triplets);
        }
        return triplets;
    }
    private static void searchPairs(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
        int right = arr.length - 1;
        while (left < right){
            int currentSum = arr[left] + arr[right];
            //if found the triplet
            if (currentSum == targetSum){
                triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                    left++;
                    right--;
                // skip same element to avoid duplicate triplets
                while (left < right && arr[left] == arr[left - 1])
                    left++;
                // skip same element to avoid duplicate triplets
                while (left < right && arr[right] == arr[right + 1])
                    right--;
            } else if (targetSum > currentSum)
                left++; // we need a pair with a bigger sum, so increment left
            else
                right--; // we need a pair with a smaller sum, so decrement right
        }
    }

    //Triplet Sum Close to Target
    //Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the target number as possible, return the sum of the triplet. If there are more than one such triplet, return the sum of the triplet with the smallest sum.
    //Input: [-2, 0, 1, 2], target=2 Output: 1 Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
    //Input: [-3, -1, 1, 2], target=1 Output: 0 Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
    //Input: [1, 0, 1, 1], target=100 Output: 3 Explanation: The triplet [1, 1, 1] has the closest sum to the target.
    public static int tripletSumCloseToTarget(int[] arr, int target){
        //TC- overall O(n^2), sorting and searching triplet will take O(n log n + n^2)
        //SC-O(1)
        Arrays.sort(arr); //sort the array first
        int closestSum = Integer.MAX_VALUE;
        //we use 2 pointer approach, we fix element at i, and move start and end and calculate sum
        for (int i = 0; i < arr.length - 2; i++) {
            int start = i + 1;
            int end = arr.length - 1;
            while (start < end){
                int currentSum = arr[i] + arr[start] + arr[end];
                //if sum = target return target
                if (currentSum == target)
                    return target;

                //else, find the difference between currentSum and target, which will give the closest value, for eg: if sum is 2 and target is 1, we do 2 - 1 = 1, so the closestSum will be 1, in next iteration if currentSum-target is smaller than 1, we update currentSum to that value
                //we use abs, because difference might be negative.
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                //if currentSum is greater than target, we decrement end, because we want sum closer to target
                if (currentSum > target)
                    end--;
                else
                    start++;
            }
        }
        return closestSum;
    }

    //Triplets with Smaller Sum - Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices. Write a function to return the count of such triplets.
    //Input: [-1, 0, 2, 3], target=3 Output: 2 Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
    //Input: [-1, 4, 2, 1, 3], target=5 Output: 4 Explanation: There are four triplets whose sum is less than the target:[-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
    //Input: [5, 1, 3, 4, 7], target=12 Output: 4 Explanation: There are four triplets whose sum is less than the target:(1, 3, 4), (1, 3, 5), (1, 3, 7) and (1, 4, 5)
    public static int tripletsWithSmallerSum(int[] arr, int target){
        //TC- overall O(n^2), sorting and searching triplet will take O(n log n + n^2)
        //SC-O(1)
        Arrays.sort(arr); //sort the array first
        int smallSumCount = 0; //count of triplets smaller than target
        for (int i = 0; i < arr.length - 2; i++) {
            //we fix the element at arr[i] and use 2 pointer approach from i + 1 to n
            int start = i + 1;
            int end = arr.length - 1;
            while (start < end){
                int currentSum = arr[i] + arr[start] + arr[end];
                //if currentSum is small than target, that means we have found a triplet sum, smaller than target
                //so if arr[i] + arr[start] + arr[end] is a smaller sum, then if we decrement end and calculate sum, it will be definitely smaller than target, because array is sorted
                //eg: [-1, 1, 2, 3, 4], target=5, -1 + 1 + 4 = 4, smaller than target, so if we decrement end now, -1 + 1 + 3 = 3, will also be smaller than target. so we can say that (end-start) will give total count of triplets smaller than target
                if (currentSum < target) {
                    smallSumCount += (end - start);
                    start++; //increment start to check next triplet
                }
                else
                    end--; //else if target is greater than sum, we need a value smaller than target, so we decrement end
            }
        }
        return smallSumCount;
    }

    //Subarrays with Product Less than a Target(k) - Given an array with positive numbers and a target number, find all of its contiguous subarrays whose product is less than the target number.
    //Input: [2, 5, 3, 10], target=30 Output: 6 Explanation: There are six contiguous subarrays whose product is less than the target. [2], [5], [2, 5], [3], [5, 3], [10]
    //Input: [8, 2, 6, 5], target=50 Output: 7 Explanation: There are seven contiguous subarrays whose product is less than the target. [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
    //Input : arr[] = [1, 2, 3, 4] target = 10 Output : 7 The subarrays are {1}, {2}, {3}, {4} {1, 2}, {1, 2, 3} and {2, 3}
    public static int subarrayProductLessThanK(int[] arr, int k){
        //TC-O(n^2), SC-O(1)
/*        int count = 0; int product;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < k)
                count++;
            product = arr[i];
            for (int j = i + 1; j < arr.length; j++){
                product *= arr[j];
                if (product >= k)
                    break;

                count++;
            }
        }
        return count;
 */

        //sliding window approach
        //TC-O(n), SC-O(1)
        if (k <= 1) //if k is 1 or less than 1, we will not have a product less than 1, so return 0
            return 0;
        int product = 1;
        int count = 0; //subarray count
        int windowStart = 0;
        //we start from 1st element in array
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            //multiply product with arr[windowEnd] in each iteration
            product *= arr[windowEnd];

            //if product is greater than k, we slide our window, but removing element at arr[windowStart]
            while (windowStart < windowEnd && product >= k)
                product /= arr[windowStart++];

            //if the product is less than k, we add it to count.
            //windowEnd - windowStart + 1, means that how many contiguous arrays does this step produce? It is: (windowEnd-windowStart) + 1 -For  example nums = [10,5,2,6]: If we start at the 0th index, [10,5,2,6], the number of intervals is obviously 1.
            //If we move to the 1st index, the window is now [10,5,2,6]. The new intervals created are [5] and [10,5], so we add 2. Now, expand the window to the 2nd index: [10,5,2,6]. The new intervals are [2], [5,2], and [10,5,2], so we add 3.
            //The pattern should be obvious by now; we add right - left + 1 to the output variable every loop!
            //since the product of all numbers from left to right is less than the target therefore, all subarrays from lef to right will have a product less than the target too; to avoid duplicates, we will start with a subarray containing only arr[right] and then extend it
            if (product < k)
                count += windowEnd - windowStart + 1;

        }
        return count;
    }

    //Minimum Window Sort - Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.
    //Input: [1, 2, 5, 3, 7, 10, 9, 12] Output: 5 Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted
    //Input: [1, 3, 2, 0, -1, 7, 10] Output: 5 Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted
    //Input: [1, 2, 3] Output: 0 Explanation: The array is already sorted, Input: [3, 2, 1] Output: 3 Explanation: The whole array needs to be sorted.
    public static int minimumWindowSort(int[] arr){
        //TC-O(n), SC-O(1)
        int low = 0;
        int high = arr.length - 1;

        //From the beginning and end of the array, find the first elements that are out of the sorting order. The two elements will be our candidate subarray.
        //find the first number out of sorting order from the beginning
        while (low < high && arr[low] <= arr[low + 1])
            low++;
        if (low == high) // if the array is sorted
            return 0;
        // find the first number out of sorting order from the end
        while (high > 0 && arr[high] >= arr[high - 1])
            high--;

        // find the maximum and minimum of the subarray
        int subarrayMax = Integer.MIN_VALUE;
        int subarrayMin = Integer.MAX_VALUE;
        for (int i = low; i <= high; i++){
            subarrayMax = Math.max(subarrayMax, arr[i]);
            subarrayMin = Math.min(subarrayMin, arr[i]);
        }

        // extend the subarray towards left to include any number which is bigger than the minimum of the subarray
        while (low > 0 && arr[low - 1] > subarrayMin)
            low--;
        // extend the subarray towards right to include any number which is smaller than the maximum of the subarray
        while (high < arr.length - 1 && arr[high + 1] < subarrayMax)
            high++;

        return high - low + 1;
    }
}

class Interval{
    int start; int end;
    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}