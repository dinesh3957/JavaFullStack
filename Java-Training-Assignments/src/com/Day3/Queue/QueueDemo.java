package com.Day3.Queue;

public class QueueDemo {

    int queue[];
    int front;
    int rear;
    int size;

    public QueueDemo(int size) {
        this.size = size;
        queue = new int[size];
        front = 0;
        rear = -1;
    }

    public void enqueue(int value) {

        if (rear == size - 1) {
            System.out.println("Queue is Full");
        } else {
            rear++;
            queue[rear] = value;
            System.out.println(value + " inserted");
        }
    }

    public void dequeue() {

        if (front > rear) {
            System.out.println("Queue is Empty");
        } else {
            System.out.println(queue[front] + " removed");
            front++;
        }
    }

    public void peek() {

        if (front > rear) {
            System.out.println("Queue is Empty");
        } else {
            System.out.println("Front Element = " + queue[front]);
        }
    }

    public void display() {

        if (front > rear) {
            System.out.println("Queue is Empty");
        } else {
            System.out.println("Queue Elements:");

            for (int i = front; i <= rear; i++) {
                System.out.println(queue[i]);
            }
        }
    }
}