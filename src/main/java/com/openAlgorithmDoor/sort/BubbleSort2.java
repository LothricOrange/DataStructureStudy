package com.openAlgorithmDoor.sort;

public class BubbleSort2 {
    public void sort(int[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            boolean search = true;
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int tmp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = tmp;
                    search = false;
                }
            }
            if (search) break;
        }
    }
}
