package com.Jie.JointSearchSetStudy;

public class UnionFind_QU_R_PathCompression extends UnionFind_QU_Rank{
    public UnionFind_QU_R_PathCompression(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        if (v != parents[v]) {
            parents[v] = find(parents[v]);
        }
        return parents[v];
    }
}
