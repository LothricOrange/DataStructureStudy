package com.Jie.JointSearchSetStudy;

public class UnionFind_QU_Size extends UnionFind_QuickUnion{
    protected int[] size;
    public UnionFind_QU_Size(int capacity) {
        super(capacity);
        size = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            size[i] = 1;
        }
    }

    @Override
    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;
        if (size[p1] > size[p2]) {
            parents[p2] = p1;
            size[p1] += size[p2];
        } else {
            parents[p1] = p2;
            size[p2] += size[p1];
        }
    }
}
