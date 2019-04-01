package com.company;

import java.util.Scanner;

public abstract class Commercial extends Vehicle {
    private int payload;


    public int getPayload(){
        return payload;
    }

    /**
     * This method is called from subclasses of this
     * class in order to read data
     * The method is overridden from the superclass
     * Vehicle
     * @param scanner -contains a line of text
     *                with all the values of the
     */
    @Override
    public void readData(Scanner scanner){
        //the the data of a vehicle
        super.readData(scanner);
        //read the payload
        payload = scanner.nextInt();
    }

    /**
     * This method is used to print
     * all the details of a Commercial object
     * It calls the constructor from the Vehicle
     * superclass and then prints the payload
     */
    @Override
    public void printDetails(){
        super.printDetails();
        //print the payload
        System.out.println("Payload: " + payload);

    }

}
