package com.company;

import java.util.Scanner;

public class Vehicle {

    private String group;
    private String vehID;
    private String regNo;
    private String make;
    private String model;
    private boolean airCon;
    private double engineSize;
    private String fuelType;
    private String gearBox;
    private String transmission;
    private int mileage;
    private String dateFirstRegistered;

    public Vehicle() {

    }

    /**
     * This method is used in order
     * to initialize the object's fields
     *
     * @param scanner -contains a line of text
     *                with all the values of the
     *                fields
     */
    public void readData(Scanner scanner) {
        if (scanner != null) {
            group = scanner.next().trim();
            vehID = scanner.next().trim();
            regNo = scanner.next().trim();
            make = scanner.next().trim();
            model = scanner.next().trim();
            airCon = scanner.nextBoolean();
            engineSize = scanner.nextDouble();
            fuelType = scanner.next().trim();
            gearBox = scanner.next().trim();
            transmission = scanner.next().trim();
            mileage = scanner.nextInt();
            dateFirstRegistered = scanner.next().trim();
            }
        }



    /**
     * This method is used to print
     * all the details of one particular
     * vehicle
     */
    public void printDetails() {
     String outputLine = String.format("%s  Group: %s  Vehicle Id: %s \nAir conditioning/Climate Control: %s \nEngine Size: %s  " +
             "Fuel: %s \nGearbox: %s Transmission: %s \nMileage: %s  Date first registered: %s",
             model,group,vehID,airCon,engineSize,fuelType,gearBox,transmission,mileage,dateFirstRegistered);
      System.out.println(outputLine);
    }

    public String getGroup() {
        return group;
    }

    public String getVehID() {
        return vehID;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public boolean isAirCon() {
        return airCon;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getGearBox() {
        return gearBox;
    }

    public String getTransmission() {
        return transmission;
    }

    public int getMileage() {
        return mileage;
    }

    public String getDateFirstRegistered() {
        return dateFirstRegistered;
    }
}