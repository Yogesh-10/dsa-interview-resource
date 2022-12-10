package com.yogesh.Queues;

public class Main {
    public static void main(String[] args) {
       /* Queue Using Array

        QueueUsingArray queueUsingArray = new QueueUsingArray(5);
        queueUsingArray.enqueue(10);
        queueUsingArray.enqueue(20);
        queueUsingArray.enqueue(30);
        queueUsingArray.enqueue(40);
        queueUsingArray.enqueue(50);
        queueUsingArray.dequeue();
        queueUsingArray.dequeue();
        queueUsingArray.print();
        System.out.println("\n" + queueUsingArray.peek());
        System.out.println(queueUsingArray.isEmpty());
        System.out.println(queueUsingArray.isFull());
        */

        /* Queue Using Two Stacks

        QueueUsingTwoStacks queueUsingTwoStacks = new QueueUsingTwoStacks();
        queueUsingTwoStacks.enqueue(10);
        queueUsingTwoStacks.enqueue(20);
        queueUsingTwoStacks.enqueue(30);
        System.out.println(queueUsingTwoStacks.dequeue());
        System.out.println(queueUsingTwoStacks.dequeue());
        System.out.println(queueUsingTwoStacks.dequeue());
        */

        /* Priority queue using Arrays

        PriorityQueuesUsingArray priorityQueues = new PriorityQueuesUsingArray(5);
        priorityQueues.insert(1);
        priorityQueues.insert(3);
        priorityQueues.insert(5);
        priorityQueues.insert(7);
        priorityQueues.insert(2);
        priorityQueues.remove();
        priorityQueues.remove();
        priorityQueues.print();
        System.out.println();
        System.out.println(priorityQueues.peek());
        */

        /* Exercise Problems

        Exercise exercise = new Exercise();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        exercise.reverse(queue);
        System.out.println(queue);
        */
    }
}
