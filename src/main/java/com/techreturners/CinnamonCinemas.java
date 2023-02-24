package com.techreturners;

import java.util.ArrayList;
import java.util.List;

public class CinnamonCinemas {
    private int totalAvailabeSeats;
    private final List<String> allocatedSeatList;
    private final boolean[][] seatMap;


    public CinnamonCinemas( int totalAvailableSeats){
        this.totalAvailabeSeats = totalAvailableSeats;
        allocatedSeatList = new ArrayList<>();
        seatMap = new boolean[3][5];

    }

    public boolean allocateSeats(int seatRequested) {
        boolean ableToAllocate = false;
        if(seatRequested > totalAvailabeSeats) return false;
        for(int row = 0; row < seatMap.length; row++){
            for(int seat = 0; seat< seatMap[0].length; seat++){
                if(!seatMap[row][seat] && seatRequested > 0){
                    seatMap[row][seat] = true;
                    ableToAllocate = true;
                    listOfSeatsAllocated(row,seat);
                    totalAvailabeSeats--;
                    seatRequested--;

                }
            }
            if(seatRequested == 0) break;
        }
        return ableToAllocate  && totalAvailabeSeats>0;
       // return true;
    }

    private void listOfSeatsAllocated(int row, int seat){
        StringBuilder sb = new StringBuilder();
        if(row == 0) sb.append("A").append(seat+1);
        else if(row == 1) sb.append("B").append(seat+1);
        else if(row == 2) sb.append("C").append(seat+1);
        allocatedSeatList.add(sb.toString());
    }

    public List<String> getListOfSeatsAllocated() {
        return allocatedSeatList;
    }
}
