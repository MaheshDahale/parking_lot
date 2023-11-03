package com.MangoApps;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = 0;
        while (capacity <= 0) {
            System.out.print("Enter the parking lot capacity (a positive whole number): ");

            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a positive whole number for the parking lot's capacity.");
                scanner.next();
            }
            
            capacity = scanner.nextInt();

            if (capacity <= 0) {
                System.out.println("Please enter a positive whole number for the parking lot's capacity.");
            }
        }

        ParkingLot manager = new ParkingLot(capacity);

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Available choices: \n" +
                    "1. Park car\n" +
                    "2. Leave car\n" +
                    "3. Display registration numbers for cars with a specific color\n" +
                    "4. Display ticket number for a registration number\n" +
                    "5. Display ticket numbers for cars with a specific color\n" +
                    "6. Display vacant places\n" +
                    "7. Display occupied places\n" +
                    "8. Exit\n" +
                    "Enter your choice:");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Enter car registration number:");
                    String regNo = scanner.next();
                    // Check if the registration number already exists in the parking lot
                    int existingSlot = manager.processTicketNumberByRegistrationNumber(regNo);
                    if (existingSlot != -1) {
                        System.out.println("A car with the same registration number is already parked at ticket " + existingSlot + ".");
                    } else {
                        System.out.println("Enter car color:");
                        String color = scanner.next();
                        int tickets = manager.creatCar(regNo, color);
                        if (tickets == -1) {
                            System.out.println("Sorry, parking lot is full.");
                        } else {
                            System.out.println("Allocated ticket number: " + tickets);
                        }
                    }
                    System.out.println("-------------------------------------------------");
                    break;
                    
                case 2:
                    System.out.println("Enter ticket number to leave:");
                    int ticketNumber = scanner.nextInt();
                    boolean isTicketVacated = manager.leaveTicket(ticketNumber);
                    if (isTicketVacated) {
                        System.out.println("Ticket number " + ticketNumber + " is now free.");
                    } else {
                        System.out.println("Invalid ticket number or already vacant.");
                    }
                    System.out.println("-------------------------------------------------");
                    break;

                case 3:
                    System.out.println("Enter car color to search for registration numbers:");
                    String colorQuery = scanner.next();
                    List<String> registrationNumbers = manager.processRegistrationNumbersByColor(colorQuery);
                    if (registrationNumbers.isEmpty()) {
                        System.out.println("No cars found with the color " + colorQuery);
                    } else {
                        System.out.println("Registration numbers: " + registrationNumbers);
                    }
                    System.out.println("-------------------------------------------------");
                    break;

                case 4:
                    System.out.println("Enter registration number to find its ticket:");
                    String regNoQuery = scanner.next();
                    int ticket = manager.processTicketNumberByRegistrationNumber(regNoQuery);
                    if (ticket == -1) {
                        System.out.println("Car not found.");
                    } else {
                        System.out.println("ticket number for car with registration number " + regNoQuery + " is: " + ticket);
                    }
                    System.out.println("-------------------------------------------------");
                    break;

                case 5:
                    System.out.println("Enter color to search for ticket numbers:");
                    String colorQueryForSlots = scanner.next();
                    List<Integer> ticketNumbers = manager.processTicketNumbersByColor(colorQueryForSlots);
                    if (ticketNumbers.isEmpty()) {
                        System.out.println("No cars found with the specified color.");
                    } else {
                        System.out.println("ticket numbers for cars with the color: " + ticketNumbers);
                    }
                    break;

                case 6:
                    List<Integer> vacantPlaces = manager.findEmptyPlaces();
                    if (vacantPlaces.isEmpty()) {
                        System.out.println("No vacant places in the parking lot.");
                    } else {
                        System.out.println("Vacant places: " + vacantPlaces);
                    }
                    System.out.println("-------------------------------------------------");
                    break;

                case 7:
                    List<String> occupiedPlaces = manager.ShowCarOccupiedPlaces();
                    if (occupiedPlaces.isEmpty()) {
                        System.out.println("No occupied places in the parking lot.");
                    } else {
                        for (String place : occupiedPlaces) {
                            System.out.println(place);
                        }
                    }
                    System.out.println("-------------------------------------------------");
                    break;

                case 8:
                    isRunning = false;
                    System.out.println("-------------------------------------------------");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println("-------------------------------------------------");
                    break;
            }
        }

        scanner.close();
    }
}
