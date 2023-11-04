package org.example;

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;

    public Room(int numberOfBeds, double price, boolean isOccupied, boolean isDirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
    }

    public int getNumberOfBeds() {
        return this.numberOfBeds;
    }

    public double getPrice() {
        return this.price;
    }

    public boolean isOccupied() {
        return this.isOccupied;
    }

    public boolean isDirty() {
        return this.isDirty;
    }

    public boolean isAvailable() {
        return !isOccupied && !isDirty;
    }

    public void setOccupied(boolean occupied) {
        this.isOccupied = occupied;
    }

    public void setDirty(boolean dirty) {
        this.isDirty = dirty;
    }
    public void checkIn() {
        if (isAvailable()) {
            isOccupied = true;
            isDirty = true;
            System.out.println("check in successful");
        } else {
            System.out.println("Room is already occupied or dirty.");
        }
    }


    public void checkOut() {
        if (isOccupied) {
            isOccupied = false;
            isDirty = true;
            System.out.println("check out successful");
        } else {
            System.out.println("Room is not occupied.");
        }
    }

    public void cleanRoom() {
        if (isDirty) {
            isDirty = true;
        } else {
            System.out.println("Error: Room is already clean.");
        }
    }
}
