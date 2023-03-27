package com.Jie.TrieStudy;

import java.util.HashMap;

public class _677_键值映射2 {
    HashMap<String, Integer> map = new HashMap<>();
    public _677_键值映射2() {

    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for (String key : map.keySet()) {
            if (key.startsWith(prefix)) {
                sum += map.get(key);
            }
        }
        return sum;
    }
}
