package com.techreturners;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        CinnamonCinemas cinema = new CinnamonCinemas(15);
        Random rand = new Random();
        boolean successfulAllocation;
        System.out.println("**Welcome to Cinnamon Cinemas random seat allocation application**");

        do{
            int numberOfSeats = rand.nextInt(3) + 1;
            System.out.println("The number of seats to be allocated " + numberOfSeats);
            successfulAllocation = cinema.allocateSeats(numberOfSeats);
            if(successfulAllocation) {
                List<String> seatList = cinema.getListOfSeatsAllocated();
                System.out.println("Seats Booked :"+ seatList.subList(seatList.size()-numberOfSeats,seatList.size()));
                //System.out.println(cinema.getListOfSeatsAllocated());
            }
            else System.out.println("Sorry seats cannot be allocated. Not enough available seats left");
            System.out.println();
        }while (successfulAllocation);
    }
}