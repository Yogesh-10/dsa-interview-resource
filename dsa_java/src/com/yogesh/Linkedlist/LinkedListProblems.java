package com.yogesh.Linkedlist;

import com.yogesh.Linkedlist.LinkedList.Node;

public class LinkedListProblems {
    public static int searchInLinkedList(Node head, int x){
        //TC-O(n), SC-O(1)
//        Node curr = head;
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
}
