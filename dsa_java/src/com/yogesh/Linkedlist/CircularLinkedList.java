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

        if (isEmpty()) {
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

    public void addLast(int value){
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
            head.next = newNode;
            return;
        }
        tail.next = newNode;
        newNode.next = head;
        tail = newNode;

        //If tail pointer is not maintained
/*      Node curr = head;
        while (curr.next != head)
            curr = curr.next;

        curr.next = newNode;
        newNode.next = head;
        tail = newNode;
 */
    }

    public void deleteFirst(){
        if (isEmpty()) return;

        if (head.next == head){
            head = tail = null;
            return;
        }

        head = head.next;
        tail.next = head;

        //If tail pointer is not maintained
/*      Node curr = head;
        while (curr.next != head)
            curr = curr.next;

        curr.next = head.next;
        head = head.next;
 */
    }

    public void deleteKthNode(int pos){
        if (pos == 1) {
            deleteFirst();
            return;
        }

        Node curr = head;
        for (int i = 0; i < pos - 2; i++)
            curr = curr.next;

        curr.next = curr.next.next;

        //change tail pointer
        if (curr.next == head)
            tail = curr;
    }

    private boolean isEmpty(){
        return head == null;
    }
}
