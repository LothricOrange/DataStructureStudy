package com.Jie.JointSearchSetStudy;

public class UnionFind_QuickUnion extends UnionFind{

    public UnionFind_QuickUnion(int capacity) {
        super(capacity);
    }

    @Override
    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;
        parents[p1] = p2;
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        while (v != parents[v]) {
            v = parents[v];
        }
        return v;
    }
}
