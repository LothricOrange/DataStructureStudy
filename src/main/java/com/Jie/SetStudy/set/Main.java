package com.Jie.SetStudy.set;

public class Main {

    static void test1() {
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(12);
        treeSet.add(10);
        treeSet.add(7);
        treeSet.add(11);
        treeSet.add(10);
        treeSet.add(11);
        treeSet.add(9);

        treeSet.traversal(new Set.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.println(element);
                return false;
            }
        });
    }

    static void test2() {
        Set<Integer> listSet = new ListSet<>();
        listSet.add(12);
        listSet.add(10);
        listSet.add(7);
        listSet.add(11);
        listSet.add(10);
        listSet.add(11);
        listSet.add(9);

        listSet.traversal(new Set.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.println(element);
                return false;
            }
        });
    }
    public static void main(String[] args) {
        test2();
    }
}
