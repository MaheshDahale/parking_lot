package com.MangoApps;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotManager {
    private List<Car> tickets;

    public ParkingLotManager(int capacity) {
        tickets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            tickets.add(null);
        }
    }

    public int parkCar(Car car) {
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i) == null) {
                tickets.set(i, car);
                return i + 1;											 // Slot numbers are 1-based
            }
        }
        return -1; 														 // Parking full
    }

    public boolean vacateTicket(int ticketNumber) {
        if (ticketNumber <= tickets.size() && ticketNumber > 0) {
            tickets.set(ticketNumber - 1, null);
            return true;
        }
        return false; 													 // Invalid slot number
    }

    public List<String> findRegistrationNumbersByColor(String color) {
        List<String> registrationNumbers = new ArrayList<>();
        for (Car car : tickets) {
            if (car != null && car.getColor().equalsIgnoreCase(color)) {
                registrationNumbers.add(car.getRegistrationNumber());
            }
        }
        return registrationNumbers;
    }

    public int findTicketNumberByRegistrationNumber(String registrationNumber) {
        for (int i = 0; i < tickets.size(); i++) {
            Car car = tickets.get(i);
            if (car != null && car.getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
                return i + 1; 											// Slot numbers are 1-based
            }
        }
        return -1; 														// Car not found
    }

    public List<Integer> findTicketNumbersByColor(String color) {
        List<Integer> ticketNumbers = new ArrayList<>();
        for (int i = 0; i < tickets.size(); i++) {
            Car car = tickets.get(i);
            if (car != null && car.getColor().equalsIgnoreCase(color)) {
                ticketNumbers.add(i + 1); 								// Slot numbers are 1-based
            }
        }
        return ticketNumbers;
    }
    
    public List<Car> getTickets() {
        return tickets;
    }
    
    public List<Integer> findVacantPlaces() {
        List<Integer> vacantTickets = new ArrayList<>();
        List<Car> tickets = getTickets(); 
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i) == null) {
            	vacantTickets.add(i + 1);								 // Slot numbers are 1-based
            }
        }
        return vacantTickets;
    }
    
    public List<String> showOccupiedPlaces() {
        List<String> occupiedPlaces = new ArrayList<>();
        List<Car> tickets = getTickets();

        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i) != null) {
                Car car = tickets.get(i);
                occupiedPlaces.add("Ticket number : " + (i + 1) + ": " + car.getRegistrationNumber() + " - " + car.getColor());
            }
        }
        return occupiedPlaces;
    }
}
