package com.Jie.QueueStudy;

public class Main {
    public static void main(String[] args) {

        /*Queue<Integer> queue = new Queue<>();
        queue.push(11);
        queue.push(22);
        queue.push(33);
        queue.push(44);
        System.out.println("queue.peek() = " + queue.peek());
        while (!queue.empty()) {
            System.out.println(queue.pop());
        }*/
        Deque<Integer> deque = new Deque<>();
        deque.enQueueFront(11);
        deque.enQueueFront(22);
        deque.enQueueRear(33);
        deque.enQueueRear(44);
        while (!deque.isEmpty()) {
            System.out.println(deque.deQueueFront());
        }
    }
}
