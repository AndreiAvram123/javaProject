package com.company;

import java.util.Scanner;


//TODO
//Does it say somewhere that the output should be the same as in the file????
public abstract class Vehicle {

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

    //after implementing the more specific classes
    //such as Car we no longer need this constructor
//    public Vehicle() {
//
//    }

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
            group = scanner.next();
            vehID = scanner.next();
            regNo = scanner.next();
            make = scanner.next();
            model = scanner.next();
            airCon = convertToBoolean(scanner.next());
            engineSize = scanner.nextDouble();
            fuelType = scanner.next();
            gearBox = scanner.next();
            transmission = scanner.next();
            mileage = scanner.nextInt();
            dateFirstRegistered = scanner.next();

        }
    }

    /**
     * This method is used to convert a String "Yes" or "No" from
     * the data file to true or false
     * Because it is declared protected it can also be
     * used by subclasses
     * @param next
     * @return
     */
    protected boolean convertToBoolean(String next) {
        return next.equals("Yes");
    }

    /**
     * This method is used to convert a true or false
     * boolean value to "Yes" or "No"
     * @return
     */
    protected String convertToString(Boolean bool) {
        if (bool) {
            return "Yes";
        } else {
            return "No";
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
                model, group, vehID, convertToString(airCon), engineSize, fuelType, gearBox, transmission, mileage, dateFirstRegistered);
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
