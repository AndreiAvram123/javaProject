package com.company;

import java.util.Scanner;

public class Car extends Vehicle {
    private String bodyType;
    private int noOfDoors;
    private int noOfSeats;

    //default constructor
    public Car() {

    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println(String.format("Body type %s\nNumber of doors %s" +
                "\nNumber of seats %s ", bodyType, noOfDoors, noOfSeats));
        //Make the output more readable by adding new lines
        System.out.println("\n\n\n");
    }

    @Override
    public void readData(Scanner scanner) {
        if (scanner != null) {
            super.readData(scanner);
            bodyType = scanner.next();
            noOfDoors = scanner.nextInt();
            noOfSeats = scanner.nextInt();
            scanner.close();
        }
    }

    public String getBodyType() {
        return bodyType;
    }

    public int getNoOfDoors() {
        return noOfDoors;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }
}
