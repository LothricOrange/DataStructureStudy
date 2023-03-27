package com.Jie.LinkedListStudy;

public class Demo {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(2,100);

        System.out.println(list);

    }
}
