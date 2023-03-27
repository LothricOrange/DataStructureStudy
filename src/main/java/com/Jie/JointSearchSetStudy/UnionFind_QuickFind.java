package com.Jie.JointSearchSetStudy;

public class UnionFind_QuickFind extends UnionFind {

    public UnionFind_QuickFind(int capacity) {
        super(capacity);
    }

    @Override
    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == p1) {
                parents[i] = p2;
            }
        }
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        return parents[v];
    }
}
