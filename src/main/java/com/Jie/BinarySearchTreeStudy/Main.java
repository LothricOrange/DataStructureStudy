package com.Jie.BinarySearchTreeStudy;


import com.Jie.BinarySearchTreeStudy.printer.BinaryTrees;

import java.util.Comparator;

public class Main {


    private static class PersonCompareTo implements Comparator<Person> {
        public int compare(Person e1, Person e2) {
            return e1.getAge() - e2.getAge();
        }
    }
    static void test1() {
        Integer data[] = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }

        BinaryTrees.println(bst);
        System.out.println();
        bst.preOrderTraversal(new BinarySearchTree.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.print("_" + element + "_");
                return false;
            }
        });
        System.out.println();
        bst.inOrderTraversal(
                new BinarySearchTree.Visitor<Integer>() {
                    @Override
                    public boolean visit(Integer element) {
                        System.out.print("_" + element + "_");
                        return false;
                    }
                }
        );
        System.out.println();
        bst.postOrderTraversal(
                new BinarySearchTree.Visitor<Integer>() {
                    @Override
                    public boolean visit(Integer element) {
                        System.out.print("_" + element + "_");
                        return false;
                    }
                }
        );
        System.out.println();
        bst.levelOrderTraversal(
                new BinarySearchTree.Visitor<Integer>() {
                    @Override
                    public boolean visit(Integer element) {
                        System.out.print("_" + element + "_");
                        return false;
                    }
                }
        );
        System.out.println("\n" + bst.height());
    }

    static void test2() {
        BinarySearchTree<Integer> bst = new BinarySearchTree();
        for (int i = 0; i < 10; i++) {
			bst.add((int)(Math.random() * 100));
		}
        BinaryTrees.println(bst);
        System.out.println(bst.height());
        System.out.println(bst.isComplete());
    }

    static void test3() {
        Integer data[] = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 12
        };

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }

        BinaryTrees.println(bst);
        System.out.println();
        bst.remove(7);
        BinaryTrees.println(bst);
    }

    public static void main(String[] args) {
        /*Person p1 = new Person("fuck", 11);
        Person p2 = new Person("you", 12);
        BinarySearchTree bst1 = new BinarySearchTree();
        bst1.add(p1);
        bst1.add(p2);
        BinaryTrees.println(bst1);*/
        test3();

    }
}
