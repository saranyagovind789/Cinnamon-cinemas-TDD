
package com.techreturners;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CinnamonCinemasTest {

    private CinnamonCinemas cinema;

    @BeforeEach
    public void setup(){
        cinema = new CinnamonCinemas(15);
    }

    @Test
    public void checkSuccessfulAllocation(){
        int seatRequested = 1;
        assertTrue(cinema.allocateSeats(seatRequested));

    }

    @Test
    public void checkUnSuccessfulAllocation(){
        int seatRequested = 16;
        assertFalse(cinema.allocateSeats(seatRequested));

    }



}
