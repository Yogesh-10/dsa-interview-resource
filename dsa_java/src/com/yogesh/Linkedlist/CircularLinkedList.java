package com.yogesh.Linkedlist;

public class CircularLinkedList {
    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;

    public void addFirst(int value){
        Node newNode = new Node(value);

        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
            return;
        }
        newNode.next = head;
        head = newNode;
        tail.next = newNode;

        //If tail pointer is not maintained, we have to loop through and find the node which next is not head,
        //so that we can link that node to newNode. TC-O(n)
/*      Node curr = head;
        while (curr.next != head)
            curr = curr.next;

        newNode.next = head;
        curr.next = newNode;
        head = newNode;
 */
    }
}
