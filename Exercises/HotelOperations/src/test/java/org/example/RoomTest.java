package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    class RoomTest {

        @Test
        public void checkIn_UnoccupiedAndCleanRoom() {
            // Arrange
            Room room = new Room(2, 100.0, false, false);

            // Act
            room.checkIn();

            // Assert
            assertTrue(room.isOccupied());
            assertTrue(room.isDirty());
        }


        @Test
        public void checkOut_OccupiedRoom(){
            // Arrange
            Room room = new Room(2, 100.0, true, true);

            // Act
            room.checkOut();

            // Assert
            assertFalse(room.isOccupied());
            assertTrue(room.isDirty());
        }


        @Test
        public void cleanRoom_UnoccupiedAndDirtyRoom() {
            // Arrange
            Room room = new Room(2, 100.0, false, true);

            // Act
            room.cleanRoom();

            // Assert
            assertFalse(room.isOccupied());
            assertTrue(room.isDirty());
        }
    }
