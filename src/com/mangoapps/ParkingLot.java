package com.mangoapps;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Car> slots;

    public ParkingLot(int capacity) {
        slots = new ArrayList<>(capacity);
        // Initialize parking slots
        for (int i = 0; i < capacity; i++) {
            slots.add(null);
        }
    }

    public int parkCar(Car car) {
        for (int i = 0; i < slots.size(); i++) {
            if (slots.get(i) == null) {
                slots.set(i, car);
                return i + 1; // Slot numbers are 1-based
            }
        }
        return -1; // Parking full
    }

    public boolean vacateSlot(int slotNumber) {
        if (slotNumber <= slots.size() && slotNumber > 0) {
            slots.set(slotNumber - 1, null);
            return true;
        }
        return false; // Invalid slot number
    }

    public List<String> findRegistrationNumbersByColor(String color) {
        List<String> registrationNumbers = new ArrayList<>();
        for (Car car : slots) {
            if (car != null && car.getColor().equalsIgnoreCase(color)) {
                registrationNumbers.add(car.getRegistrationNumber());
            }
        }
        return registrationNumbers;
    }

    public int findSlotNumberByRegistrationNumber(String registrationNumber) {
        for (int i = 0; i < slots.size(); i++) {
            Car car = slots.get(i);
            if (car != null && car.getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
                return i + 1; // Slot numbers are 1-based
            }
        }
        return -1; // Car not found
    }

    public List<Integer> findSlotNumbersByColor(String color) {
        List<Integer> slotNumbers = new ArrayList<>();
        for (int i = 0; i < slots.size(); i++) {
            Car car = slots.get(i);
            if (car != null && car.getColor().equalsIgnoreCase(color)) {
                slotNumbers.add(i + 1); // Slot numbers are 1-based
            }
        }
        return slotNumbers;
    }
}

