package com.Jie.BinarySearchTreeStudy;

public class Person implements Comparable<Person>{
    private int age;
    private String name;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public int compareTo(Person e) {
        return this.age - e.age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return getAge() + "";
    }
}
