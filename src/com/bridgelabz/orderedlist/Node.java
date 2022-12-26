package com.bridgelabz.orderedlist;

public class Node<T> {
    T key;

    Node<T> next;

    public Node() {
    }

    public Node(T key) {
        this.key = key;
    }
}