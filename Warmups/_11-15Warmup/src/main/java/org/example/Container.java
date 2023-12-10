package org.example;

public class Container<T> {
    private T item;

    // Constructor
    public Container(T item) {
        this.item = item;
    }

    // Getter
    public T get() {
        return item;
    }

    // Setter
    public void set(T item) {
        this.item = item;
    }
}