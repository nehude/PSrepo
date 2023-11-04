package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    @Test
    public void  getPrice_KingSize_IsCorrect(){
        //Arrange
        Reservation newReservation = new Reservation(RoomType.KING, 1, true);
        //Act
        double testPrice = newReservation.getPrice();
        //Assert
        //Compare what i got to what i expect
        assertEquals(139, testPrice);
    }
    @Test
    public void  getPrice_DoubleSize_IsCorrect(){
        Reservation newReservation = new Reservation(RoomType.DOUBLE, 2, false);

        double testPrice = newReservation.getPrice();

        assertEquals(124, testPrice);
    }
}