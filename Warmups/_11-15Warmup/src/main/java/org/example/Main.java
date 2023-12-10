package org.example;
public class Main {
    public static void main(String[] args) {
        Container<Integer> intContainer = new Container<>(10);
        System.out.println("Integer stored: " + intContainer.get());
        intContainer.set(20);
        System.out.println("Updated Integer: " + intContainer.get());

        Container<String> stringContainer = new Container<>("Hello");
        System.out.println("String stored: " + stringContainer.get());
        stringContainer.set("World");
        System.out.println("Updated String: " + stringContainer.get());
    }
}