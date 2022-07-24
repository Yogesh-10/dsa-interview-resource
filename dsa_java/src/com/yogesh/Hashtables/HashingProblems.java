package com.yogesh.Hashtables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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


}
