package com.Jie.QueueStudy;

import com.Jie.StackStudy.list.LinkedList;
import com.Jie.StackStudy.list.List;

public class Deque<E> {
    private List<E> list = new LinkedList<>();

    public int size() {
        return list.getSize();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void enQueueRear(E element) {
        list.add(element);
    }

    public E deQueueRear() {
        return list.remove(size() - 1);
    }

    public E peekRear() {
        return list.get(size() - 1);
    }

    public void enQueueFront(E element) {
        list.add(0,element);
    }

    public E deQueueFront() {
        return list.remove(0);
    }

    public E peekFront() {
        return list.get(0);
    }


}
