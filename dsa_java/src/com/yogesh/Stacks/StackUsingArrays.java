package com.yogesh.Stacks;
import java.util.Arrays;

//Stack implementation using Arrays
//stacks are LIFO
public class StackUsingArrays {
    //we initialize a array
    private int[] arr;
    //we initialize a count variable to keep track of index of array
    private int count =0;

    public StackUsingArrays(int size){
         arr = new int[size];
    }

    public void push(int item){
        //if array is full we throw error
        if (count == arr.length)
            throw new StackOverflowError();

        //add item to stack
        arr[count++] = item;
    }

    public int pop(){
        //if stack is empty throw error
        if (count == 0)
            throw new IllegalStateException();

        //we decrement the count, so that the top element is not seen while printed
        //technically the element is still in memory, but we will not see it while iterating and printing
        //for eg.[10, 20, 30] if we pop()
        //                 *
        //[10, 20, 30]
        //     *
        //the pointer will move from 30 to 20, so we will see only[10, 20]
        return arr[--count];
    }

    public int peek(){
        if (count == 0)
            throw new IllegalStateException();

        //return top most element in stack
        return arr[count - 1];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    @Override
    public String toString(){
        //we copy elements till 0 to count is because,
        //if we print whole stack, we will get [10, 20, 30, 0, 0]
        //so we copy elements from 0 till count and return that copied array
        //so we will get[10, 20, 30]
        int[] copiedElements = Arrays.copyOfRange(arr, 0, count);
        return Arrays.toString(copiedElements);
    }
}
