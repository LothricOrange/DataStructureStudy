package com.Jie.Older;

import com.Jie.LinkedListStudy.AbstractList;

public class SingleLinkedList<E> extends AbstractList<E> {
    private Node<E> first;

    private class Node<E> {
        public E element;
        public Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        if (index == 0) {
            first = new Node<E>(element, first);
        } else {
            Node<E> prev = node(index - 1);
            prev.next = new Node<E>(element, prev.next);
        }
        size++;
    }

    @Override
    public E remove(int index) {
        Node<E> node = node(index);
        Node<E> oldNode = node;
        if (index == size - 1) {
            node(index - 1).next = null;
        } else {
            node.element = node.next.element;
            node = node.next;
        }
        size--;
        return oldNode.element;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) {
                    return i;
                }
                node = node.next;
            }
        }

        return ELEMENTS_NOT_FOUND;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    private Node<E> node(int index) {
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public String toString() {
        StringBuilder strBd = new StringBuilder();
        strBd.append("size:" + size + "\telements:[");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                strBd.append(",");
            }
            strBd.append(node.element);
            node = node.next;
        }
        strBd.append("]");
        return strBd.toString();
    }

}
