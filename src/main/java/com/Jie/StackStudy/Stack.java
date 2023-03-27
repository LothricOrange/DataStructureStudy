package com.Jie.StackStudy;

import com.Jie.StackStudy.list.ArrayList;
import com.Jie.StackStudy.list.List;

public class Stack<E> {
    private List<E> list = new ArrayList<>();

    public int size() {
        return list.getSize();
    }


    public void push(E element) {
        list.add(element);
    }


    public E pop() {
        return list.remove(size() - 1);
    }


    public E peek() {
        return list.get(size() - 1);
    }


    public boolean empty() {
        return size() == 0;
    }

}
