package com.Jie.QueueStudy;

import com.Jie.StackStudy.list.LinkedList;
import com.Jie.StackStudy.list.List;

public class Queue<E> {
    private List<E> list = new LinkedList<>();

    public int size() {
        return list.getSize();
    }

    /** Push element x to the back of queue. */
    public void push(E element) {
        list.add(element);
    }

    /** Removes the element from in front of queue and returns that element. */
    public E pop() {
        return list.remove(0);
    }

    /** Get the front element. */
    public E peek() {
        return list.get(0);
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return size() == 0;
    }
}
