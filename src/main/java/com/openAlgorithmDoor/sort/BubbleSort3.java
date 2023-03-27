package com.openAlgorithmDoor.sort;

public class BubbleSort3 {
    public void sort(int[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            int lastChange = 1;
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int tmp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = tmp;
                    lastChange = begin;
                }
            }
            end = lastChange;
        }
    }
}
