package com.mangoapps;
import java.util.List;

public class QueryProcessor {
    private ParkingLot parkingLot;

    public QueryProcessor(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public List<String> processRegistrationNumbersByColor(String color) {
        return parkingLot.findRegistrationNumbersByColor(color);
    }

    public int processSlotNumberByRegistrationNumber(String registrationNumber) {
        return parkingLot.findSlotNumberByRegistrationNumber(registrationNumber);
    }

    public List<Integer> processSlotNumbersByColor(String color) {
        return parkingLot.findSlotNumbersByColor(color);
    }
}
