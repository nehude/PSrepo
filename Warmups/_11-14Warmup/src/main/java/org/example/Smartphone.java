package org.example;

class Smartphone implements Device {
    @Override
    public void turnOn() {
        System.out.println("Smartphone is turning on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Smartphone is turning off.");
    }
}

