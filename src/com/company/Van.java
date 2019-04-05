package com.company;

import java.util.Scanner;

public class Van extends Commercial {
    private double loadVolume;
    private boolean slidingSideDoor;

    public Van() {

    }

    /**
     * This method is used to read all the data about
     * a Van object by passing a scanner object
     * The method overrides the one from the superclass
     * Commercial
     * @param scanner -contains a line of text
     *                with all the values of the
     */
    @Override
    public void readData(Scanner scanner) {
        if (scanner != null) {
            //read the Commercial data
            super.readData(scanner);
            // read Van specific data
            loadVolume = scanner.nextDouble();
            //call a method from super that convert "YES" from the data
            //file to true or "NO" to false
            slidingSideDoor = super.convertToBoolean(scanner.next());

        }
    }

    public double getLoadVolume() {
        return loadVolume;
    }

    public boolean isSlidingSideDoor() {
        return slidingSideDoor;
    }

    /**
     * This method is used to print all the details from a
     * Van object. It calls the method from the superclass
     * Commercial to print all the details of a commercial Vehicle.
     * Then the method prints the other data specific only to a Van
     */
    @Override
    public void printDetails(){
        //print a helpful line to indicate that this is a van
        System.out.println("This is a van:");
         //call the method from super
        super.printDetails();
        System.out.println("Load volume: " + loadVolume + " Sliding side Door : " + super.convertToString(slidingSideDoor));
        //after printing a vehicle print an empty line
        System.out.println();
    }

}
