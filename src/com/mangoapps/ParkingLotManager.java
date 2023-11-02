package com.mangoapps;

public class ParkingLotManager {
    private ParkingLot parkingLot;

    public ParkingLotManager(int capacity) {
        parkingLot = new ParkingLot(capacity);
    }

    public int parkCar(String registrationNumber, String color) {
        Car car = new Car(registrationNumber, color);
        return parkingLot.parkCar(car);
    }

    public boolean leaveSlot(int slotNumber) {
        return parkingLot.vacateSlot(slotNumber);
    }
}
