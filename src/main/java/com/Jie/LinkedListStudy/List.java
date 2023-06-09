package com.Jie.LinkedListStudy;

public interface List<E> {
    static final int ELEMENTS_NOT_FOUND = -1;

    boolean isEmpty();

    boolean contains(E element);

    void add(E element);

    E get(int index);

    E set(int index, E element);

    void add(int index, E element);

    E remove(int index);

    int indexOf(E element);

    void clear();

    String toString();
    boolean equals(Object obj);
}
