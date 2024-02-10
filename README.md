# Parking Lot System

## Overview
The Parking Lot System is an automated ticketing system that allows customers to use a parking lot without human intervention. It manages parking slots, issues tickets to drivers, and provides various functionalities such as finding registration numbers by color, slot numbers by registration number, etc.

## Features
- Creation of parking lot with a specified capacity
- Parking cars and issuing tickets
- Vacating parking slots when cars leave
- Retrieving information such as registration numbers, slot numbers, and status of the parking lot

## Getting Started
To run the Parking Lot System, follow these steps:

1. Clone the repository to your local machine.
2. Make sure you have Java and Maven installed.
3. Navigate to the project directory.
4. Build the project using Maven: `mvn clean install`
5. Run the application: `java -jar target/parking-lot-system.jar`

## Usage
Once the application is running, you can interact with it via the command-line interface (CLI). Here are some example commands:

- `create_parking_lot <capacity>`: Creates a parking lot with the specified capacity.
- `park <registration_number> <color>`: Parks a car with the given registration number and color.
- `leave <slot_number>`: Vacates the parking slot with the specified number.
- `status`: Displays the current status of the parking lot.
- `registration_numbers_for_cars_with_colour <color>`: Retrieves registration numbers of cars with the specified color.
- `slot_number_for_registration_number <registration_number>`: Retrieves the slot number for the car with the specified registration number.
- `slot_numbers_for_cars_with_colour <color>`: Retrieves slot numbers of cars with the specified color.

## Dependencies
- Java
- Maven

## License
This project is licensed under the MIT License. See the LICENSE file for details.
