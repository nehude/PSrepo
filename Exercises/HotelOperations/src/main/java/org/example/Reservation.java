package org.example;

public class Reservation {
    private RoomType roomType;
    private int numberOfNights;
    private boolean isWeekend;

    public Reservation(RoomType roomType, int numberOfNights, boolean isWeekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    public double getPrice() {
        if (this.roomType == RoomType.KING) {
            return 139;
        } else {
            return 124;
        }
    }
    public double getReservationTotal() {
        double totalPrice = getPrice() * numberOfNights;
        if (isWeekend) {
            totalPrice *= 1.10;
        }
        return totalPrice;
    }
}