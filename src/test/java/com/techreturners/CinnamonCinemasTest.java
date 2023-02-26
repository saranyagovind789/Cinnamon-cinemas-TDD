
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
    public void setUp(){
        cinema= new CinnamonCinemas(15);
    }

    @ParameterizedTest(name = "{index})  seats: \"{0}\"")
    @ValueSource(ints = {1, 2, 3})
    public void checkValidSingleAllocation(int seatRequested){
        cinema = new CinnamonCinemas(15);
        assertTrue(cinema.allocateSeats(seatRequested));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 4, 18})
    public void checkInvalidSeatAllocation(int seatRequested){
        assertFalse(cinema.allocateSeats(seatRequested));
    }

    @ParameterizedTest(name = "{index}) For multiple seat requests: \"{0}\"")
    @CsvSource(textBlock = """
            1 2 1,
            2 2 2 3 3 3,
            1 2 3 1 2 3 1 1 1
            """)
    public void checkValidMultipleSeatAllocation(String stringOfSeatsRequested) {
        cinema = new CinnamonCinemas(15);
        String[] seatsRequested = stringOfSeatsRequested.split(" ");
        for (String s : seatsRequested) {
            assertTrue(cinema.allocateSeats(Integer.parseInt(s)));
        }
    }
    @ParameterizedTest(name = "{index}) For multiple seats of: \"{0}\"")
    @CsvSource(textBlock = """
            3 3 3 3 3 3,
            2 2 2 3 3 3 2,
            1 2 3 1 2 3 1 1 1 2
            """)
    public void checkInvalidMultipleSeatAllocation(String stringOfSeatsRequested) {
        cinema = new CinnamonCinemas(15);
        int countAllocatedSeats = 15;
        String[] seatsRequested = stringOfSeatsRequested.split(" ");
        for (String s : seatsRequested) {
            countAllocatedSeats -= Integer.parseInt(s);
            if(countAllocatedSeats <= 15 && countAllocatedSeats >=0){
                assertTrue(cinema.allocateSeats(Integer.parseInt(s)));
            }else{
                assertFalse(cinema.allocateSeats(Integer.parseInt(s)));
            }
        }


    }

    @ParameterizedTest(name = "{index}) For seats: \"{0}\" the outcome is \"{1}\"")
    @CsvSource(textBlock = """
            1, A1
            2,  A1 A2,
            3,  A1 A2 A3,
            """)
    public void checkSuccessfulListOfSinglyAllocatedSeats(int seatsRequested, String expectedResult) {
        cinema = new CinnamonCinemas(15);
        List<String> expectedResultList = Arrays.asList(expectedResult.split(" "));
        cinema.allocateSeats(seatsRequested);
        assertEquals(expectedResultList,cinema.getListOfSeatsAllocated());
    }

}
