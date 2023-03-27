package com.Jie.RBTreeStudy.tree;


import com.Jie.RBTreeStudy.printer.BinaryTrees;

public class Demo {
    public static void test1() {
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

    public static void test2() {
        RBTree<Integer> rb = new RBTree<>();
        Integer data[] = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 12, 13, 14, 15, 16
        };
        for (int i = 0; i < data.length; i++) {
            rb.add(data[i]);
        }
        BinaryTrees.println(rb);

    }

    public static void test3() {
        RBTree<Integer> rb = new RBTree<>();
        Integer data[] = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 12, 13, 14, 15, 16
        };
        for (int i = 0; i < data.length; i++) {
            rb.add(data[i]);
        }
        BinaryTrees.println(rb);
        for (int i = 0; i < data.length; i++) {
            System.out.println("----------------------");
            System.out.println("[" + data[i] + "]");
            rb.remove(data[i]);
            BinaryTrees.println(rb);
            System.out.println("----------------------");
        }

    }

    public static void main(String[] args) {
        test3();

    }
}
