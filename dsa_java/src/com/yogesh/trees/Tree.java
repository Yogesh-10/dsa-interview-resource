package com.yogesh.trees;

import java.util.ArrayList;
import java.util.List;

//Implementing Binary search tree
public class Tree {
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value){
            this.value = value;
        }
    }

    private Node root;

    public void insert(int value){
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        while (true){
            if (value < current.value){
                if (current.leftChild == null){
                    current.leftChild = newNode;
                    break;
                }
                current = current.leftChild;
            }
            else{
                if (current.rightChild == null){
                    current.rightChild = newNode;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value){
        Node current = root;
        while(current != null){
            if (value < current.value)
                current = current.leftChild;
            else if(value > current.value)
                current = current.rightChild;
            else
                return true;
        }
        return false;
    }
    /*Tree traversals*/
    //1.pre-order traversal - (root, left, right)
    public void preOrderTraversal(){
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node root){
        if (root == null)
            return;

        System.out.println(root.value);
        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);
    }

    //2.
    public void inOrderTraversal(){
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node root){
        if (root == null)
            return;

        inOrderTraversal(root.leftChild);
        System.out.println(root.value);
        inOrderTraversal(root.rightChild);
    }

    //3.
    public void postOrderTraversal(){
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node root){
        if (root == null)
            return;

        postOrderTraversal(root.leftChild);
        postOrderTraversal(root.rightChild);
        System.out.println(root.value);
    }
    public int height(){
        return height(root);
    }

    private int height(Node root){
        if (root == null)
            return -1;

        if (root.leftChild == null && root.rightChild == null)
            return 0;

        int leftHeight = height(root.leftChild);
        int rightHeight = height(root.rightChild);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    //Min value in a binary tree
    public int min(){
        return min(root);
    }

    private int min(Node root) {
        if(root == null)
            return Integer.MAX_VALUE;

        if (root.leftChild == null && root.rightChild == null)
            return root.value;

        int left = min(root.leftChild);
        int  right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    //minimum value in a BST
    public int minValueForBST(){
        return minValueForBST(root);
    }

    private int minValueForBST(Node root){
        if (root == null)
            throw new IllegalStateException();

        //iterative
        Node current = root;
        Node last = current;
        while (current != null){
            last = current;
            current = current.leftChild;
        }
        return last.value;

        //recursive
//        if (root.leftChild == null)
//            return root.value;
//
//        return minValueForBST(root.leftChild);
    }

    //check if two trees are equal(interview ques)
    public boolean equals(Tree other){
        if (other == null)
            return false;

        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null)
            return true;

        if (first != null && second != null) {
            boolean res = first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);

            return res;
        }

        return false;
    }

    //validate if a tree is a binary search tree
    public boolean isBinarySearchTree(){
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null)
            return true;

        if (root.value < min || root.value > max)
            return false;

        return isBinarySearchTree(root.leftChild, min, root.value - 1)
                && isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    public ArrayList<Integer> getNodesAtGivenDistance(int distance){
        ArrayList<Integer> list = new ArrayList<>();
        getNodesAtGivenDistance(root, distance, list);
        return list;
    }

    private void getNodesAtGivenDistance(Node root, int dist, ArrayList<Integer> list) {
        if (root == null)
            return;

        if (dist == 0) {
            list.add(root.value);
            return;
        }
        getNodesAtGivenDistance(root.leftChild, dist-1, list);
        getNodesAtGivenDistance(root.rightChild, dist-1, list);
    }

    public void levelOrderTraversal(){
        for (int i = 0; i <= height(); i++)
            for (var items : getNodesAtGivenDistance(i))
                System.out.print(items + " ");
    }

    public int size(){
        return size(root);
    }

    private int size(Node root){
        if (root == null)
            return 0;

        if (root.leftChild == null && root.rightChild == null)
            return 1;

        return 1 + size(root.leftChild) + size(root.rightChild);
    }

    public int countLeaves(){
        return countLeaves(root);
    }

    private int countLeaves(Node root){
        if (root == null)
            return 0;

        if (root.leftChild == null && root.rightChild == null)
            return 1;

        return countLeaves(root.leftChild) + countLeaves(root.rightChild);
    }

    public int maxValueForBST(){
        return maxValueForBST(root);
    }

    private int maxValueForBST(Node root) {
        if (root == null)
            throw new IllegalStateException();

        //recursive
        if (root.rightChild == null)
            return root.value;

        return maxValueForBST(root.rightChild);

        //iterative
//        Node current = root;
//        Node last = current;
//
//        while (current != null){
//            last = current;
//            current = current.rightChild;
//        }
//        return last.value;
    }

    public boolean contains(int value){
        return contains(root, value);
    }
    public boolean contains(Node root, int value){
        if (root == null)
            return false;

        if (root.value == value)
            return true;

        return contains(root.leftChild, value) || contains(root.rightChild, value);
    }

    public boolean areSibling(int value1, int value2){
        return areSibling(root, value1, value2);
    }
    private boolean areSibling(Node root, int value1, int value2){
        if (root == null)
            return false;

        if (root.leftChild != null && root.rightChild != null) {
            return root.leftChild.value == value1 && root.rightChild.value == value2
                    || (root.leftChild.value == value2 && root.rightChild.value == value1)
                    || areSibling(root.leftChild, value1, value2)
                    || areSibling(root.rightChild, value1, value2);
        }
        return false;
    }

    public List<Integer> getAncestors(int value){
        ArrayList<Integer> list = new ArrayList<>();
        getAncestors(root, value, list);
        return list;
    }

    private boolean getAncestors(Node root, int value, ArrayList<Integer> list) {
        // We should traverse the tree until we find the target value. If
        // find the target value, we return true without adding the current node
        // to the list; otherwise, if we ask for ancestors of 5, 5 will be also
        // added to the list.
        if (root == null)
            return false;

        if (root.value == value)
            return true;

        // If we find the target value in the left or right sub-trees, that means
        // the current node (root) is one of the ancestors. So we add it to the list.
        if (getAncestors(root.leftChild, value, list)
                || getAncestors(root.rightChild, value, list)) {
            list.add(root.value);
            return true;
        }
        return false;
    }
}
