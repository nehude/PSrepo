package org.example;

public class Main {
    public static void main(String[] args) {
        Device smartphone = new Smartphone();
        Device laptop = new Laptop();

        smartphone.turnOn();
        laptop.turnOn();

        smartphone.turnOff();
        laptop.turnOff();
    }
}