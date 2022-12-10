package com.yogesh.Stacks;

public class StackUsingLinkedList {
    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    private Node head;

    public void push(int item){
        Node newNode = new Node(item);

        if (head == null)
            head = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void pop(){
        if (head == null)
            throw new IllegalStateException();
        else{
            Node temp = head.next;
            head.next = null;
            head = temp;
        }
    }

    public int peek(){
        if (head == null)
            throw new IllegalStateException();

        return head.value;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void print(){
        Node current = head;

        if (head == null)
            System.out.println("List is empty");

        while (current != null){
            System.out.print(current.value + " ");
            current = current.next;
        }
    }
}
