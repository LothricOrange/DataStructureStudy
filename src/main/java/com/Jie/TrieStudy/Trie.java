package com.Jie.TrieStudy;

import com.Jie.HashMapStudy.map.HashMap;

public class Trie<V> {
    private int size;
    private Node<V> root;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
        root = null;
    }

    public boolean contains(String key) {
        Node<V> node = node(key);
        return node != null && node.isWord;
    }

    public V get(String key) {
        Node<V> node = node(key);
        return node != null && node.isWord ? node.value : null;
    }

    public V add(String key, V value) {
        keyCheck(key);
        if (root == null) {
            root = new Node<>(null);
        }
        Node<V> node = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            boolean childrenIsEmpty = node.children == null;
            Node<V> childNode = childrenIsEmpty ? null : node.children.get(c);
            if (childNode == null) {
                childNode = new Node<>(node);
                childNode.character = c;
                node.children = childrenIsEmpty ? new HashMap<>() : node.children;
                node.children.put(c, childNode);
            }
            node = childNode;
        }

        if (node.isWord) {
            V oldValue = node.value;
            node.value = value;
            return oldValue;
        }

        node.isWord = true;
        node.value = value;
        size++;
        return null;
    }

    public V remove(String key) {
        Node<V> node = node(key);
        if (node == null || !node.isWord) return null;
        size--;
        V oldValue = node.value;

        if (node.children != null && !node.children.isEmpty()) {
            node.value = null;
            node.isWord = false;
            return oldValue;
        }

        Node<V> parent;
        while ((parent = node.parent) != null) {
            parent.children.remove(node.character);
            if (parent.isWord || !parent.children.isEmpty()) break;
            node = parent;
        }

        return oldValue;
    }

    public boolean startsWith(String prefix) {
        return node(prefix) != null;
    }

    private Node<V> node(String key) {
        keyCheck(key);
        Node<V> node = root;
        for (int i = 0; i < key.length(); i++) {
            if (node == null || node.children == null || node.children.isEmpty()) {
                return null;
            }
            char c = key.charAt(i);
            node = node.children.get(c);
        }
        return node;
    }

    private void keyCheck(String key) {
        if (key == null || key.length() == 0) {
            throw new IllegalArgumentException("请输入有效key");
        }
    }

    private static class Node<V> {
        Node<V> parent;
        HashMap<Character, Node<V>> children;
        V value;
        boolean isWord;
        Character character;

        public Node(Node<V> parent) {
            this.parent = parent;
        }

    }


}
