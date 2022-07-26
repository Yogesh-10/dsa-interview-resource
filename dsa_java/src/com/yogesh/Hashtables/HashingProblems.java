package com.yogesh.Hashtables;

import java.util.*;

public class HashingProblems {
    //1. Find the first non-repeated character
    //Eg: I/P - programming is awesome, O/P - p
    public static char firstNonRepeatedChar(String str){
        HashMap<Character, Integer> map = new HashMap<>();

        char[] chars = str.toCharArray();
        //we iterate the loop and check if char is present in hashmap already,
        //if yes, we return the value of that char in hashmap, and add it to map with count
        // if no, we return 0 and then add to map with count
        //if no, we
        for (char ch : chars){
            int count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
            //or we can write above 2 lines as - map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        //return first char with value 1
        for (char ch : chars)
            if(map.get(ch) == 1)
                return ch;

        //if we didn't find value with 1, then we have all char repeated more than once
        //so we return char.MIN_VALUE which is like kind of null
        return Character.MIN_VALUE;
    }

    //2. Find the first repeated character
    //Eg: I/P - programming is awesome, O/P - r
    public static char firstRepeatedChar(String str){
        Set<Character> set = new HashSet<>();

        for (char ch : str.toCharArray()) {
            if (set.contains(ch))
                return ch;

            set.add(ch);
        }
        return Character.MIN_VALUE;
    }

    //3. Count Distinct elements in an array
    //I/P - [10, 20, 20, 10, 30], O/P - 3
    //I/P - [10, 10, 10], O/P - 1
    //I/P - [10, 13, 12, 15, 15, 13, 12], O/P - 4
    public static int countDistinctElements(int[] arr){
        //TC-O(n^2) ,SC-O(1)
/*      int count = 0;
        for (int i = 0; i < arr.length; i++){
            boolean flag = true;
            for (int j = 0; j < i; j++){
                if (arr[i] == arr[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) count++;
        }
        return count;
 */
        //Efficient Solution - TC-O(n), SC-O(1)
        Set<Integer> set = new HashSet<>();
        for (int item : arr)
            set.add(item);

        return set.size();

        //or we can also use hashmap.
/*      Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int item : arr)
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);

        return frequencyMap.size();
 */
    }

    //4. Print Frequency of array elements
    //I/P - [10, 20, 10, 20, 30] ,O/P - 10 2, 20 2, 30 1
    //I/P - [10, 10, 10] ,O/P - 10 3
    //I/P - [10, 20, 20, 10, 10] ,O/P - 10 3, 20 2
    public static void printFrequency(int[] arr){
        //TC-O(n^2), SC-O(1)
/*        for (int i = 0; i < arr.length; i++){
            boolean flag = false;
            //check if item is seen before
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]){
                    flag = true;
                    break;
                }
            }
            //if it is seen, ignore and move to next iteration
            if (flag) continue;

            //if not seen before, count frequency
            int frequency = 1;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] == arr[j])
                    frequency++;

            System.out.println(arr[i] + " " + frequency);
        }
 */
        //Efficient Solution, //TC-O(n), SC-O(n)
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int item : arr)
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);

        for (Map.Entry<Integer, Integer> item : frequencyMap.entrySet())
            System.out.println(item.getKey() + " " + item.getValue());
    }

    //5. Intersection of two arrays - (count only for distinct elements)
    //I/P - a = [10, 15, 20, 15, 30, 30, 5] , b = [30, 5, 30, 80], O/P - 2, Explanation - 30 and 5 are same in both arrays
    //I/P - a = [10, 20] , b = [20, 30], O/P -1 Explanation - only 20 is same in both arrays
    //I/P - a = [10, 10, 10] , b = [10, 10 ,10], O/P -1 - only 10 is same in both arrays
    public static int intersectionForDistinctElements(int[] arr1, int[] arr2){
        //TC-O(m x (m + n)) - m for outer for loop, m + n for two inner for loops.
        //SC-O(1)
/*      int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            //check if element already appeared
            boolean flag = false;
            for (int j = 0; j < i; j++)
                if (arr1[i] == arr1[j]){
                    flag = true;
                    break;
                }

            if (flag) continue;

            //if element has not appeared before, we check if element is matching in other array
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]){
                    count++;
                    break;
                }
            }
        }
        return count;
 */
        //Efficient Solution - TC-O(m + n),m and n size of first and second arr respectively, m - for inserting elements in hashset, n for searching and removing from hashset
        //SC-O(m), at worst case we need to insert all distinct elements in to hashset
        Set<Integer> set = new HashSet<>();
        for (int item : arr1)
            set.add(item);

        int count = 0;
        for (int i = 0; i < set.size(); i++){
            if (set.contains(arr2[i])) {
                count++;
                set.remove(arr2[i]);
            }
        }
        return count;
    }


    //6. Find the union of two unsorted arrays - (count only for distinct elements)
    //I/P- int[] arr = {10,20,15,30,30,5} int[] arr2 = {30,5,30,80} O/P - 6, (we have 6 distinct elements from both the arrays)
    public static int unionOfTwoArrays(int[] arr1, int[] arr2) {
        //TC-O((m+n) x (m+n)), the other two loops have O(n) which is smaller than O((m+n) x (m+n)), so we can drop them
        //SC-O(m+n)
/*      int[] temp = new int[arr1.length + arr2.length];
        int count = 0;

        //O(n)
        for (int i = 0; i < arr1.length; i++)
            temp[i] = arr1[i];

        //O(n)
        for (int i = 0; i < arr2.length; i++)
            temp[arr1.length + i] = arr2[i];

        //O((m+n) x (m+n))
        for (int i = 0; i < temp.length; i++) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (temp[i] == temp[j]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) count++;
        }
        return count;
 */

        //Efficient Solution
        //TC-O(m+n), SC-O(m+n)
        Set<Integer> set = new HashSet<>();
        for (int item : arr1)
            set.add(item);

        for (int item : arr2)
            set.add(item);

        return set.size();
    }

    //7. Find Pair with given sum in unsorted array (two sum problems)
    //I/P - [5, 8, -3, 6], Sum=3, O/P - true - Explanation = -3 + 6 = 3
    //I/P - [5, 10, -3, 6], Sum=3, O/P - false
    //I/P - [3, 2, 8, 15, -8], Sum=17, O/P - true - Explanation = 2 + 15 = 17
    public static boolean pairWithGivenSum(int[] arr, int sum){
/*        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] + arr[j] == sum)
                    return true;
            }
        }
        return false;
 */
        //TC - O(n), SC-O(n)
        Set<Integer> set = new HashSet<>();
        for (int item : arr) {
            int target = sum - item;
            if (set.contains(target))
                return true;

            set.add(item);
        }
        return false;
    }

    //8. Find the subarray with sum equal to zero
    //I/P - [4, -3, 2, 1], O/P - true, Because -3 and 2 + 1 = 3, makes zero
    public static boolean subarrayWithSumZero(int[] arr){
        //TC-O(n^2), SC-O(1)
/*        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == 0)
                    return true;
            }
        }
        return false;
 */
        //TC-O(n), SC-O(n)
        Set<Integer> set = new HashSet<>();
        //we add the sum in each iteration, and add the sum to set. In the next iteration, if we see that sum already in hashset, we return true,
        //Let's take a example, [4, -3, 2, 1], here in first iteration, sum will be 0 + 4 = 4 -> we put 4 in hashset, in next iteration sum will be 4 - 3 = 1 -> we put 1 in hashset, in next iteration sum will be 1 + 2 = 3, we put 3 in hashset, in next iteration sum will be 3 + 1 = 4, we already have 4 in hashset so we return true
        //this works because. [4 ,-3 ,2, 1], in first iteration, we have 4, if we have 4 again at some point of iteration, that means we have got 0 in the subarray, so 4 + 0 will be 4.
        //in this example, first we have 4, and then we get 4 again in last iteration, that means we have got subarray with zero between, 4 and the last iteration, in this example
        //small trick is, (prefixSum - 0 = prefixSum), that means we have found subarray with zero
        int prefixSum = 0;
        for (int item : arr){
            prefixSum += item;
            if (set.contains(prefixSum))
                return true;

            //this condition is to check, if we have prefixSum as 0, in starting subarray itself. example [-1, 4, -3, 5, 1]
            if (prefixSum == 0)
                return true;

            set.add(prefixSum);
        }
        return false;
    }

    //9. Find the subarray with given sum
    //I/P - [5,8,6,13,3,-1], Sum=22,  O/P - true, Because 6 + 13 + 3, makes 22
    //same as previous problem, with a small change. If we get (preSum - sum = value(that is already in set)), that means we have found the subarray with sum
    public static boolean subarrayWithGivenSum(int[] arr, int sum){
        //TC-O(n^2), SC-O(1)
/*        for (int i = 0; i < arr.length; i++) {
            int currSum = 0;
            for (int j = i; j < arr.length; j++) {
                currSum += arr[j];
                if (currSum == sum) return true;
            }
        }
        return false;
 */
        //TC-O(n), SC-O(n)
        Set<Integer> set = new HashSet<>();
        int prefixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (prefixSum == sum)
                return true;
            if (set.contains(prefixSum - sum))
                return true;
            set.add(prefixSum);
        }
        return false;
    }


    //10. Find the longest subarray with given sum
    //I/P - [8, 3, 1, 5, -6, 6, 2, 2], sum=4, O/P = 4
    //I/P - [2, 3, ,5], sum=5, O/P - 2
    //I/P - [3, 2, 5 ,6], sum=4, O/P - 0
    public static int longestSubarrayWithGivenSum(int[] arr, int sum){
        //TC-O(n^2), SC-O(1)
/*      int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            int currSum = 0;
            for (int j = i; j < arr.length; j++) {
                currSum += arr[j];
                if (currSum == sum)
                    maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength;
 */
        //TC-O(n), SC-O(n)
        //this problem is also similar to previous two problems(prefix sum)
        //here we calculate (prefixSum - sum), to check if a subarray forms the sum.
        int maxLength = 0; int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //we iterate through the array
        for (int i = 0; i < arr.length; i++) {
            //at each iteration add current item to prefixSum
            prefixSum += arr[i];
            //if prefixSum is sum, this condition is to check, if the starting of array makes the prefix sum, for example, [2, 3, 5] sum=5, in second iteration we form 5, so we add it to max length
            //if we don't write this condition, it will fail for cases, when array starts with the sum.
            if (prefixSum == sum)
                maxLength = i + 1;

            //if we dont have the prefixSum, already in hashMap, then we add it, because if there are multiple occurrence, we want first occurrence, because we want the max subarray, example - [8, 11, 12,17, 11], we add only the 11 at index-1, because that will max subarray length
            if (!map.containsKey(prefixSum))
                map.put(prefixSum, i);

            //if we find a value in map, with (prefixSum - sum), then we have found a subarray with sum, and update the maxLength
            if (map.containsKey(prefixSum - sum))
                maxLength = Math.max(maxLength, i - map.get(prefixSum - sum));
        }

        return maxLength;
    }

    //11. find largest subarray with equal 0's and 1's
    //I/P - [1,0,1,1,1,0,0] , O/P - 6 || I/P - [1,1,1,1] , O/P - 0 || I/P - [0, 0, 1, 1, 1, 1, 1, 0] , O/P - 4
    public static int largestSubarrayWithEqualZeroesAndOnes(int[] arr) {
        //TC-O(n^2), SC-O(1)
/*        int sum = 0, maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            int countZeros = 0, countOnes = 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] == 0)
                    countZeros++;
                else
                    countOnes++;

                if (countOnes == countZeros)
                    maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength;
 */

        //TC-O(n), SC-O(n)
        //this problem is similar to find largest subarray with zero sum
        //so, we can solve it in same way by converting all zero's to -1 in the array.
        //Note: this solution modifies original array.
/*        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); //insert (0, -1) pair into the set to handle the case when a subarray with zero-sum starts from index 0

        int prefixSum = 0; int maxLength = 0;
        for (int i = 0; i < arr.length; i++){
            //if we see 0 in array, replace with -1, if we replace with -1 our problem will get reduced to find max subarray with zero sum.
            prefixSum += (arr[i] == 0 ? -1 : 1);

            //if the sum is not in hashmap already then add the sum with curr index
            if (!map.containsKey(prefixSum))
                map.put(prefixSum, i);

            //update maxLen of subarray
            maxLength = Math.max(maxLength, i - map.get(prefixSum));
        }
        return maxLength;
 */

        //Same complexity as previous solution, but does not modify the array
        //TC-O(n), SC-O(n)
        int sum = 0, res = 0;
        // build a <sum, index> hashmap
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); //insert (0, -1) pair into the set to handle the case when a subarray with zero-sum starts from index 0
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) sum++;
            else sum--;

            if (!map.containsKey(sum))
                map.put(sum, i);

            res = Math.max(res, i - map.get(sum));
        }
        return res;
    }

    //12. longest common span with same sum in two binary arrays
    //Find longest same sum subarray, both array should have same starting and ending index and should have same sum. The order of one and zero inside subarray does not matter.
    //Assume both arrays have same length.
    //I/P: arr1- [0, 1, 0, 0, 0, 0], arr2-[1, 0, 1, 0, 0, 1], O/P-4, Because we have same sum in both the subarray from, index 1 to 4
    //I/P: arr1- [0, 1, 0, 1, 1, 1, 1], arr2-[1, 1, 1, 1, 1, 0, 1], O/P-6, Because we have same sum in both the subarray from, index 1 to 6
    public static int longestSubarrayWithSameSumInTwoArrays(int[] arr1, int[] arr2){
/*        int maxLength = 0;
        for (int start = 0; start < arr1.length; start++) {
            int sum1 = 0; int sum2 = 0;
            for (int end = start; end < arr1.length; end++) {
                sum1 += arr1[end];
                sum2 += arr2[end];
                if (sum1 == sum2)
                    maxLength = Math.max(maxLength, end - start + 1);
            }
        }
        return maxLength;
 */
        //TC-O(n), SC-O(n), space hashmap-O(n), arr-O(n),so O(n+n)=O(2n) which is O(n)
        //This problem can be reduced to find subarray with zero sum.
        //the trick is to subtract (arr1 - arr2), or (arr2 - arr1). now in this new array, we have to find subarray with zero sum, so we will get the output
        //it works, because - let's take a example arr1- {0, 1, 0, 0, 0, 0}; arr2 = {1, 0, 1, 0, 0, 1}. if we subtract it we get, [-1,1,-1,0,0,-1]. Now, if we check for
        //zero subarray sum, we can get output. now, while subtracting if we have both zeros, we get zeros and if we have both ones in array we get zero. now the extra 1's in arr1 will be 1 in temp
        //and extras 1's in arr2 will be -1 in temp, so if there are equal 1's and -1's they will cancel each other, and we have zero's already in temp, if both are one's and zero's while subtracting.
        Map<Integer ,Integer> map = new HashMap<>(); //O(n) SC
        map.put(0, -1); //insert (0, -1) pair into the map to handle the case when a subarray with zero-sum starts from index 0

        int maxLength = 0; int prefixSum = 0;
        int[] temp = new int[arr1.length];  //O(n) SC
        for (int i = 0; i < arr1.length; i++) {  //O(n) TC
            //subtract arr1 and arr2
            temp[i] = arr1[i] - arr2[i];
            //add the prefixSum in each iteration
            prefixSum += temp[i];
            //if it does not contain, then add it to hashmap, because if we have two occurrences we need first one because, we need longest subarray
            if (!map.containsKey(prefixSum))
                map.put(prefixSum, i);

            //update max length
            maxLength = Math.max(maxLength , i - map.get(prefixSum));
        }
        return maxLength;
    }

    //13. Find the longest consecutive subsequence
    //the elements should be in consecutive increasing order, eg: 1 2 3 4 5. //It can be in any order in array, and at any place
    //I/P - [1, 9, 3, 4, 2, 10, 13] , O/P - 4, Because we have 4 consecutive elements 1,2,3,4
    //I/P - [8, 20, 7, 30] , O/P - 2, Because we have 2 consecutive elements 7,8
    //I/P - [20, 30, 40] , O/P - 1, Because we have no consecutive elements, so single element is considered as one consecutive subsequence
    public static int longestConsecutiveSubsequence(int[] arr){
/*        Arrays.sort(arr);
        int maxLength = 1; int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i] - 1)
                count++;
            else
                count = 1;

            maxLength = Math.max(maxLength, count);
        }
        return maxLength;
 */
        //Efficient Solution - SC-O(n), TC-O(n). this may look like O(n^2) but it's not, because the for loops runs O(n), and while loops run only for two lookups on overage, for every element. for example if arr[i] - 1 is already present we ignore it. we do only two lookup one on if and another on while, we also do lookups and we also ignore some lookups if arr[i]-1 is already present in set.
        //so, on average total complexity is O(n) + O(n) for lookups(only 2 lookups on average inside set for every element), which is O(n) operation
        Set<Integer> set = new HashSet<>();
        int maxLength = 0;
        //insert all elements in to set
        for (var item : arr)
            set.add(item);

        //iterate thru each element
        for (int i = 0; i < arr.length; i++) {
            //if (current element - 1) is not present in set, it means current element is starting of subsequence. If (curr element - 1) is already present, it means it is not starting and we have small number than this, so we simply ignore and move to next iteration
            if (!set.contains((arr[i] - 1))) {
                //if it is present, we set curr as 1
                int curr = 1;
                //check if we have subsequence, if (curr element + curr) is present we have a consecutive subsequence, so we increment curr. we increment curr till consecutive elements are present
                while (set.contains(arr[i] + curr))
                    curr++;

                //update the maxLength
                maxLength = Math.max(maxLength, curr);
            }
        }
        return maxLength;
    }

    //14. Count distinct element in every window
    //there will be (n - k + 1) windows in array of size n
    //I/P-[10, 20, 20, 10, 30, 40, 10],k=4, O/P - 2 3 4 3, in first window(10, 20, 20, 10) we have 2 distinct elements, in second window(20, 20, 10, 30) we have 3 distinct elements, in first window(20, 10, 30, 40) we have 4 distinct elements, in first window(10, 30, 40, 10) we have 3 distinct elements,
    public static void countDistinctInEveryWindow(int[] arr, int k){
        //TC-O((n-k) * k * k), SC-O(1)
        //O(n - k)
/*        for (int i = 0; i <= arr.length - k; i++) {
            int count = 0;
            //O(k)
            for (int j = 0; j < k; j++){
                boolean flag = false;
                //O(K)
                for (int p = 0; p < j; p++) {
                    if (arr[i + j] == arr[i + p]) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) count++;
            }
            System.out.print(count + " ");
        }
 */
        //TC - O(n), SC-O(K)
        //first we insert k elements to hashmap, and print size of hashmap
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        System.out.print(map.size() + " ");

        //then we start iterating from i=k till arr.length
        //in the next process we have to remove first element from previous window, and insert last element from current window
        //to remove first element, we decrement first element in the array in hashmap, if it becomes zero we remove it
        //to insert last element from current window, we simply put arr[i] in to hashmap,
        //finally print size of hashmap
        for (int i = k; i < arr.length; i++) {
            int currItem = arr[i - k];
            //remove first element from previous window
            map.put(currItem, map.get(currItem) - 1);

            //if it becomes zero, remove from hashmap
            if (map.get(currItem) == 0)
                map.remove(currItem);

            //insert, last element from current window
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            System.out.print(map.size() + " ");
        }
    }

    //15. Print the values with More than n/k occurrences
    //I/P-[30, 10, 20, 20, 20, 10, 40, 30, 30], k=4, O/P-20 30
    //I/P-[1,2,3,4,5], k=2, O/P- (print nothing)
    //I/P-[3,1,2,2,1,2,3,3], k=4, O/P- 2 3
    public static void printNbyKOccurrences(int[] arr, int k){
        //O(n ^ 2) Solution,  SC-O(1)
/*        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            //check if item is seen before
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    flag = true;
                    break;
                }
            }
            //if it is seen, ignore and move to next iteration
            if (flag) continue;

            //if not seen before, count frequency
            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    count++;
            }
            if (count > arr.length / k)
                System.out.print(arr[i] + " ");
        }
 */
        //TC-overall O(n log n) -> O(n log n) sorting + O(n) traversal, SC-O(1)
        //The idea is to sort the array and then count the occurrences.
/*        Arrays.sort(arr); //O(n log n)
        int i = 1, count = 1;
        while (i < arr.length){ //O(n), in both the while loops, we are incrementing i, i is bounded by n(arr.length), so overall complexity is O(n)
            //check if previous element is same, if yes increment count and i, till previous element is same
            while (i < arr.length && arr[i] == arr[i - 1]){
                count++;
                i++;
            }
            //check count occurrence and print
            if (count > arr.length / k)
                System.out.print(arr[i - 1] + " ");

            //at this point, we have moved to next occurrence of element in arr, so reset count=1 and increment i.
            count = 1;
            i++;
        }
 */
        //TC-O(n), SC-O(n), this solution is efficient, but if array is very large and k is small, we have to store everything in hashmap and iterating through is not a good idea
        //Enter the frequencies of elements in hashmap, traverse through it and print the element with occurrence > n/k
/*        Map<Integer, Integer> map = new HashMap<>();
        for (int item : arr)
            map.put(item, map.getOrDefault(item, 0) + 1);

        for (var item : map.entrySet())
            if (item.getValue() > arr.length / k)
                System.out.print(item.getKey() + " ");
 */
        //O(nk) Solution, SC-O(k)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            //in each iteration if, arr[i] is already present increase the value by 1
            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            //if it a new item and map is not full, then add it to hashmap
            else if (map.size() < k - 1)
                map.put(arr[i], 1);
            //else if map is full
            else{
                //iterate through hashmap, and decrease all values in hashmap by 1
                for (var item : map.entrySet()){
                    map.put(item.getKey(), item.getValue() - 1);
                    //if value becomes zero, remove it
                    if (map.get(item.getKey()) == 0)
                        map.remove(item.getKey());
                }
            }
        }

        //iterate thru hashmap
        for(var item : map.entrySet()){
            int count=0;
            //for all elements in hashmap, check if it is matching with arr, and increase count
            for(int i=0; i < arr.length; i++)
                if(item.getKey()==arr[i])
                    count++;
            //if count > n/k, print it
            if(count > arr.length/k)
                System.out.print(item.getKey()+" ");
        }
    }
}
