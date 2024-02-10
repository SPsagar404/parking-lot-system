package com.parking.Parking_Lot_System.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.parking.Parking_Lot_System.model.Car;
import com.parking.Parking_Lot_System.model.ParkingLot;
import com.parking.Parking_Lot_System.model.ParkingSlot;
import com.parking.Parking_Lot_System.model.Ticket;
import com.parking.Parking_Lot_System.service.IParkingLotService;

public class ParkingLotServiceImpl implements IParkingLotService {

	private ParkingLot parkingLot;

    public ParkingLotServiceImpl(int capacity) {
        parkingLot = new ParkingLot(capacity);
    }
	
	@Override
	public Ticket parkCar(Car car) {
        Optional<ParkingSlot> availableSlot = parkingLot.getSlots().stream()
                .filter(ParkingSlot::isAvailable)
                .findFirst();

        if (availableSlot.isPresent()) {
            ParkingSlot slot = availableSlot.get();
            slot.setAvailable(false);
            slot.setCar(car);
            return new Ticket(slot.getSlotNumber(), car);
        } else {
            throw new RuntimeException("Sorry, parking lot is full");
        }
    }

	@Override
	public void leaveCar(int slotNumber) {
        Optional<ParkingSlot> slot = parkingLot.getSlots().stream()
                .filter(s -> s.getSlotNumber() == slotNumber)
                .findFirst();

        if (slot.isPresent()) {
            ParkingSlot parkingSlot = slot.get();
            parkingSlot.setAvailable(true);
            parkingSlot.setCar(null);
        } else {
            throw new RuntimeException("Slot number not found");
        }
    }

	@Override
	public List<String> getRegistrationNumbersForCarsWithColor(String color) {
        return parkingLot.getSlots().stream()
                .filter(slot -> !slot.isAvailable() && slot.getCar().getColor().equalsIgnoreCase(color))
                .map(slot -> slot.getCar().getRegistrationNumber())
                .collect(Collectors.toList());
    }

	@Override
	public int getSlotNumberForCar(String registrationNumber) {
        Optional<ParkingSlot> slot = parkingLot.getSlots().stream()
                .filter(s -> !s.isAvailable() && s.getCar().getRegistrationNumber().equalsIgnoreCase(registrationNumber))
                .findFirst();

        return slot.map(ParkingSlot::getSlotNumber).orElse(-1);
    }

	@Override
	public List<Integer> getSlotNumbersForCarsWithColor(String color) {
	    return parkingLot.getSlots().stream()
	            .filter(slot -> !slot.isAvailable() && slot.getCar() != null && slot.getCar().getColor().equalsIgnoreCase(color))
	            .map(ParkingSlot::getSlotNumber)
	            .collect(Collectors.toList());
	}

	@Override
	public List<ParkingSlot> getStatus() {
        return parkingLot.getSlots().stream()
        		.filter(slot -> slot.getCar()!=null)
        		.collect(Collectors.toList());
    }


}
