package com.yogesh.Queues;

import java.util.Queue;
import java.util.Stack;

public class Exercise {
    //1. Reverse a queue.
    public void reverse(Queue<Integer> queue){
        //The idea here is to use a stack and queue
        //Queue - [10, 20, 30]
        //so we remove each item from queue and push it in to stack
        //stack - [10, 20, 30]
        //now we can remove from stack, so the top element is removed first and pushed in to queue
        //so now queue is [30, 20, 10]
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty()){
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()){
            queue.add(stack.pop());
        }
    }

}
