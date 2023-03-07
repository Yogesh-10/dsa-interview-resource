package com.yogesh.Linkedlist;

import com.yogesh.Linkedlist.LinkedList.Node;

public class LinkedListProblems {
    //1. Search a value in linkedList
    //I/P: 10 -> 20 -> 30, val = 20, O/P - 2
    public static int searchInLinkedList(Node head, int x){
        //TC-O(n), SC-O(1)
//      Node curr = head;
        int position = 1;
        while (head != null){
            if (head.value == x)
                return position;
            else {
                position++;
                head = head.next;
            }
        }
        return -1;

        //Recursive Solution TC-O(n), SC-O(n)
/*      if (head == null)
            return -1;
        if (head.value == x)
            return 1;
        else {
            int res = searchInLinkedList(head.next, x);
            if (res == -1) return -1;
            else return (res + 1);
        }
 */
    }

    //2. Reverse a Linked List
    //I/P: 10 -> 20 -> 30 -> null, O/P - 30 -> 20 -> 10 -> null
    public static Node reverse(Node head){
        //TC-O(n), SC-O(1)
        Node curr = head;
        Node prev = null;
        Node next = null;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    //3. Insert in a sorted linked list
    //I/P: 10 -> 20 -> 30, val = 25, O/P - 10 -> 20 -> 25 -> 30
    //I/P: 10 -> 20 -> 30, val = 5, O/P - 5 -> 10 -> 20 -> 25
    //I/P: 10 -> 20 -> 30, val = 35, O/P - 10 -> 20 -> 30 -> 35
    public static Node sortedInsert(Node head, int val){
        //TC-O(1) if inserted at beginning, O(n) if inserted at last
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return head;
        }
        if (head.value > val){
            newNode.next = head;
            head = newNode;
            return head;
        }
        Node curr = head;
        while (curr.next != null && curr.next.value < val){
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;

        return head;
    }

    //4. Find middle of a LinkedList
    public static Node findMiddleOfLinkedList(Node head){
/*
        //TC-O(n) - two pass
        if (head == null) return null;
        Node curr = head;
        int len = 0;
        while (curr != null){
            curr = curr.next;
            len++;
        }

        curr = head;
        for (int i = 0; i < len / 2; i++){
            curr = curr.next;
        }
        return curr;
 */
        //TC-O(n) Efficient approach - slow and fast pointer
        if (head == null) return null;
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
