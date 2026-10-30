
package com.pathgrid.dsa;

public class CustomQueue<T> {

    // Node represents one element in the queue.
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> front;
    private Node<T> rear;
    private int size;

    public CustomQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Add an element at the rear of the queue.
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    // Remove and return the front element.
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        T data = front.data;
        front = front.next;
        size--;

        if (front == null) {
            rear = null;
        }

        return data;
    }

    // View the front element without removing it.
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        return front.data;
    }

    // Return the queue contents from front to rear (for visualization).
    public java.util.List<T> toList() {
        java.util.List<T> list = new java.util.ArrayList<>();
        for (Node<T> node = front; node != null; node = node.next) {
            list.add(node.data);
        }
        return list;
    }

    // Check whether the queue contains any elements.
    public boolean isEmpty() {
        return size == 0;
    }

    // Return the number of elements.
    public int size() {
        return size;
    }
}
