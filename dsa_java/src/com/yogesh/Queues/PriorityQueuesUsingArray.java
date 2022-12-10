package com.yogesh.Queues;

import java.util.Arrays;

//priority queues are not like regular queues which comes out in order from first position of queue
//it is based on priority, for eg: a queue of integers is 1,5,2,4,3. the value when it inserted in queue will be
//1, 2, 3, 4, 5. it is sorted. This is used in real world like sort the email based on priority
//or sort the incident in bug tracking tool based on priority tickets

//priority queues can be implemented using Arrays and Heap
public class PriorityQueuesUsingArray {
    private int[] items;
    private int count;

    public PriorityQueuesUsingArray(int size){
        items = new int[size];
    }

    //we iterate from back of array, because if we start from first, [1, 3, 5, 7] is the array and we want to insert 2
    //2 should be before 3, so [1, 2, 5, 7], 2 will be copied in place of 3, so we lose track of 3
    //so we start from back, [1, 3, 5, 7] -> we check if item at index is greater then item to be inserted
    //if yes, we set [1, 3, 5, 7, 7] -> [1, 3, 5, 5, 7] as we iterate like this we will not lose track of any element
    public void insert(int item){
        //if arr is full we throw error, or we can resize the array(create new arr -
        // double size of items arr and copy all the items from old to new arr and keep on
        //adding elements to new arr.
        if (isFull())
            throw new IllegalStateException();

        //shifting items
        int i;
        for (i = count - 1 ; i >= 0; i--){
            if (items[i] > item){
                items[i + 1] = items[i];
            }
            else break;
        }
        items[i + 1] = item;
        count++; //count num of items in queue
    }

    public int remove(){
        if (isEmpty())
            throw new IllegalStateException();

        //we return last element from queue that is [1,2,3,5,7], 7 is returned
        //because when removing highest priority gets removed first
        //or if we want to remove from first we can use a front pointer and increment it
        //items[front++]
        return items[--count];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    private boolean isFull() {
        return count == items.length;
    }

    public int peek(){
        return items[count-1];
    }

    public void print(){
        for(int i=0; i<count;i++){
            System.out.print(items[i] + " ");
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
