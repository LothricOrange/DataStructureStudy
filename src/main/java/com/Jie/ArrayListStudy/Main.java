package com.Jie.ArrayListStudy;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<Person>();
        list.add(new Person("Lisa", 19));
        list.add(new Person("Bob", 20));
        list.add(null);
        list.add(new Person("Fuck", 45));
        list.add(new Person("PPT", 100));
        list.remove(4);
        System.out.println(list);

    }
}
