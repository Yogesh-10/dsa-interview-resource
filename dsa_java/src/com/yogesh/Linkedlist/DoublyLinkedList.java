package com.yogesh.Linkedlist;

public class DoublyLinkedList {
    private class Node {
        int value;
        Node next;
        Node prev;

        //we set the value of newNode by creating a newNode object and passing
        //value through constructor
        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;

    public void addFirst(int data){
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(int data){
        Node newNode = new Node(data);

        if (head == null)
            head = tail = newNode;
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
}
