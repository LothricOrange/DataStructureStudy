package com.Jie.JointSearchSetStudy;

public class UnionFind_QU_R_PathSpliting extends UnionFind_QU_Rank {
    public UnionFind_QU_R_PathSpliting(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        while (v != parents[v]) {
            int parent = parents[v];
            parents[v] = parents[parent];
            v = parent;
        }
        return v;
    }
}
