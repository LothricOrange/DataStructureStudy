package com.Jie.TrieStudy;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class _677_键值映射 {
    private Node root;

    public _677_键值映射() {

    }

    public void insert(String key, int value) {
        keyCheck(key);
        if (root == null) {
            root = new Node(null);
        }
        Node node = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            boolean childrenIsEmpty = node.children == null;
            Node childNode = childrenIsEmpty ? null : node.children.get(c);
            if (childNode == null) {
                childNode = new Node(node);
                childNode.character = c;
                node.children = childrenIsEmpty ? new HashMap<>() : node.children;
                node.children.put(c, childNode);
            }
            node = childNode;
        }

        if (node.isWord) return;

        node.isWord = true;
        node.value = value;
    }


    /**
     * oldSon can't do this
     *
     * @param
     * @return
     */
    public int sum(String prefix) {
        Node node = node(prefix);
        if (node == null) return 0;
        int sum = 0;
        sum += node.value;

        return sum;
    }

    public boolean startsWith(String prefix) {
        return node(prefix) != null;
    }

    private void keyCheck(String key) {
        if (key == null || key.length() == 0) {
            throw new IllegalArgumentException("请输入有效key");
        }
    }

    private Node node(String key) {
        keyCheck(key);
        Node node = root;
        for (int i = 0; i < key.length(); i++) {
            if (node == null || node.children == null || node.children.isEmpty()) {
                return null;
            }
            char c = key.charAt(i);
            node = node.children.get(c);
        }
        return node;
    }

    private static class Node {
        Node parent;
        HashMap<Character, Node> children;
        int value;
        boolean isWord;
        Character character;

        public Node(Node parent) {
            this.parent = parent;
        }

    }

}
