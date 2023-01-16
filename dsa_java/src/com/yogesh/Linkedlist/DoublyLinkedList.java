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

    public void reverse(){
        if (head == null) return;

        Node curr = head;
        Node prev = null;
        Node next = null;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        tail = head;
        tail.next = null;
        head = prev;
    }

    public void removeFirst(){
        if (head == null )
            return;
        if ( head.next == null) {
            head = tail = null;
            return;
        }
        Node curr = head;
        Node next = curr.next;
        next.prev = null;
        head = next;
    }

    public void removeLast(){
        if (head == null) return;
        if (head.next == null){
            head = tail = null;
            return;
        }
        Node prev = tail.prev;
        prev.next = null;
        tail = prev;

        //if tail pointer is not maintained, we have to traverse the LL and find last node
/*      Node curr = head;
        while (curr.next != null){
            curr = curr.next;
        }
        curr.prev.next = null;
        tail = curr.prev;
 */
    }
}
