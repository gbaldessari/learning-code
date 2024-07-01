package test;

import java.util.EmptyStackException;

public class Stack<T> {
    private Node<T> top;
    private int size;

    // Node class to represent each element in the stack
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    // Pushes an item onto the top of the stack
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Removes and returns the top item of the stack
    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T item = top.data;
        top = top.next;
        size--;
        return item;
    }

    // Returns the top item of the stack without removing it
    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    // Returns true if the stack is empty, false otherwise
    public boolean isEmpty() {
        return top == null;
    }

    // Returns the size of the stack
    public int size() {
        return size;
    }
}

