package com.Jie.QueueStudy.circle;

public class CircleQueue<E> {
    private int size = 0;
    private int first = 0;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public CircleQueue(int capacity) {
        capacity = capacity > DEFAULT_CAPACITY ? capacity : DEFAULT_CAPACITY;
        elements = (E[]) new Object[capacity];
    }

    public int index(int index) {
        index += first;
        return index - (index >= elements.length ? elements.length : 0);
    }


    public int size() {
        return size;
    }

    public void push(E element) {
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;
    }

    public E pop() {
        E oldElements = elements[first];
        elements[first] = null;
        first = index(1);
        size--;
        return oldElements;
    }

    public E peek() {
        return elements[first];
    }

    public boolean empty() {
        return size == 0;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity > capacity) return;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[index(i)];
        }
        elements = newElements;
        first = 0;
    }

    public String toString() {
        StringBuilder strBd = new StringBuilder();
        strBd.append("size:" + size + "\tfirst:" + first + "\telements:[");
        for (int i = 0; i < elements.length; i++) {
            if (i != 0) {
                strBd.append(",");
            }
            strBd.append(elements[i]);
        }
        strBd.append("]");
        return strBd.toString();
    }
}
