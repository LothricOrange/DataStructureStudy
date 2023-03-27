package com.Jie.AVLTreeStudy.tree;


import com.Jie.AVLTreeStudy.printer.BinaryTrees;

public class Demo {
    public static void main(String[] args) {
        /*AVLTree<Integer> avl = new AVLTree<>();
        BST<Integer> bst = new BST<>();
        Integer data[] = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 12, 13, 14, 15, 16
        };

        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        for (int i = 0; i < data.length; i++) {
            avl.add(data[i]);
        }
        BinaryTrees.println(bst);
        System.out.println("-----------------");
        BinaryTrees.println(avl);*/
        AVLTree<Integer> avl = new AVLTree<>();
        Integer data[] = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 12, 13, 14, 15, 16
        };
        for (int i = 0; i < data.length; i++) {
            avl.add(data[i]);
        }
        BinaryTrees.println(avl);
        System.out.println("-----------------");
        for (int i = 0; i < data.length; i++) {
            int a = avl.remove(data[i]);
            System.out.println("{" + a + "}");
            BinaryTrees.println(avl);
        }

    }
}
