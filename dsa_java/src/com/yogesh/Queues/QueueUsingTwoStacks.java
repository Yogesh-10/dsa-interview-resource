package com.yogesh.Queues;

import java.util.Stack;

//Implementation of queue using two stacks
//Algorithm here is
//s1 - [], s2 - [] there are 2 stacks
//for enqueue operations we push item in to stack 1. so for example we add 5 items
//so s1 is [10, 20, 30, 40, 50]. so when we remove item from queue first element should be
//removed. i.e, 10 is removed, but we have 10 at bottom of the stack, for this we reverse this stack
// and push in to s2, so we pop each item from s1 and push to s2

//now s2 will be - [50, 40, 30, 20, 10]. now when we pop from stack, 10 is at top of stack, so
//10 is removed.
//now s1 will be empty because we moved all item from s1 to s2
//and s2 will be[50, 40, 30, 20, 10].
//now when we add new item we should add to s1. because if we add directly to s2, it will mess up
//the order and correct element will not be removed.
//so we add it to s1 and wait until s2 gets empty, as soon as s2 gets empty we move elements from
//s1 to s2, so now if we pop from s2 correct element will be removed from queue
//In a high level, s1 is for enqueue, and s2 is for dequeue
public class QueueUsingTwoStacks {
    //we declare 2 stacks
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int item){
        stack1.push(item);
    }

    public int dequeue(){
        if (isEmpty())
            throw new IllegalStateException();

        //we add elements from s1 to s2 only if s2 is empty
        if (stack2.isEmpty())
            //we pop each item from s1 and push to s2, so it is reversed, so that front element in queue is removed
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());

        //we remove the top element from stack2, which means front element from queue is removed
        //for eg: [10, 20, 30], here 10 is removed. because from s2, 10 is the top element
        return stack2.pop();
    }

    //this is same as dequeue method, only change is we return peek instead of pop
    public int peek(){
        if (isEmpty())
            throw new IllegalStateException();

        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());

        return stack2.peek();
    }

    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

}
