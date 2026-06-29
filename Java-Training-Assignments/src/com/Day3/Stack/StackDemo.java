package com.Day3.Stack;

public class StackDemo {

    private int[] stack;
    private int top;
    private int size;

    // Constructor
    public StackDemo(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    // Push operation
    public void push(int value) {
        if (top == size - 1) {
            System.out.println("Stack Overflow! Cannot insert " + value);
        } else {
            top++;
            stack[top] = value;
            System.out.println(value + " pushed into stack.");
        }
    }

    // Pop operation
    public void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow! Stack is empty.");
        } else {
            System.out.println(stack[top] + " removed from stack.");
            top--;
        }
    }

    // Peek operation
    public void peek() {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Top element: " + stack[top]);
        }
    }

    // Display operation
    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack elements are:");
            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }

    // Check if empty
    public void isEmpty() {
        if (top == -1) {
            System.out.println("Stack is Empty");
        } else {
            System.out.println("Stack is Not Empty");
        }
    }
}