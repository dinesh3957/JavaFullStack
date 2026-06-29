package com.Day3.Stack;

public class TestStack {

    public static void main(String[] args) {

        StackDemo stack = new StackDemo(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        stack.peek();

        stack.pop();

        stack.display();

        stack.isEmpty();

    }
}