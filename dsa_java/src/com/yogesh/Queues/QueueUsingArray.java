package com.yogesh.Queues;

import java.util.Arrays;

//Implementation of queue using two stacks
public class QueueUsingArray {
    private int[] items;
    private int front=0;
    private int rear=0;
    private int size;

    public QueueUsingArray(int size){
        items = new int[size];
    }

    public void enqueue(int item){
        if (isFull())
            throw new IllegalStateException();

        /* items[rear++] = item -> this was code while implementing normal arr before implementing circular array*/
        //but we changed this to circular array because, initially queue is [0, 0, 0, 0, 0]
        //then we add 5 items in the queue. so, [10, 20, 30, 40, 50].
        //now we remove 3 items in the queue.so, [0, 0, 0, 40, 50]
        //now physically array is full, but there are three positions with 0, where we can still add 3 items
        //if we use this code -> items[rear++] = item, rear will be 5, which will result in outOfBounds
        //so we need to point rear to 1st index again.
        // for example.5th index is mapped to 0th index and so on, 5 -> 0, 6 -> 1, 7 -> 2, 8 -> 3, 9 -> 4, 10 -> 5(we can have 5 here bcoz it is outOfBounds)
        //so 10 -> 0, 11 -> 1, and so on.
        //whats common here is, the index on the right side. 0,1,2,3,4. These are all the remainders when divided by 5 with index on left side, 5/5, 6/5, 7/5 and so on..
        //so the formulae here is (rear + 1) % items.length
        //instead of incrementing rear++, we set rear to (rear + 1) % items.length, which will be mapped to 0,1,2,3,4,0,1....
        //basically the array will be circulating b/w (0 and 4)

        //we set item to position at rear
        items[rear] = item;
        //and then set rear to (rear + 1) % items.length, which will be mapped to 0,1,2,3,4, 0,1....so on//basically the array will be circulating b/w (0 and 4)
        rear = (rear + 1) % items.length;//this is the formula for circular array, //to keep the index in range
        size++;// we use size to keep track of number of elements in array
    }

    public int dequeue(){
        if (isEmpty())
            throw new IllegalStateException();

        //we store the item in front in temp variable
        int item =  items[front];
        //and then set it to 0, so that we can use that place to fill another item using enqueue
        items[front] = 0;
        //instead of incrementing front++, we set front to (front + 1) % items.length, so that we can get
        //index that is from (0 to 4).
        //basically the array will be circulating b/w (0 and 4)
        front = (front + 1) % items.length; //to keep the index in range
        size--;// we use size to keep track of number of elements in array
        return item;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return items[front];
    }


    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == items.length;
    }

    public void print(){
        for (int i=0; i<items.length; i++){
            System.out.print(items[i] + " ");
        }
    }

    //this method can also can be used to print items in queue
//    @Override
//    public String toString() {
//        return Arrays.toString(items);
//    }
}

