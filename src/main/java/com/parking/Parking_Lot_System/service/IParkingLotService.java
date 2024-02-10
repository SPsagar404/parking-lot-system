package com.parking.Parking_Lot_System.service;

import java.util.List;

import com.parking.Parking_Lot_System.model.Car;
import com.parking.Parking_Lot_System.model.ParkingSlot;
import com.parking.Parking_Lot_System.model.Ticket;

public interface IParkingLotService {
	
	public Ticket parkCar(Car car);
	
	public void leaveCar(int slotNumber);
	
	public List<String> getRegistrationNumbersForCarsWithColor(String color);
	
	public int getSlotNumberForCar(String registrationNumber);
	
	public List<Integer> getSlotNumbersForCarsWithColor(String color);
	
	public List<ParkingSlot> getStatus();
}
