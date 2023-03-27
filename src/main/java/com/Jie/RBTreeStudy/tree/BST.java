package com.Jie.RBTreeStudy.tree;

import java.util.Comparator;

public class BST<E> extends BinaryTree<E> {
    private Comparator<E> comparator;

    public BST() {
        this(null);
    }

    public BST(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    protected void afterAdd(Node<E> node) {
    }

    public void add(E element) {
        elementNotNullCheck(element);
        if (root == null) {
            root = createNode(element, null);
            afterAdd(root);
            size++;
            return;
        }
        Node<E> node = root;
        Node<E> parent = root;
        int temp = 0;
        while (node != null) {
            temp = compare(element, node.element);
            parent = node;
            if (temp > 0) {
                node = node.right;
            } else if (temp < 0) {
                node = node.left;
            } else {
                node.element = element;
                return;
            }
        }

        Node<E> newNode = createNode(element, parent);
        if (temp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
        afterAdd(newNode);
    }
    protected void afterRemove(Node<E> node) {}
    public E remove(E element) {
        return remove(node(element));
    }

    public E remove(Node<E> node) {
        if (node == null) return null;
        size--;
        E oldElement = node.element;
        if (node.hasTwoChildren()) {
            Node<E> p = predecessor(node);
            node.element = p.element;
            node = p;
        }
        Node<E> temp = node.left != null ? node.left : node.right;
        if (temp != null) {
            temp.parent = node.parent;
            if (node.parent == null) {
                root = temp;
            } else if (node == node.parent.left) {
                node.parent.left = temp;
            } else {
                node.parent.right = temp;
            }
            afterRemove(temp);
        } else if (node.parent == null) {
            root = null;
            afterRemove(node);
        } else {
            if (node.parent.left == node) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }
            afterRemove(node);
        }

        return oldElement;
    }

    public boolean contain(E element) {
        return node(element) != null;
    }

    private Node<E> node(E element) {
        Node<E> node = root;
        while (node != null) {
            int cmp = compare(element, node.element);
            if (cmp == 0) return node;
            else if (cmp > 0) node = node.right;
            else node = node.left;
        }
        return null;
    }

    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);
    }
}



