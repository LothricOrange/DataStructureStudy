package com.Jie.HeapStudy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class BinaryHeap<E> extends AbstractHeap<E>{
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public BinaryHeap(E[] elements, Comparator<E> comparator) {
        super(comparator);
        if (elements == null || elements.length == 0) {
            this.elements = (E[])new Object[DEFAULT_CAPACITY];
        } else {
            size = elements.length;
            int capacity = Math.max(elements.length, DEFAULT_CAPACITY);
            this.elements = (E[])new Object[capacity];
            for (int i = 0; i < elements.length; i++) {
                this.elements[i] = elements[i];
            }
            heapify();
        }


    }

    public BinaryHeap(E[] elements) {
        this(elements, null);

    }

    public BinaryHeap(Comparator<E> comparator) {
        this(null, comparator);

    }




    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        ensureCapacity(size + 1);
        elements[size] = element;
        size++;
        siftUp(size - 1);

    }

    protected void siftUp(int index) {
        E element = elements[index];
        while (index > 0) {
            int parentIndex = (index - 1) >> 1;
            if (compare(elements[index], elements[parentIndex]) <= 0) {
                break;
            }
            elements[index] = elements[parentIndex];
            index = parentIndex;
        }
        elements[index] = element;

    }

    protected void siftDown(int index) {
        int half = size >> 1;
        E element = elements[index];
        while (index < half) {
            int childIndex = (index << 1) + 1;
            E child = elements[childIndex];
            int rightIndex = childIndex + 1;
            if (rightIndex < size && compare(elements[rightIndex], child) > 0) {
                child = elements[rightIndex];
                childIndex = rightIndex;
            }
            if (compare(element, child) >= 0) break;
            element = child;
            index = childIndex;
        }
        elements[index] = element;
    }


    @Override
    public E get() {
        emptyCheck();
        return elements[0];
    }

    @Override
    public E remove() {
        emptyCheck();
        E first = elements[0];
        size--;
        int lastIndex = size;
        elements[0] = elements[lastIndex];
        elements[lastIndex] = null;
        siftDown(0);
        return first;
    }

    @Override
    public E replace(Object element) {
        return null;
    }

    private void heapify() {
        for (int i = (size - 1) >> 1; i >= 0; i++) {
            siftDown(i);
        }
    }



    private void emptyCheck() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }







    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity > capacity) return;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }
}
