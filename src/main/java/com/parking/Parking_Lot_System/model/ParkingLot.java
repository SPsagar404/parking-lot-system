package com.parking.Parking_Lot_System.model;


import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<ParkingSlot> slots;

    public ParkingLot(int capacity) {
        slots = new ArrayList<>();
        for (int i = 1; i <= capacity; i++) {
            slots.add(new ParkingSlot(i));
        }
    }

    public List<ParkingSlot> getSlots() {
        return slots;
    }
}

