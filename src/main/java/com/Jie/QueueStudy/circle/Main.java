package com.Jie.QueueStudy.circle;

public class Main {
    public static void main(String[] args) {
        CircleQueue<Integer> circleQueue = new CircleQueue<>(10);
        for (int i = 0; i < 10; i++) {
            circleQueue.push(i);
        }

        for (int i = 0; i < 3; i++) {
            circleQueue.pop();
        }

        for (int i = 10; i < 18; i++) {
            circleQueue.push(i);
        }

        System.out.println(circleQueue);


    }
}
