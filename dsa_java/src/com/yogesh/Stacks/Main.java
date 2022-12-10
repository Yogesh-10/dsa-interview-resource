package com.yogesh.Stacks;

public class Main {
    public static void main(String[] args) {
        /* stack using arrays */
//        StackUsingArrays stack = new StackUsingArrays(5);
//        stack.push(10);
//        stack.push(20);
//        stack.push(30);
//        stack.pop();
//        System.out.println(stack.peek());
//        System.out.println(stack.isEmpty());

//        Exercise exercise = new Exercise();
        //1. reverse string
//        String res = exercise.stringReverse("abcd");
//        System.out.println(res);
        //2. Balanced expression
//        boolean res = exercise.isBalanced("{({1+2)}}");
//        System.out.println(res);


        /* stack using LinkedList */
        StackUsingLinkedList stackUsingLinkedList = new StackUsingLinkedList();
        stackUsingLinkedList.push(10);
        stackUsingLinkedList.push(20);
        stackUsingLinkedList.push(30);
        stackUsingLinkedList.pop();
        stackUsingLinkedList.print();
        System.out.println("\n" + stackUsingLinkedList.peek());
        System.out.println(stackUsingLinkedList.isEmpty());
    }
}
