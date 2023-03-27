package com.Jie.JointSearchSetStudy;

public class UnionFind_QU_Rank extends UnionFind_QuickUnion {
    protected int[] rank;
    public UnionFind_QU_Rank(int capacity) {
        super(capacity);
        rank = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            rank[i] = 1;
        }
    }

    @Override
    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;
        if (rank[v1] > rank[v2]) {
            parents[p2] = p1;
        } else if (rank[v1] < rank[v2]) {
            parents[p1] = p2;
        } else {
            parents[p1] = p2;
            rank[p2] += 1;
        }
    }
}
