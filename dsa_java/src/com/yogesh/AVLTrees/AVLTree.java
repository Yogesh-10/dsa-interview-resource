package com.yogesh.AVLTrees;

public class AVLTree {
    public class Node{
        private int val;
        private Node leftChild;
        private Node rightChild;
        private int height;

        public Node(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            return "value=" + this.val;
        }
    }

    private Node root;

    public void insert(int val){
        root = insert(root, val);
    }

    private Node insert(Node root, int val){
       if (root == null)
           return new Node(val);

       if (val < root.val)
           root.leftChild = insert(root.leftChild, val);
       else
           root.rightChild = insert(root.rightChild, val);

       //calculating height of a tree.
       root.height = Math.max(height(root.leftChild),
               height(root.rightChild)) + 1;

       if (isLeftHeavy(root))
           System.out.println(root.val + "is left heavy");
       else if(isRightHeavy(root))
           System.out.println(root.val + "is right heavy");

        return root;
    }

    private boolean isLeftHeavy(Node node){
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(Node node){
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(Node node){
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private int height(Node node){
        return (node == null) ? -1 : node.height;
    }
}
