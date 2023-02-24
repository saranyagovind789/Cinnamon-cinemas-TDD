
package com.techreturners;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

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
    @ParameterizedTest
    @CsvSource(textBlock = """
            2,  A1 A2,
            4,  A1 A2 A3 A4,
            7,  A1 A2 A3 A4 A5 B1 B2,
            15, A1 A2 A3 A4 A5 B1 B2 B3 B4 B5 C1 C2 C3 C4 C5
            """)
    public void checkSuccessfulListOfAllocatedSeats(int seatsRequested, String expectedResult) {
        cinema = new CinnamonCinemas(15);
        List<String> expectedResultList = Arrays.asList(expectedResult.split(" "));
        cinema.allocateSeats(seatsRequested);
        assertEquals(expectedResultList,cinema.getListOfSeatsAllocated());
    }



}
