package com.MangoApps;

import java.util.List;

public class ParkingLot {
    private ParkingLotManager parkingLot;

    public ParkingLot(int capacity) {
        parkingLot = new ParkingLotManager(capacity);
    }

    public int creatCar(String registrationNumber, String color) {
        Car car = new Car(registrationNumber, color);
        return parkingLot.parkCar(car);
    }

    public boolean leaveTicket(int ticketNumber) {
        return parkingLot.vacateTicket(ticketNumber);
    }

    public List<String> processRegistrationNumbersByColor(String color) {
        return parkingLot.findRegistrationNumbersByColor(color);
    }

    public int processTicketNumberByRegistrationNumber(String registrationNumber) {
        return parkingLot.findTicketNumberByRegistrationNumber(registrationNumber);
    }

    public List<Integer> processTicketNumbersByColor(String color) {
        return parkingLot.findTicketNumbersByColor(color);
    }

    public List<Car> getTickets() {
        return parkingLot.getTickets();
    }

	public List<Integer> findEmptyPlaces() {
		return parkingLot.findVacantPlaces();
	}

	public List<String> ShowCarOccupiedPlaces() {
		return parkingLot.showOccupiedPlaces();
	}

}

