package com.company;

public class Main {

    public static void main(String[] args) {
//	   TestClass testClass = new TestClass();
//	   testClass.executeTests();

        ReservationSystem reservationSystem = new ReservationSystem();
        reservationSystem.readVehicleData();
        reservationSystem.printAllVehicles();
    }
}
