package com.parking.Parking_Lot_System;

import com.parking.Parking_Lot_System.cli.ParkingLotCLI;


public class App 
{
	public static void main(String[] args) {
        ParkingLotCLI parkingLotCLI = new ParkingLotCLI(0); 
        parkingLotCLI.start();
    }
}
