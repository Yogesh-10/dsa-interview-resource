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

    //15. Find the length of Maximum consecutive ones in binary array
    //Input:[1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1], Output: 4
    //Input:[1, 1, 1, 1], Output: 4 //Input:[0 , 0, 0], Output: 0 //Input:[0 ,1, 1, 0, 1, 0], Output: 2
    public static int maxConsecutiveOnes(int[] arr){
        //O(n^2) solution
/*      int res = 0;
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
        int res = 0; int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
                res = Math.max(res, count);
            }
            else
                count = 0;
        }
        return res;
    }

    //16. Find the maximum subarray sum.
    //Input:[-3, 8, -2, 4, -5, 6], Output: 11, 8-2+4-5+6=11
    //Input:[-6, -1, -8], Output: -1, is the single subarray with max value
    public static int maxSubarraySum(int[] arr){
        //TC-O(n^2) SC-O(1)
/*        int res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int curr = 0;
            for (int j = i; j < arr.length; j++) {
                curr += arr[j];
                res = Math.max(res, curr);
            }
        }
        return res;
 */
        //TC-O(n), SC-O(1) //kadane's algorithm
        int res = arr[0];
        int maxEnding = arr[0];
        for (int i = 1; i < arr.length; i++){
            //we extend the previous subarray by (arr[i] + maxending), or we start new subarray from arr[i], if arr[i] is greater then (arr[i] + maxending)
            //maxEnding will have the sum of subarray we have visited so far
            maxEnding = Math.max(arr[i] + maxEnding, arr[i]);
            res = Math.max(res, maxEnding);
        }
        return res;

        //another similar approach //TC-O(n), SC-O(1) //kadane's algorithm
/*      int sum = 0;
        int res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; //we add sum in each iteration
            res = Math.max(sum, res); //if sum is greater than res, we update res and extend subarray
            if (sum < 0) //if sum goes below 0, that means sum is negative and we dont carry forward sum, so we set sum to 0
                sum = 0;
        }
        return res;
 */
    }

    //17. Find the length  of longest even odd subarray
    public static int longestEvenOddSubarray(int[]arr){
        //TC-O(n^2), SC-O(1)
/*        int res = 1;
        for (int i = 0; i < arr.length; i++){
            int curr = 1;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] % 2 == 0 && arr[j - 1] % 2 != 0 || arr[j] %2 != 0 && arr[j - 1] % 2 == 0)
                    curr++;
                else break;
            }
            res = Math.max(res, curr);
        }
        return res;
 */
        //O(n) solution - kadane's algorithm
        int res = 1;
        int curr = 1;
        for (int i = 1; i < arr.length; i++){
            //if it's alternative we extend previous subarray and increase curr
            if ((arr[i] % 2 == 0 && arr[i - 1] % 2 != 0) || (arr[i] %2 != 0 && arr[i - 1] % 2 == 0)){
                curr++;
                res = Math.max(res, curr);
            }
            //or else we start new subarray and reset curr to 1
            else curr = 1;
        }
        return res;
    }

    //18. Find the maximum circular subarray sum.
    //Input: [8, -8, 9, -9, 10, -11, 12], Output:22 (8, -8, 9, -9, 10, -11, 12)
    //Input: [10, -3, -4, 7, 6, 5, -4, -1], Output:23 (7 + 6 + 5 - 4 -1 + 10)
    //Input: [3,4,6,-2], Output: 10 (4+6), output can also contain normal maximum subarray, it doesn't need to be only circular, we need the maximumSubarraySum, either it's normal or circular
    public static int maximumCircularSubarraySum(int[] arr){
//        TC-O(n^2) SC-O(1)
/*      int res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int currMax = arr[i];
            int currSum = arr[i];
            for (int j = 1; j < arr.length; j++){
                //when calculate index, so that index comes back to first position in array, after reaching the last
                int index = (i + j) % arr.length;
                currSum += arr[index];
                currMax = Math.max(currMax, currSum);
            }
            res = Math.max(res, currMax);
        }
        return res;
 */

        //O(n) solution - using kadane's algorithm
/*      //in this solution we can find maxSubarraySum in circular array by finding minSumSubarray and subtracting it with totalSum of array
        //So there are two case. Case 1. The first is that the subarray take only a middle part, and we can find that using maxSubarraySum(kadane's algo).
        //Case2. The second is that the subarray take a part of head array and a part of tail array. (circular sum subarray), We can transfer this case to the first one. The maximum result equals to the total sum minus the minimum subarray sum.
        //we first find the maxSubarraySum in the array, without checking circular array.(using kadane's algorithm) because the array can also have normal maxSubarraySum
        int maxNormalSubarray = maxSubarraySum(arr);

        //if it's negative then all elements in array is negative, so we return max of normal subarray sum
        if (maxNormalSubarray < 0)
            return maxNormalSubarray;

        //we find the total sum of array, and subtract it with minSumSubarray value
        //Modified Kadane's algo - instead of writing other function(kadane's algo) for finding minSubarraySum, we can reuse maxSubarraySum function
        //the trick here is, we invert all the elements of the array from +ve to -ve and vice versa, and find maxSubarraySum value, which is a result of minSubarraySum value(because it's inverted)
        int arrSum = 0;
        for (int i = 0; i < arr.length; i++){
            arrSum += arr[i]; //totalSum
            arr[i] = -arr[i]; //inverting elements in arr
        }

        //instead of subtracting(minSumSubarray and totalSum of array) we add, because we have inverted and found the maxSumSubarray(which is minSumSubarray), for eg:-6 is value of minSum, but we have inverted and found result as 6, so we add
        int maxCircularSubarray = arrSum + maxSubarraySum(arr);
        return Math.max(maxNormalSubarray, maxCircularSubarray); //return max from normalSubArray and circularSubarray
 */
        //O(N) - one pass - more efficient solution, SC-O(1)
        int total = 0, maxSum = arr[0], curMax = 0, minSum = arr[0], curMin = 0;
        for (int i = 0; i < arr.length; i++) {
            //find maxSumSubarray (kadane's algo)
            curMax = Math.max(curMax + arr[i], arr[i]);
            maxSum = Math.max(maxSum, curMax);
            //find minSumSubarray (kadane's algo)
            curMin = Math.min(curMin + arr[i], arr[i]);
            minSum = Math.min(minSum, curMin);
            //total sum of array
            total += arr[i];
        }
        //if maxSum is positive then return max(maxSum, total - minSum), else if maxSum is negative that means all the values in arr are negative, so simply return maxSum
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }

    //19. Find the majority element in array - The majority element is the element that appears more than ⌊n / 2⌋ times
    //Input : {3, 3, 4, 2, 4, 4, 2, 4, 4} Output : 4(index of array) Explanation: The frequency of 4 is 5 which is greater than the half of the size of the array size.
    //Input : {3, 3, 4, 2, 4, 4, 2, 4} Output : No Majority Element Explanation: There is no element whose frequency is greater than the half of the size of the array size.
    public static int majorityElement(int[] arr){
          //TC-O(N^2), SC-O(1)
/*        for (int i = 0; i < arr.length;i++){
            int count = 1;
            for (int j = i + 1; j < arr.length;j++){
                if (arr[i] == arr[j]){
                    count++;
                }
            }
            if (count > arr.length/2) return i;
        }
        return -1;
 */
        //O(n) solution - Moore's voting algorithm - This algorithm works on the fact that if an element occurs more than N/2 times, it means that the remaining elements other than this would definitely be less than N/2. So let us check the proceeding of the algorithm.
        //choose a candidate from the given set of elements if it is the same as the candidate element, increase the votes.
        //Otherwise, decrease the votes if votes become 0, select another new element as the new candidate.
        //Intuition of Algorithm: When the elements are the same as the candidate element, votes are incremented when some other element is found not equal to the candidate element. We decreased the count. This actually means that we are decreasing the priority of winning ability of the selected
        //candidate, since we know that if the candidate is a majority it occurs more than N/2 times and the remaining elements are less than N/2. We keep decreasing the votes since we found some different element than the candidate element. When votes become 0, this actually
        //means that there are the same number of different elements, which should not be the case for the element to be the majority element. So the candidate element cannot be the majority, so we choose the present element as the candidate and continue the same till all the
        //elements get finished. The final candidate would be our majority element. We check using the 2nd traversal to see whether its count is greater than N/2. If it is true, we consider it as the majority element.
        int count = 1; //for tracking the count of element
        int res = 0; //for which element we are counting
        //find the candidate, that appears maximum
        for (int i = 1; i < arr.length; i++){
            //If the traversing integer of array and Element are same increase Count by 1
            if (arr[res] == arr[i])
                count++;
            //If they are different decrease Count by 1
            else
                count--;

            //If Count is 0 then initialize the current traversing integer of array as Element
            if (count == 0) {
                count = 1;
                res = i;
            }
        }

        //check if the candidate is actually a majority
        //this step is not needed if array always contains a majority element.
        count = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[res] == arr[i])
                count++;

        if (count <= arr.length / 2)
            res = -1;

        return res; //majority element
    }

    //20. Equilibrium index of an array - Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes
    //Input: A[] = {-7, 1, 5, 2, -4, 3, 0} Output: true, 3 is an equilibrium index, because: A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
    //Input: A[] = {1, 2, 3} Output: false
    //Input: A[] = {4, 2, -2} Output: true, 0 is a equilibrium index, because on left of 4, there is nothing so it's considered as zero, on right side of 4, 2-2=0
    //Input: A[] = {2, -2, 4} Output: true, 2 is a equilibrium index, because on left of 4, 2-2=0, on right side of 4 there is nothing so it's considered as zero
    public static boolean isEquilibriumPoint(int[] arr){
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

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++){
            //we calculate lSum as we traverse and we get right sum by,
            //subtracting sum - arr[i] in each iteration, which will gives us rightSum
            int rightSum = sum - arr[i];
            if (leftSum == rightSum)
                return true;

            leftSum += arr[i];
            sum -= arr[i];
        }
        return false;
    }

    //21. Most frequently occurring item in an array
    //Input: [1, 3, 1, 3, 2, 1], Output: 1, 1 is the most frequently occurring item in this array
    //Input: [0, -1, 10, 10, -1, 10, -1, -1, -1, 1], Output: -1
    //Input: [0, -1, 10, 10, -1, 10, -1, -1, -1, 1], Output: -1 //Input: [0], Output: 0
    public static int mostFreqOccurringItem(int[] arr){
        //TC-O(n^2), SC-O(1)
/*        int res = 1;
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
 */
        //TC-O(n), SC-O(n)
        Map<Integer, Integer> map = new HashMap<>();
        int max = 1; int res = 0;
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            if (map.get(arr[i]) > max){
                max = map.get(arr[i]);
                res = arr[i];
            }
        }
        return res;
    }

    //22. Common Elements in two sorted arrays
    //Input - array1 = {1, 3, 4, 6, 7, 9}, array2 = {1, 2, 4, 5, 9, 10}, Output: [1, 4, 9]
    //Input - array1 = {1, 2, 9, 10, 11, 12}, array2 = {0, 1, 2, 3, 4, 5, 8, 9, 10, 12, 14, 15}, Output: [1, 2, 9, 10, 12]
    //Input - array1 = {0, 1, 2, 3, 4, 5}, array2 = {6, 7, 8, 9, 10, 11}, Output: []
    public static void commonElementsIn2SortedArrays(int[] arr1, int[] arr2){
        //TC-O(n^2) SC-O(1)
/*        for (int i = 0; i < arr1.length; i++)
            for (int j = 0; j < arr2.length; j++)
                if (arr1[i] == arr2[j])
                    System.out.print(arr1[i] + " ");
 */
        //TC-O(n), SC-O(1) , Two pointer approach
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

    //23. Is one array rotation of other
    //Input: arr1 = {1, 2, 3, 4, 5, 6, 7}, arr2 = {4, 5, 6, 7, 1, 2, 3}, Output: true
    //Input: arr1 = {1, 2, 3, 4, 5, 6, 7}, arr2 = {4, 5, 6, 7, 8, 1, 2, 3}, Output: false
    //Input: arr1 = {1, 2, 3, 4, 5, 6, 7}, arr2 = {1, 2, 3, 4, 5, 6, 7}, Output: true
    public static boolean isOneArrayRotationOfOther(int[] arr1, int[] arr2){
        //TC-O(n), SC-O(1)
        int m = arr1.length; int n = arr2.length;
        if (n != m) return false;

        int target = arr1[0]; //set 1st element in first arr as target
        int key = -1;
        for (int k = 0; k < n; k++){
            //if we find target in second arr, set that index as key
            if (arr2[k] == target){
                key = k;
                break;
            }
        }
        //if we didn't find the target we return false
        if (key == -1) return false;

        //iterate through the arr, and compare arr1 and arr2, if value doesn't match return false
        for (int i = 0; i < m; i++){
            int index = (key + i) % n; //or use (key % n) and increment key++ in every iteration
            if (arr1[i] != arr2[index])
                return false;
        }
        return true;
    }

    //24. Remove Even Integers from array - Given an array of size n, remove all even integers from it.
    //Input: arr = {1, 2, 4, 5, 10, 6, 3}, Output: {1, 5, 3}
    public static void removeEvenItems(int[] arr){
        //TC-O(n), SC-O(1)
        int evenPointer = 0;
        int i = 0;
        while (i < arr.length){
            if (arr[i] % 2 == 0){
                i++;
            }
            else{
                arr[evenPointer++] = arr[i++];
            }
        }
        for (int j = 0; j < evenPointer; j++) {
            System.out.print(arr[j] + " ");
        }

        //TC-O(n), SC-O(1)
        //another approach to remove even items and make it zero.
/*        int index = 0;
        int size = arr.length;
        for (int i = 0; i < arr.length; i++){
           if (arr[i] % 2 == 1){
               arr[index] = arr[i];
               if (i != index) {
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
 */
    }

    //25. Merge two sorted arrays
    //Input - arr1 = {1, 3, 4, 5} arr2 = {2, 6, 7, 8}, Output: arr = {1, 2, 3, 4, 5, 6, 7, 8}
    public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2){
        //TC-O((n1+n2) log (n1+n2)), SC-O(n1+n2)
/*      int n1 = arr1.length;
        int n2 = arr2.length;
        int[] temp = new int[n1 + n2];
        for (int i = 0; i < arr1.length; i++)
            temp[i] = arr1[i];

        for (int i = 0; i < arr2.length; i++)
            temp[n1 + i] = arr2[i];

        Arrays.sort(temp);
        return temp;
 */

        //Time Complexity : O(n1 + n2)
        //Auxiliary Space : O(n1 + n2)
        int i = 0; int j = 0; int index = 0;
        int[] temp = new int[arr1.length + arr2.length];

        while (i < arr1.length && j < arr2.length){
            if (arr1[i] > arr2[j])
                temp[index++] = arr2[j++];
            else
                temp[index++] = arr1[i++];
        }
        //add remaining elements
        while (i < arr1.length) temp[index++] = arr1[i++];
        while (j < arr2.length) temp[index++] = arr2[j++];
        return temp;
    }

    //26. Find sum that add up to N (two sum problem)
    //Input: [1, 21, 3, 14, 5, 60, 7, 6], sum-27, Output: {21, 6} or {6, 21}
    //Input: [3,3], sum-6, Output: {3, 3}
    public static int[] findSumAddUpToN(int[] arr, int sum){
//      TC-O(n^2), SC-O(1)
/*      int[] res = new int[2];
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                if (arr[i] + arr[j] == sum) {
                    res[0] = arr[i];
                    res[1] = arr[j];
                    return result;
                }
            }
        }
        return new int[]{};
 */

        //TC-O(n log n), SC-O(1) - sorting takes O(n log n) and the algorithm to find two numbers takes O(n) time, the overall time complexity of this code is O(n log n).
        //can also be solved in O(n) - (check hashing problems section - pairWithGivenSum for unsorted two sum array problem)
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
            else // A[leftPointer] + A[rightPointer] > sum
                rightPointer--;
        }
        return new int[]{};
    }

    //27. Array of Products of All Elements Except Itself
    //Input: [1,2,3,4], Output: [24,12,8,6]
    //Input: [-1,1,0,-3,3], Output: [0,0,9,0,0], Input: [2,3,0,0], Output: [0,0,0,0]
    public static int[] findProductsExceptItself(int[] arr){
//      Tc-O(n^2), SC-O(1)
/*      int[] res = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++){
            int prod = 1;
            for (int j = 0; j < arr.length; j++){
                if (i != j)
                    prod *= arr[j];
            }
            res[index++] = prod;
        }
        return res;
 */
        //TC-O(n), SC-O(1), since the arr returned as result is not considered for SC
        int n = arr.length;
        int i;
        int temp = 1;
        int[] result = new int[n];

        // Product of elements on left side of input arr, excluding arr[i]
        for (i = 0; i < n; i++) {
            result[i] = 1; // Initializing the result array by 1;
            result[i] = temp;
            temp *= arr[i];
        }

        temp = 1; // Initializing temp to 1 for product on right side
        // Product of elements on right side of input arr, excluding arr[i]
        for (i = n - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= arr[i];
        }
        return result;
    }

    //28. smallest element in an array
    //Input: [9, 2, 3, 6], Output: 2
    //Input: [10, 1, -3, 0], Output: -3
    public static int smallestElement(int[] arr) {
        //TC-O(n), SC-O(1)
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    //29. First Non-Repeating Integer in an Array
    //Input: [9, 2, 3, 2, 6, 6], Output: 9
    //Input: [9, 4, 9, 6, 7, 4], Output: 6
    public static int findFirstUniqueInArray(int[] arr) {
        //TC-O(n^2), SC-O(1)
        //O(n) Solution can be solved using hashing(check hashing problems section - 16. findFirstUniqueInArray)
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

    //30. Re-arrange Positive & Negative Values
    //Input: [10, -1, 20, 4, 5, -9, -6], Output: [-1, -9, -6, 4, 5, 10, 20]
    public static int[] reArrangePositiveAndNegativeValues(int[] arr){
//        //TC-O(n^2), SC-O(1)
/*        for (int i = 0; i < arr.length; i++){
           for (int j = i + 1; j < arr.length; j++){
               if (arr[i] > arr[j]){
                   int temp = arr[j];
                   arr[j] = arr[i];
                   arr[i] = temp;
               }
           }
        }
        return arr;
 */
        //TC-O(n), SC-O(1)
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

    //31. Rearrange Sorted Array in Max/Min Form
    //Input: [1, 2, 3, 4, 5], Output: [5, 1, 4, 2, 3]
    //Input: [1, 2, 3, 4, 5, 6, 7], Output: [7, 1, 6, 2, 5, 3, 4]
    public static int[] maxMinOrder(int[] arr){
        //TC-O(n), SC-O(n)
/*      int[] result = new int[arr.length];
        int i = 0; int j = arr.length - 1;
        int index = 0;
        while (i <= j){
            result[index++] = arr[j--];
            if(j > i) //because i can become greater than j, and go out of bounds in next step
                result[index++] = arr[i++];
        }
        return result;
 */
        //TC-O(n), SC-O(1)
        //This solution is very tricky and has an formula. We actually store two elements at one index mathematically. The original element is stored as the remainder,
        //while the max/min element is stored as the multiplier. The following expression achieves this, arr[i] += (arr[maxIdx] % maxElem ) * maxElem;
        //How does expression “(arr[i] += arr[maxIdx] % maxElem * maxElem)” work ?
        //The purpose of this expression is to store two elements at index arr[i]. arr[max_index] is stored as multiplier and “arr[i]” is stored as remainder.
        //For example in {1 2 3 4 5 6 7 8 9}, max_element is 10 and we store 91 at index 0. With 91, we can get original element as 91%10 and new element as 91/10.
        //This allows us to swap the numbers in place without losing any data or using any extra space. To get the final array, we simply divide each element by maxElem as done in the last for loop.
        int maxIdx = arr.length - 1;
        int minIdx = 0;
        int maxElem = arr[maxIdx] + 1; // store any element that is greater than the maximum element in the array. Instead of +1, we can also do + 2, +3 or any number, we do this so that the remainder will not be zero when we do (arr[maxIdx] % maxElem)
        for( int i = 0; i < arr.length; i++) {
            // at even indices we will store maximum elements
            if (i % 2 == 0){
                arr[i] += (arr[maxIdx] % maxElem) * maxElem;
                maxIdx -= 1;
            }
            else { // at odd indices we will store minimum elements
                arr[i] += (arr[minIdx] % maxElem ) * maxElem;
                minIdx += 1;
            }
        }
        // dividing with maxElem to get original values.
        for( int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / maxElem;
        }

        return arr;
    }

    //32. Binary Search Algorithm - Sorted Array
    public static int binarySearch(int[] arr, int low, int high, int x){
        //TC-O(log n), SC-O(1)
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

    //33.Find index of first occurrence in a sorted array
    //Input: [1, 10, 10 ,10, 20,20,40], x=20, Output: 4
    //Input: [10, 20, 30], x=15, Output: -1 //Input: [15,15,15], x=15, Output: 0
    public static int firstOccurrenceInSortedArray(int[] arr, int low, int high, int x){
        //TC-O(n), SC-O(1)
/*        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
 */
        //TC-O(log n), SC-O(log n) for recursive calls
        //we do normal binary search here
/*        if (low > high)
            return -1;

        int mid = (low + high) / 2;
        if (arr[mid] < x)
            return firstOccurrenceInSortedArray(arr, mid+1, high, x);
        else if (arr[mid] > x)
            return firstOccurrenceInSortedArray(arr, low, mid-1,x);
        //we add special case for first occurrence here
        else{
            //if mid is 0, it means it is the first element
            //and we check if arr[mid] is first occurrence, if yes we return mid
            if (mid == 0 || arr[mid - 1] != arr[mid])
                return mid;
            else
                //else we recursively go to left side to find first occurrence
                return firstOccurrenceInSortedArray(arr, low, mid - 1, x);
        }
 */
        //TC-O(log n), SC-O(1)
        int lowIndex = 0;
        int highIndex = arr.length - 1;
        //we do normal binary search here
        while (lowIndex < highIndex){
            int mid = (lowIndex + highIndex) / 2;

            if (arr[mid] < x)
                lowIndex = mid + 1;
            else if (arr[mid] > x)
                highIndex = mid - 1;
            //we add special case for first occurrence here
            else{
                //if mid is 0, it means it is the first element
                //or we check if arr[mid] is first occurrence, if yes we return mid
                if (mid == 0 || arr[mid] != arr[mid - 1])
                    return mid;
                //else we go to left side to find first occurrence
                else
                    highIndex = mid - 1;
            }
        }
        return -1;
    }

    //34. Find index of last occurrence in sorted array
    //Input: [1, 10, 10 ,10, 20,20,40], x=20, Output: 5
    //Input: [10, 20, 30], x=15, Output: -1 //Input: [15,15,15], x=15, Output: 2
    public static int lastOccurrenceInSortedArray(int[] arr, int low, int high, int x){
        //TC-O(n), SC-O(1)
/*       for (int i = arr.length - 1; i >= 0; i--){
            if (arr[i] == x)
                return i;
            else if(arr[i] < x) //small optimisation, if x is greater than arr[i], then x will be present before that since arr is sorted, so we break
                break;
        }
        return -1;
 */

        //TC-O(log n), SC-O(log n)
/*      if (low > high)
            return -1;

        int mid = (low + high) / 2;
        if (arr[mid] < x)
            return lastOccurrence(arr, mid + 1, high, x);
        else if(arr[mid] > x)
            return lastOccurrence(arr, low, mid - 1, x);
        else{
            if (mid == arr.length - 1 || arr[mid] != arr[mid + 1])
                return mid;
            else
                return lastOccurrence(arr, mid + 1, high, x);
        }
 */

        //TC-O(log n), SC-O(1)
        //we do normal binary search here
        while (low <= high){
            int mid = (low + high) / 2;

            if (arr[mid] > x)
                high = mid - 1;
            else if (arr[mid] < x)
                low = mid + 1;
            //we add special case for last occurrence here
            else{
                //if mid is last, it means it is the last element
                //or we check if arr[mid] is last occurrence by arr[mid] != arr[mid + 1], if yes we return mid
                if (mid == arr.length - 1 || arr[mid] != arr[mid + 1])
                    return mid;
                //else we go to right side to find last occurrence
                else
                    low = mid + 1;
            }
        }
        return -1;
    }

    //35. count occurrence of element in sorted array
    //Input: [10, 10 ,20, 20, 20, 30, 30], x=20, Output: 3
    //Input: [10, 10, 10, 10, 10], x=10, Output: 5 //Input: [5, 8, 10], x=15, Output: 0
    public static int countOccurrence(int[] arr, int x){
//        TC-O(n), SC-O(1)
/*        int count = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == x)
                count++;

        return count;
 */
        //TC-O(log n) -  finding first occurrence is O(log n) + last occurrence is O(log n)- totally O(log n) and SC-O(1)
        int first = firstOccurrenceInSortedArray(arr, 0, arr.length - 1, x);
        //if there is no element in array, return 0
        if (first == -1)
            return 0;
        else
            //first occurrence - last occurrence + 1 - will give total number of occurrence of x
            return (lastOccurrenceInSortedArray(arr, 0, arr.length - 1, x) - first + 1);
    }

    //36. count ones in sorted binary array
    public static int countOnesInSortedBinaryArray(int[] arr){
        //TC-O(n), SC-O(1)
/*        for (int i = 0; i < arr.length; i++)
            if (arr[i] == 1)
                return arr.length - i;

        return 0;
 */
        //TC-O(log n), SC-O(1)
        int low = 0; int high = arr.length - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            //If arr[mid] is zero, we have to find one. since array is sorted we move right side
            if (arr[mid] == 0)
                low = mid + 1;
            else{
                //if mid is 0, then it is the first element, so we return mid or if arr[mid-1] is not zero,then it's not first occurrence of 1, so we move left side to find first occurrence of 1
                if (mid == 0 || arr[mid - 1] == 0)
                    return arr.length - mid;
                else
                    high = mid - 1;
            }
        }
        return 0;
    }

    //37. find the square root of a number
    //Input: 25, Output: 5
    //Input: 14, Output: 3, sqrt of 14 will be 3.74, we return floor of that number
    public static int squareRoot(int x){
        //TC-O(x^1/2), SC-O(1)
/*      int i = 1;
        while (i * i <= x)
            i++;
        return i - 1;
 */
        //TC-O(log x), SC-O(1)
        int low = 1; int high = x; int ans = -1;
        while (low <= high){
            int mid = (low + high) / 2;
            int sq = mid * mid;
            if (sq == x)
                return mid;
            else if (sq > x)
                high = mid - 1;
            else{
                low = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }

    //38. Search in a infinite sized sorted array
    //Input: [1,10,15,20,40,80,90,100,120,500.....], x=100, Output: 7
    //Input: [20,40, 100,300.....], x=50, Output: -1
    public static int searchInfiniteSizedSortedArray(int[] arr, int x){
      //TC-O(x) where x is position, SC-O(1)
/*      int i = 0;
        while (true){
            if (arr[i] == x) return i;
            if (arr[i] > x) return -1;
            i++;
        }
 */
        //TC-O(log(x)), where x is position, SC-O(1)
        //The technique for this solution is called as (unbounded binary search), because we do binary search on infinite array and array is unbounded(infinite)
        //check for arr[0] explicitly, because in next step we initialize i as 1, is i is 0, product will always be zero
        if (x > arr[arr.length - 1])
            return -1;

        if (arr[0] == x)
            return 0;

        int i = 1;
        //we double the i in each step, as soon as x > arr[i] we stop.
        //if arr[i] > x, that means we cannot find x after that since array is sorted, so we terminate
        while (arr[i] < x)
            i = i * 2;

        //at this point if arr[i] == x, we return i
        if (arr[i] == x)
            return i;

        //else, we do a binary search for a specific range
        //In this example {1,10,15,20,40,60,80,100,200,500.....}, our i is at 8,(stopped this in while loop)
        //so we can start binary search from, index 0 to 8, or we can further optimize this search,
        //we can start from (i/2)+1 because, if we do (i/2) we can go to previously where i was, because we are doubling (i*2)
        //so we start from (i/2)+1, because (i/2) will be definitely smaller than x, we need to search next from i/2,
        //similarly we end at i-1, because i will be definitely greater than x.
        //for this we do binary search, low-> (i/2)+1 and high-> (i-1)
        return binarySearch(arr, (i / 2) + 1, i - 1, x);
    }

    //39. search x in sorted rotated array
    //Input: [10, 20, 30, 40, 50, 8, 9], x=30, Output: 2
    //Input: [100, 200, 300, 10, 20], x=40, Output: -1
    public static int searchInSortedRotatedArray(int[] arr, int x){
        //TC-O(n), SC-O(1)
/*        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
 */
        //TC-O(log n), SC-O(1)
        int low = 0; int high = arr.length - 1;
        while (low <= high){
            //normal binary search
            int mid = (low + high) / 2;
            if (arr[mid] == x)
                return mid;

            //checking if left half is sorted, since it is sorted rotational array, so one side must be sorted definitely
            if (arr[mid] > arr[low]){
                //if it is left sorted, we check if x exists between that range
                if (x >= arr[low] && x < arr[mid])
                    high = mid - 1;
                //else we go to right half
                else
                    low = mid + 1;
            }
            //else, checking if right half is sorted, since it is sorted rotational array, so one side must be sorted definitely
            else{
                //if it is right sorted, we check if x exists between that range
                if (x > arr[mid] && x <= arr[high])
                    low = mid + 1;
                //else we go to left half
                else
                    high = mid - 1;
            }
        }
        return -1;
    }

    //40.Find peak element in a array - A element is a peak element, if it's neighbour(left and right) element are smaller than current element
    //Input: [5, 10, 20, 15, 17], Output: 20 //Input: [10, 20, 15, 5, 23, 90, 67] Output: 20 or 90
    //Input: [80, 70, 60] Output: 80
    public static int peakElement(int[] arr){
        //TC-O(n), SC-O(1)
/*      if (arr[0] > arr[1])
            return arr[0];
        if (arr[arr.length - 1] > arr[arr.length - 2])
            return arr[arr.length - 1];
        for (int i = 1; i < arr.length - 1; i++){
            if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1])
                return arr[i];
        }
        return -1;
*/
        //TC-O(log n), SC-O(1), This is a tricky approach, we use binary search on a unsorted array
        //The idea here is we first check mid element, if the mid element is a peak element return mid,
        //or if element left side of mid element is greater i.e, arr[mid-1] > arr[mid], then it means we search for peak element on left side, because if element left side to mid is greater,
        //it means the next to that left will be smaller or greater, if smaller then we will have peak element, if greater then we move to next left element, and if that is also greater and if we reach to first element, it will be peak element
        //so it doesn't mean that, the element will not be in right half, it might be there, but we can surely say element will be in left half, if arr[mid-1] > arr[mid]
        //else for arr[mid-1] < arr[mid], similarly we also do for right side, if element right side of mid is greater than mid. //this is also called as valley approach, as the element goes up and down like a valley
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

    //41. Given Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
    //Input: [1, 2, 3, 4, 6], target=6 Output: [1, 3] Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
    //Input: [2, 5, 9, 11], target=11 Output: [0, 2] Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
    //(check hashing problems section - pairWithGivenSum for unsorted two sum array problem)
    public static int[] twoSumInSortedArray(int[] arr,int x){
        //TC-O(n^2), SC-O(1)
/*      for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == x)
                    return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
 */
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

    //42. Find Repeating elements in an array (duplicate number)
    //Array size is always >= 2 //All elements in the array are from 0 to max element of array //Only one element repeats (any no. of times)
    //Input: [0, 2, 1, 3, 2, 2], Output: 2 //Input: [1, 2, 3, 0, 3, 4, 5], Output: 3 //Input: [0, 0], Output: 0
    public static int repeatingElements(int[] arr){
        //TC-O(n^2), SC-O(1)
/*        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] == arr[j])
                    return arr[i];
        return -1;
 */

        //TC-O(n log n), SC-O(1)
/*        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i] == arr[i + 1])
                return arr[i];

        return -1;
 */

        //TC-O(n), SC-O(n)
        //we can use this approach since the elements in the array will be from zero to maximum element in array, eg: [0, 2, 1, 3, 2, 2], here elements are from 0 to max element(2), so we will have 0,1,2
        //so we can create boolean array and store that number as true when we visit, if we revisit same number again, we return true
/*        boolean[] visited = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (visited[arr[i]])
                return arr[i];

            visited[arr[i]] = true;
        }
        return -1;
 */

        //TC-O(n), SC-O(1), Original array is not modified
        //Slow and Fast Pointer Approach (Floyd's cycle method).
        //Detailed Explanation and Intuition- https://www.notion.so/DSA-PATTERN-EXPLANATION-6a2cfbd6b8764a0e8beaff62860c3900#115a418c8b124bd994cf1bb2975e650a
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

    //43. Allocate minimum number of pages.
    //You have to allocate books to K number of students so that the maximum number of pages allocated to a student is minimum.
    //Conditions given : 1. A book will be allocated to exactly one student. //Each student has to be allocated at least one book.
    //Allotment should be in contiguous order, for example, A student cannot be allocated book 1 and book 3, skipping book 2. //Calculate and return the minimum possible number. Return -1 if a valid assignment is not possible.
    //Input: A = [12, 34, 67, 90] K = 2 Output: 113
    //Input: A = [10, 20, 30, 40] K = 2 Output: 60 //Input: A = [5, 17, 100, 11] K = 4 Output: 100
    //Explanation and intuition - https://takeuforward.org/data-structure/allocate-minimum-number-of-pages/ and https://www.geeksforgeeks.org/allocate-minimum-number-pages/
    public static int minPagesAllocation(int[] arr, int k){
        //Time Complexity : O(NlogN), Binary search takes O(log N). For every search, we are checking if an allocation is possible or not. Checking for allocation takes O(N).
        //Space Complexity: O(1)
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
        int requiredStudent = 0; int sum = 0;
        for (int i = 0; i < arr.length; i++){
            if (sum + arr[i] > mid){
                requiredStudent++;
                sum = arr[i]; //set sum to arr[i] for new student
            }
            else sum += arr[i];
        }
        return (requiredStudent < k);
    }

    //44.Intersection of two sorted arrays (print common elements in both arr)
    //Input: arr1[] = {1, 3, 4, 5, 7} arr2[] = {2, 3, 5, 6},  Output: {3, 5}
    //Input: arr1[] = {2, 5, 6} arr2[] = {4, 6, 8, 10}, Output: {6}
    //Input: arr1[] = {2, 3, 3, 3, 4, 4} arr2[] = {2, 2, 4, 4}, Output: {2, 4}
    public static void intersectionOfTwoSortedArrays(int[] arr1, int[] arr2){
        //TC-O(n * m), SC=O(1)
/*      for (int i = 0; i < arr1.length; i++){
            if (i > 0 && arr1[i] == arr1[i - 1]) continue;
            for (int j = 0; j < arr2.length; j++){
                if (arr1[i] == arr2[j]){
                    System.out.print(arr1[i] + " ");
                    break;
                }
            }
        }
*/
        //TC-O(m + n), SC-O(1)
        int i = 0; int j = 0;
        while (i < arr1.length && j < arr2.length){
            //skip duplicate elements
            if (i > 0 && arr1[i] == arr1[i - 1]){
                i++;
                continue;
            }
            if (arr1[i] > arr2[j])
                j++;
            else if (arr1[i] < arr2[j])
                i++;
            else{
                System.out.print(arr1[i] + "  ");
                i++;
                j++;
            }
        }
    }

    //45. Union of two sorted arrays
    //Input: arr1[] = {1, 3, 4, 5, 7} arr2[] = {2, 3, 5, 6},  Output: {1, 2, 3, 4, 5, 6, 7}
    //Input: arr1[] = {2, 5, 6} arr2[] = {4, 6, 8, 10}, Output: {2, 4, 5, 6, 8, 10}
    //Input: arr1[] = {2, 3, 3, 3, 4, 4} arr2[] = {4, 4}, Output: {2, 3, 4}
    public static void unionOfTwoSortedArrays(int[] arr1, int[] arr2){
        //TC-O((m+n) log (m+n)), SC-O(m+n)
/*      int n1 = arr1.length;
        int n2 = arr2.length;
        int[] temp = new int[n1 + n2];
        for (int i = 0; i < arr1.length; i++)
            temp[i] = arr1[i];

        for (int i = 0; i < arr2.length; i++)
            temp[n1 + i] = arr2[i];

        Arrays.sort(temp);
        for (int i = 0; i < temp.length; i++) {
            if (i == 0 || temp[i] != temp[i - 1])
                System.out.print(temp[i] + " ");
        }
 */
        //TC-O(m + n), SC-O(1)
        int i = 0; int j = 0;
        while (i < arr1.length && j < arr2.length) {
            //skip duplicate elements in arr1
            if (i > 0 && arr1[i] == arr1[i - 1]){
                i++;
                continue;
            }
            //skip duplicate elements in arr2
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

        //process remaining elements
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

    //46. Count Inversions in an array - A pair (arr[i], arr[j]) forms a inversion when i < j and arr[i] > arr[j]
    //Input: [2,4,1,3,5], Output: 3, because there are three inversions, (2, 1), (4, 1), (4, 3)
    //Input: [10, 20, 30, 40], Output: 0 //Input: [40, 30, 30, 10], Output: 6
    public static int countInversions(int[] arr, int left, int right){
        //TC-O(n^2), SC-O(1)
/*      int res = 0;
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] > arr[j])
                    res++;
        return res;
*/
        //TC-O(n log n), SC - O(n) for merging arrays
        //This solution is same as merge sort, we additionally add one extra logic here to count inversions, res = res + (n1 - i);
        int res = 0;
        if (left < right){
            int mid =  left + (right - left) / 2; //or (left + right) / 2
            res += countInversions(arr,left, mid); //recursively divide arrays on left side and count inversions
            res += countInversions(arr, mid + 1, right); //recursively divide arrays on right side and count inversions
            res += countAndMerge(arr, left, mid, right); //sort and merge arrays and count inversion
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
            //if no inversions just sort the array
            if (leftArr[i] <= rightArr[j])
                arr[k] = leftArr[i++];
            else{
                //if there is a inversion sort arr and calculate res
                arr[k] = rightArr[j++];
                res = res + (n1 - i); //we do this because if leftArr[i] > rightArr[j], it means all elements after leftArr[i] will be greater than rightArr[j], since we have sorted the array individually
                //so instead of linearly traversing and counting inversions, we can count inversions efficiently using this method, res + (n1 - i)
            }
            k++;
        }
        //process remaining elements
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

    //47. Find Kth smallest element in an array
    //input - [10, 5, 30, 12], k = 2, Output - Kth smallest element is 10
    //input - [30, 20, 5, 10, 8], k = 4, Output - Kth smallest element is 20
    public static int KthSmallestElement(int[] arr, int k) {
        //TC-O(n log n)
//      Arrays.sort(arr);
//      return arr[k - 1];

        //TC-O(n^2) - even though it's n^2, this solution works much better than naive solution-O(nlogn) on average
        //This algorithm is called QuickSelect
        //We use lomuto partition to find kth smallest element
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int p = lomutoPartition(arr, left, right);
            //if partition returns k-1, we return it, because the array will be sorted, and if partition returns a value that matches with p, i.e p = k-1, we found the result
            if (p == k - 1)
                return arr[p];
            //if p is greater than k-1 means, k lies in left part, so we search in left part
            else if (p > k - 1)
                right = p - 1;
            //if p is smaller than k-1 means, k lies in right part, so we search in right part
            else
                left = p + 1;
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

    //48. Chocolate distribution problem
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

    //49. sort array with two types of elements.  output can be in any order(satisfying the condition)
    //1. segregate positive and negative integers, //Input: [-1,2,-3,4,-5,6,-7,8,-9], Output: [-1, -3, -5, -7, -9, 6, 4, 8, 2]
    //2. segregate even and odd integers, //Input: [1,2,3,4,5,6,7,8,9], Output: [2, 4, 6, 8, 5, 3, 7, 1, 9], in solution change condition to if(arr[i] % 2 == 0)
    //3. segregate binary array //Input: [0, 1, 0 ,1 ,0 ,1, 0, 0, 1, 1], Output: [0, 0, 0 ,0, 0 ,1, 1, 1, 1, 1],  in solution change condition to if(arr[i] == 0)
    public static void sortArrayWithTwoTypesOfElements(int[] arr){
        //TC-O(n) - but three traversals, SC-O(n)
/*      int[] temp = new int[arr.length];
        int i = 0;
        for (int j = 0; j < arr.length; j++)
            if (arr[j] < 0)
                temp[i++] = arr[j];

        for (int j = 0; j < arr.length; j++)
            if (arr[j] >= 0)
                temp[i++] = arr[j];

        for (int j = 0; j < arr.length; j++)
            arr[j] = temp[j];

        System.out.println(Arrays.toString(arr));
 */

        //Hoare's Partition, TC-O(n), SC-O(1)
/*      int i = -1; int j = arr.length;
        while (true){
            do {
                i++;
            }while (arr[i] < 0); //change, arr[i] == 0 for binary arr //arr[i] % 2 == 0 for odd and even segregation
            do {
                j--;
            }while (arr[j] >= 0); //change, arr[j] == 1 for binary arr //arr[j] % 2 == 1 for odd and even segregation

            if (i >= j)
                break;

            swap(arr, i, j);
        }
 */
        //TC-O(n), SC-O(1)
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0)
                swap(arr, j++, i);
        }
        System.out.println(Arrays.toString(arr));
    }

    //50. Sort an array of 0s, 1s and 2s - sort array with three types of elements (Dutch National flag Problem)
    //1. Given an array A[] consisting only 0s, 1s and 2s. The task is to write a function that sorts the given array. The functions should put all 0s first, then all 1s and all 2s in last.
          //Input: [1, 0, 2, 1, 0] Output: [0 0 1 1 2],  Input: [2, 2, 0, 1, 2, 0] Output: [0 0 1 2 2 2 ]
    //2. Three way partitioning - Input: [2,1,2,20,10,20,1],Pivot=2 Output: [1,1,2,2,20,10,20], In three way partitioning all the pivot elements should come together, and all the elements smaller than pivot should move
          //before pivot, and all elements greater than pivot should move after pivot
    //3. Partition around a range - Input: [10,5,6,3,20,9,40], lowVal=5, highVal=10 Output:[3,5,6,9,10,20,40]
          //all elements which are less than 5 are present before 5(lowVal), all elements which are greater than 5(lowVal) and less than 10(highVal) are present in between 5 and 10, and all elements which are greater than 10 are present after 10
    public static void sortArrayWithThreeTypesOfElements(int[] arr){
        //TC- O(n), SC-O(1)
        //Dutch National flag Problem - The algorithm states that, all the zeros will be in the range [0 to low-1]i.e, before low and all the two's will be in range [high+1 to n]i.e after high, and all the ones will be in [low to mid-1]i.e, between 0's and 2's
        //We can use a Two Pointers approach while iterating through the array. Let’s say the two pointers are called low and high which are pointing to the first and the last element of the array respectively.
        //So while iterating, we will move all 0s before low and all 2s after high so that in the end, all 1s will be between low and high.
        //1. sort 0's 1's and 2's
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

        //2. Three way Partition
/*      int low = 0; int mid = 0;
        int high = arr.length - 1;
        int pivot = 2;
        while (mid <= high){
            if (arr[mid] < pivot)
                swap(arr, low++, mid++);
            else if (arr[mid] > pivot)
                swap(arr, mid, high--);
            else
                mid++;
        }
        System.out.println(Arrays.toString(arr));
 */
        //3. Partition around range
/*      int low = 0; int mid = 0;
        int high = arr.length - 1;
        int lowVal = 5, highVal = 10; //instead of hardcoding, pass low and high values through function params
        while (mid <= high){
            if (arr[mid] < lowVal)
                swap(arr, low++, mid++);
            else if (arr[mid] > highVal)
                swap(arr, mid, high--);
            else
                mid++;
        }
        System.out.println(Arrays.toString(arr));
 */
    }

    //51. Find minimum difference in array
    //Input:[1,8,12,5,18], Output: 3, the min difference is (8-5) = 3
    //Input:[8,15], Output: 7 //Input:[8,-1,0,3], Output: 1
    public static int minimumDifferenceInArray(int[] arr){
        //TC-O(n^2), SC-O(1)
/*      int res = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                res = Math.min(res, Math.abs(arr[i] - arr[j]));

        return res;
 */
        //TC-O(n log n), SC-O(1)
        int res = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++)
            res = Math.min(res, arr[i] - arr[i - 1]);

        return res;
    }

    //52. Merge Overlapping intervals
    //Input: Intervals = {{1,3},{2,4},{6,8},{9,10}} Output: {{1, 4}, {6, 8}, {9, 10}} Explanation: Given intervals: [1,3],[2,4],[6,8],[9,10], we have only two overlapping intervals here,[1,3] and [2,4]. Therefore we will merge these two and return [1,4],[6,8], [9,10].
    //Input: Intervals = {{6,8},{1,9},{2,4},{4,7}} Output: {{1, 9}} Explanation: we have overlapping intervals between 1 and 9
    public static void mergeIntervals(Interval[] arr) {
        //TC-O(n log n), SC-O(1)
        //The idea is sort the array and check if interval at index.end is greater than interval at arr[i].start, it means we have a overlap and merge them
        //if there is no overlap, we simply increment index and copy interval at i to current index
        sortIntervals(arr);
        int index = 0;
        for (int i = 1; i < arr.length; i++){
            //if there is a overlap, then merge the intervals by taking minimum of two values from start, and maximum values from end
            if (arr[index].end >= arr[i].start){
                arr[index].start = Math.min(arr[index].start, arr[i].start);
                arr[index].end = Math.max(arr[index].end, arr[i].end);
            }
            else{
                index++;
                arr[index] = arr[i]; //copy intervals at i to index
            }
        }
        //print merged intervals
        for (int i = 0; i <= index; i++)
            System.out.print("[" + arr[i].start + "," + arr[i].end + "]");
    }
    private static void sortIntervals(Interval[] arr){
        Arrays.sort(arr, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
    }

    //53. Meeting the maximum guests
    //900 means 9:00, and 2359 means 23:59
    //Input: arrival=[900,600,700], departure=[1000, 800, 730], Output: 2, we can meet two guest if we arrive between 700 to 730
    //Input: arrival=[900,940], departure=[1000, 1030], Output: 2, we can meet two guest if we arrive between 940 to 1000
    //Input: arrival=[900,940,950,1100,1500,1800], departure=[900,1200,1120,1130,1900,2000], Output: 3, we can meet two guest if we arrive between 1100 to 1120
    public static int meetMaxGuests(int[] arrival, int[] departure){
        //TC-O(n log n), SC-O(1)
        //Idea is to sort both arrival and departures, and find the no. of maximum guest that can be met
        //we sort both arrays and then check if arrival[arrivalIndex] <= departure[departureIndex], that means a new guest has arrived so we increment currGuests by 1
        //else the guest has left, so decrease the currGuest by 1.
        //This solution is similar to merge function of merge sort, we check two arrays simultaneously and increment arrivalIndex and departureIndex based on conditions
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int res = 1;
        int arrivalIndex = 1; //we start res and arrivalIndex at 1, because for arr[0], we would have met one guest for sure, so we start from 1st index
        int departureIndex = 0; int currGuests = 1;

        while (arrivalIndex < arrival.length && departureIndex < departure.length){
            // a new guest has arrived so we increment currGuests by 1
            if (arrival[arrivalIndex] <= departure[departureIndex]){
                currGuests++;
                arrivalIndex++;
            }
            //the guest has left, so decrease the currGuest by 1.
            else{
                currGuests--;
                departureIndex++;
            }
            res = Math.max(res, currGuests);
        }
        return res;
    }

    /* Sliding window Problems */
    //54. Average of subarray of size K - find the average of all contiguous subarrays of size ‘K’ in it.
    //Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
    //For the first 5 numbers (subarray from index 0-4), the average is: (1+3+2+6-1)/5 => 2.2(1+3+2+6−1)/5=>2.2
    //The average of next 5 numbers (subarray from index 1-5) is: (3+2+6-1+4)/5 => 2.8(3+2+6−1+4)/5=>2.8
    //For the next 5 numbers (subarray from index 2-6), the average is: (2+6-1+4+1)/5 => 2.4(2+6−1+4+1)/5=>2.4 and so on.
    //Output: [2.2, 2.8, 2.4, 3.6, 2.8]
    public static double[] averageOfSubarrayOfSizeK(int[] arr, int k){
        //O(N * K) where ‘N’ is the number of elements in the input array, Space - O(k)
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

    //55. Maximum Sum Subarray - Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
    //Input: [2, 1, 5, 1, 3, 2], k=3 Output: 9
    //Explanation: Subarray with maximum sum is [5, 1, 3].
    public static int findMaxSubArraySumOfSizeK(int[] arr, int k) {
        //Naive Solution - time complexity O(N * K)
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
            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
            if (windowEnd >= k - 1) {
                maxSum = Math.max(windowSum, maxSum);
                windowSum -= arr[windowStart++]; // subtract the element going out and slide the window ahead by windowStart++
            }
        }
        return maxSum;
    }

    //56. Smallest Subarray with a given sum - Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
    //Input: [2, 1, 5, 2, 3, 2], S=7 //Output: 2 //Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2]
    //Input: [2, 1, 5, 2, 8], S=7 //Output: 1 //Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
    //Input: [3, 4, 1, 1, 6], S=8 //Output: 3 //Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].
    public static int findMinSubArrayLengthEqualToK(int[] array, int k){
        //TC-O(n^2), SC-O(1)
/*      int minLength = Integer.MAX_VALUE;
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

        //TC-O(N). The outer for loop runs for all elements and the inner while loop processes
        //each element only once, therefore the time complexity of the algorithm will be O(N+N) which is asymptotically equivalent to O(N).
        //SC-O(1)
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

    //57. 1. Longest Substring with K Distinct Characters - Given a string, find the length of the longest substring in it with no more than K distinct(unique) characters.
    //Input: String="araaci", K=2 //Output: 4 //Explanation: The longest substring with no more than '2' distinct characters is "araa".
    //Input: String="araaci", K=1 //Output: 2 //Explanation: The longest substring with no more than '1' distinct characters is "aa".
    //Input: String="cbbebi", K=3 //Output: 5 //Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".

    //2. Fruits in to baskets - Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.
    //You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
    //Input: Fruit=['A', 'B', 'C', 'A', 'C'] Output: 3 Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
    //Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C'] Output: 5 Explanation: We can put 3 'B' in one basket and two 'C' in the other basket This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
    //Both the above problems have same solution, and similar to each other
    public static int longestSubstringKDistinct(String str, int k) {
        //TC-O(N). The outer for loop runs for all elements and the inner while loop processes
        //each element only once, therefore the time complexity of the algorithm will be O(N+N) which is asymptotically equivalent to O(N).
        //SC-O(K), as we will be storing a maximum of ‘K+1’ characters in the HashMap.
        if (str == null || str.length() == 0 || str.length() < k)
            throw new IllegalArgumentException();

        Map<Character, Integer> frequencyMap = new HashMap<>();
        int maxLength = 0; int windowStart = 0;
        // in the following loop we'll try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            frequencyMap.put(rightChar, frequencyMap.getOrDefault(rightChar, 0) + 1);
            // shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
            while (frequencyMap.size() > k){ //for second problem change k to 2 (2 baskets)
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

    //58. Longest No repeat substring - Given a string, find the length of the longest substring which has no repeating characters.
    //Input: String="aabccbb" Output: 3, Explanation: The longest substring without any repeating characters is "abc".
    //Input: String="abbbb" Output: 2, Explanation: The longest substring without any repeating characters is "ab".
    //Input: String="dvdf" Output: 3, Explanation: Longest substrings without any repeating characters is "vdf"
    public static int longestNoRepeatSubstring(String s){
        //TC-O(N), SC-O(K) - where KK is the number of distinct characters in the input string. This also means K<=NK<=N, because in the worst case, the whole string might not have any repeating character so the entire string will be added to the HashMap.
        //Having said that, since we can expect a fixed set of characters in the input string (e.g., 26 for English letters), we can say that the algorithm runs in fixed space O(1)O(1); in this case, we can use a fixed-size array instead of the HashMap.
        int maxLength = 0; int windowStart = 0;
        Map<Character, Integer> frequencyMap = new HashMap<>();
        //we iterate thru the string and check if we have seen the character already, if we have seen
        //we update the windowStart by checking max of windowStart and current char + 1, we do this because, if we have seen a char already we have to start a new window, so we update windowStart
        //else we add it to the hashmap
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            // if the map already contains the 'rightChar', shrink the window from the beginning so that
            // we have only one occurrence of 'rightChar'
            if (frequencyMap.containsKey(rightChar)){
                windowStart = Math.max(windowStart, frequencyMap.get(rightChar) + 1);
            }
            frequencyMap.put(rightChar, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    //59. Longest Substring with Same Letters after Replacement
    //Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.
    //Input: String="aabccbb", k=2 //Output: 5 //Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
    //Input: String="abbcb", k=1 //Output: 4 //Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
    //Input: String="abccde", k=1 //Output: 3 //Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
    public static int characterReplacement (String str, int k){
        //TC-O(N) where ‘N’ is the number of letters in the input string.
        //SC-O(26), to store each letter’s frequency in the HashMap, which is asymptotically equal to O(1).

        //The idea is, We’ll iterate through the string to add one letter at a time in the window. We’ll also keep track of the count of the maximum repeating letter in any window (let’s call it maxRepeatLetterCount).
        //So at any time, we know that we can have a window which has one letter repeating maxRepeatLetterCount times, this means we should try to replace the remaining letters. If we have more than
        //‘k’ remaining letters, we should shrink the window as we are not allowed to replace more than ‘k’ letters.
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

    //60. Longest Subarray with Ones after Replacement
    //Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s.
    //Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2 //Output: 6 //Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
    //Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3 //Output: 9 //Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.
    public static int replacingOnes(int[] arr, int k){
        //Time Complexity - O(N), Space Complexity - O(1)
        //Following a similar approach like previous problem, we’ll iterate through the array to add one number at a time in the window. We’ll also keep track of the maximum number of repeating 1s in the current
        //window (let’s call it maxOnesCount). So at any time, we know that we can have a window which has 1s repeating maxOnesCount time, so we should try to replace the remaining 0s. If we have more than ‘k’ remaining 0s,
        //we should shrink the window as we are not allowed to replace more than ‘k’ 0s.
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

    //61. Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’ in-place and return the new length of the array.
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

    //62.Squaring a Sorted Array
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