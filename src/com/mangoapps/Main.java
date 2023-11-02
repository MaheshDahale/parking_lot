package com.mangoapps;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter parking lot capacity: ");
        int capacity = scanner.nextInt();
        ParkingLotManager manager = new ParkingLotManager(capacity);
        QueryProcessor queryProcessor = new QueryProcessor(manager.parkingLot);

        while (true) {
            System.out.println("Enter command (park, leave, reg_numbers_for_cars_with_color, slot_number_for_registration_number, slot_numbers_for_cars_with_color, exit):");
            String command = scanner.next();

            if (command.equalsIgnoreCase("park")) {
                System.out.print("Enter car registration number and color: ");
                String regNo = scanner.next();
                String color = scanner.next();
                int slot = manager.parkCar(regNo, color);
                if (slot == -1) {
                    System.out.println("Sorry, parking lot is full.");
                } else {
                    System.out.println("Allocated slot number: " + slot);
                }
            } else if (command.equalsIgnoreCase("leave")) {
                System.out.print("Enter slot number to vacate: ");
                int slotNumber = scanner.nextInt();
                if (manager.leaveSlot(slotNumber)) {
                    System.out.println("Slot number " + slotNumber + " is free.");
                } else {
                    System.out.println("Invalid slot number.");
                }
            } else if (command.equalsIgnoreCase("reg_numbers_for_cars_with_color")) {
                System.out.print("Enter color: ");
                String color = scanner.next();
                System.out.println(queryProcessor.processRegistrationNumbersByColor(color));
            } else if (command.equalsIgnoreCase("slot_number_for_registration_number")) {
                System.out.print("Enter registration number: ");
                String regNo = scanner.next();
                int slot = queryProcessor.processSlotNumberByRegistrationNumber(regNo);
                if (slot == -1) {
                    System.out.println("Car not found.");
                } else {
                    System.out.println("Slot number for car with registration number " + regNo + " is: " + slot);
                }
            } else if (command.equalsIgnoreCase("slot_numbers_for_cars_with_color")) {
                System.out.print("Enter color: ");
                String color = scanner.next();
                System.out.println(queryProcessor.processSlotNumbersByColor(color));
            } else if (command.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }

        scanner.close();
    }
}
