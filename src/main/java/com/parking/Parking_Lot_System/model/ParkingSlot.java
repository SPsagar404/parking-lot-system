package com.parking.Parking_Lot_System.model;


public class ParkingSlot {
    private int slotNumber;
    private boolean available;
    private Car car;

    public ParkingSlot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.available = true;
        this.car = null;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

	@Override
	public String toString() {
		return slotNumber + "      " + car.getRegistrationNumber() + " " + car.getColor();
	}
    
    
}
