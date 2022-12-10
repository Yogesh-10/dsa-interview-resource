package com.yogesh.trees;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);

        Tree tree2 = new Tree();
        tree2.insert(7);
        tree2.insert(5);
        tree2.insert(9);
        tree2.insert(1);
        tree2.insert(6);
        tree2.insert(8);
        tree2.insert(10);
        System.out.println(tree.equals(tree2));
//        System.out.println(tree.getAncestors(10));
//        tree.insert(15);
//        tree.insert(20);
//        tree.insert(33);
//        tree.insert(21);

//       ArrayList<Integer> list = tree.getNodesAtGivenDistance(2);
//       for (var items : list)
//           System.out.print(items + " ");

//        tree.insert(20);
//        tree.insert(6);
//        tree.insert(10);
//        tree.insert(30);
//        tree.insert(31);
//        tree.insert(32);
//        tree.insert(1);
    }
}
