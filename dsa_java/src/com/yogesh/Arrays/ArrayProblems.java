package com.yogesh.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ArrayProblems {
    //1. Largest element in an array
    //I/p: [10, 50, 20, 8], O/P - 1(index of largest element in array)
    //I/p: [10, 20, 30, 80], O/P - 3(index of largest element in array)
    //O(n) solution - Efficient solution
    public static int largestElement(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = i;
        }
        return max;
    }

    //1. Second Largest element in an array
    //I/p: [10, 50, 20, 8], O/P - 2(index of largest element in array)
    //I/p: [10, 20, 30, 80], O/P - 2(index of largest element in array)
    //O(n) solution - Efficient solution
    public static int secondLargestElement(int[] arr) {
        int largest = 0;
        int secondLargest = -1; //we initialize second largest -1 because, we may have same values in array, eg: {10,10,10}. so here only we can have largest value. we cannot have second largest value. so we simply return -1
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[largest]) {
                secondLargest = largest;
                largest = i;
            } else if (arr[i] != arr[largest]) {
                if (secondLargest == -1 || arr[i] > arr[secondLargest])
                    secondLargest = i;
            }
        }
        return secondLargest;
    }

    //3. Check if array is sorted
    public static boolean isSortedArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }
        return true;
    }

    //4. Reverse an array
    public static int[] reverseArray(int[] arr) {
        for (int i = arr.length - 1, j = 0; i > j; j++, i--) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    //5. remove duplicates from sorted array
    public static int removeDuplicates(int[] arr) {
        int res = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[res - 1]) {
                arr[res] = arr[i];
                res++;
            }
        }
        for (int i = arr.length; i < res; i++)

        System.out.println(Arrays.toString(arr));
        return res;
    }

    //6. Move zeros to end.
    public static int[] moveZerosToEnd(int[] arr) {
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
    public static int[] leftRotate(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = arr[i + 1];
            arr[i + 1] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }

    public static int[] rightRotate(int[] arr){
        for (int i = arr.length - 1; i > 0; i--){
            int temp = arr[i - 1];
            arr[i - 1] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

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

        //solution-3 O(n) time and O(1) space

        //reverse the d elements
        reverse(arr, 0, d - 1);
        //reverse the remaining elements
        reverse(arr, d, arr.length - 1);
        //reverse entire array
        reverse(arr, 0, arr.length - 1);

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

    public static void leaderInArray(int[] arr) {
        //7,10,4,3,6,5,2
        //O(n^2)
//        for (int i = 0; i < arr.length; i++){
//            boolean flag = false;
//            for (int j = i + 1; j < arr.length; j++){
//                if (arr[i] <= arr[j]) {
//                    flag = true;
//                    break;
//                }
//            }
//            if (!flag){
//                System.out.print(arr[i] + " ");
//            }
//        }

        //O(n) - solution
        int currLeader = arr[arr.length - 1];
        System.out.print(currLeader + " ");

        for (int i = arr.length - 2; i >= 0; i--){
            if (currLeader < arr[i]) {
                currLeader = arr[i];
                System.out.print(currLeader + " ");
            }
        }
    }

    public static int maximumDifference(int[] arr){
//        O(n ^ 2) solution,  Aux Space - O(1)
//        int max = arr[1] - arr[0];
//        for (int i = 0; i < arr.length; i++){
//            for (int j = i + 1; j < arr.length; j++){
//                max = Math.max(max, arr[j] - arr[i]);
//            }
//        }
//        System.out.println(max);

        //O(n ^ 2) solution, Aux Space - O(1)
        int minValue = arr[0];
        int res = arr[1] - arr[0];

        for (int i = 1; i < arr.length; i++){
            res = Math.max(res, arr[i] - minValue);
            minValue = Math.min(minValue, arr[i]);
        }
        return res;
    }

    public static void frequencyInSortedArray(int[] arr){
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


    public static int maxProfit(int[] price, int start, int end){
       //O(n^2) solution, Aux Space - O(n)
       /* if (end <= start)
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
        int profit = 0;
        //the idea is simple, we iterate through array, when i is greater than i-1,
        //we simply subtract (i and i-1) and add it to the profit. this means that
        //we buy when stock is low and sell when stock is high(we keep on adding as we iterate through the array).
        for (int i = 1; i < price.length; i++)
            if (price[i] > price[i - 1])
                profit += price[i] - price[i - 1];

        return profit;
    }

    public static int trapRainWater(int[] arr){
    /*    //O(n^2) solution
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
      int res = 0;
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

    //Two pointer approach
    public static boolean twoSum(int[] arr,int x){
        int left = 0; int right = arr.length - 1;
        while (left < right){
            if (arr[left] + arr[right] == x)
                return true;
            else if(arr[left] + arr[right] > x)
                right--;
            else
                left++;
        }
        return false;
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

    //sort array with three types of elements
    public static void sortZerosOnesAndTwos(int[] arr){
        int low = 0; int high = arr.length - 1; int mid = 0;

        while (mid <= high){
            if (arr[mid] == 0)
                swap(arr, low++, mid++);
            else if (arr[mid] == 1)
                mid++;
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
}

class Interval{
    int start; int end;
    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}