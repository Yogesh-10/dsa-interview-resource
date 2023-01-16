package com.yogesh.Linkedlist;

import com.yogesh.Linkedlist.LinkedList.Node;

public class LinkedListProblems {
    //1. Search a value in linkedList
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
}
