
package com.techreturners;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CinnamonCinemasTest {

    private CinnamonCinemas cinema;

    @BeforeEach
    public void setup(){
       cinema = new CinnamonCinemas(15);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 14, 15})
    public void checkSuccessfulAllocation(){
        cinema = new CinnamonCinemas(15);
        int seatRequested = 1;
        assertTrue(cinema.allocateSeats(seatRequested));

    }

    @ParameterizedTest
    @ValueSource(ints = {0,18})
    public void checkUnSuccessfulAllocation(){
        int seatRequested = 16;
        assertFalse(cinema.allocateSeats(seatRequested));

    }



}
