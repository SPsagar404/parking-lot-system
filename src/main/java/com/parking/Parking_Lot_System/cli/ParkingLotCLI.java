package com.parking.Parking_Lot_System.cli;

import java.util.Scanner;
import java.util.stream.Collectors;

import com.parking.Parking_Lot_System.model.Car;
import com.parking.Parking_Lot_System.service.IParkingLotService;
import com.parking.Parking_Lot_System.service.impl.ParkingLotServiceImpl;

public class ParkingLotCLI {
    private IParkingLotService parkingLotService;

    public ParkingLotCLI(int capacity) {
        parkingLotService = new ParkingLotServiceImpl(capacity);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to Parking Lot System");
        System.out.println("Enter commands (Type 'exit' to quit)");

        while (true) {
            System.out.print("> ");
            command = scanner.nextLine();
            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "create_parking_lot":
                    if (tokens.length != 2) {
                        System.out.println("Usage: create_parking_lot <capacity>");
                        break;
                    }
                    int capacity = Integer.parseInt(tokens[1]);
                    parkingLotService = new ParkingLotServiceImpl(capacity);
                    System.out.println("Created a parking lot with " + capacity + " slots");
                    break;
                case "park":
                    if (tokens.length != 3) {
                        System.out.println("Usage: park <registration_number> <color>");
                        break;
                    }
                    Car car = new Car(tokens[1], tokens[2]);
                    try {
                        int slotNumber = parkingLotService.parkCar(car).getSlotNumber();
                        System.out.println("Allocated slot number: " + slotNumber);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "leave":
                    if (tokens.length != 2) {
                        System.out.println("Usage: leave <slot_number>");
                        break;
                    }
                    int slotNumber = Integer.parseInt(tokens[1]);
                    parkingLotService.leaveCar(slotNumber);
                    System.out.println("Slot number " + slotNumber + " is free");
                    break;
                case "status":
                    System.out.println("Slot No. Registration No Colour");
                    parkingLotService.getStatus().forEach(System.out::println);
                    break;
                case "registration_numbers_for_cars_with_colour":
                    if (tokens.length != 2) {
                        System.out.println("Usage: registration_numbers_for_cars_with_colour <color>");
                        break;
                    }
                    String color = tokens[1];
                    System.out.println(String.join(", ", parkingLotService.getRegistrationNumbersForCarsWithColor(color)));
                    break;
                case "slot_number_for_registration_number":
                    if (tokens.length != 2) {
                        System.out.println("Usage: slot_number_for_registration_number <registration_number>");
                        break;
                    }
                    String regNumber = tokens[1];
                    int foundSlotNumber = parkingLotService.getSlotNumberForCar(regNumber);
                    if (foundSlotNumber != -1) {
                        System.out.println("Slot number for car with registration number " + regNumber + " is " + foundSlotNumber);
                    } else {
                        System.out.println("Car with registration number " + regNumber + " not found");
                    }
                    break;
                case "slot_numbers_for_cars_with_colour":
                    if (tokens.length != 2) {
                        System.out.println("Usage: slot_numbers_for_cars_with_colour <color>");
                        break;
                    }
                    color = tokens[1];
                    System.out.println(parkingLotService.getSlotNumbersForCarsWithColor(color).stream()
                            .map(Object::toString)
                            .collect(Collectors.joining(", ")));
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}
