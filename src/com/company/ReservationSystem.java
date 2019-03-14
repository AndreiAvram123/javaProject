package com.company;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReservationSystem {

    private ArrayList<Vehicle> vehicleList;
    private ArrayList<Customer> customerList;

    /**
     * Default constructor
     * Used to initialize the vehicleList
     */
    public ReservationSystem() {
        vehicleList = new ArrayList<Vehicle>();
        customerList = new ArrayList<Customer>();
    }

    /**
     * This method is used in order
     * to print all the details
     * about the vehicles stored in
     * the vehicle list
     */
    public void printAllVehicles() {
        for (Vehicle vehicle : vehicleList) {
            vehicle.printDetails();
        }
    }

    /**
     * This method is used to
     * print the details of all customers
     */
    public void printAllCusomers() {
        for (Customer customer : customerList) {
            customer.printDetails();
        }
    }

    /**
     * This method is used to read
     * all data on customers
     */
    public void readCustomerData() {
        String filePath = getFilePathFromDialog();
         if(isFilePathValid(filePath)) {
             File file = new File(filePath);
             Scanner read = null;
             try {
                 read = new Scanner(file);
             } catch (FileNotFoundException e) {
                 e.printStackTrace();
             }
             while(read.hasNextLine()){
                 String readLine = read.nextLine().trim();
                 Scanner scanner = new Scanner(readLine);
                 scanner.useDelimiter("\\s*,\\s*");
                 Customer customer = new Customer();
                 customer.readData(scanner);
                 storeCustomer(customer);
                 }
             }
         }


    /**
     * This method is used to print all
     * customer data to a txt file
      */
    public void writeCustomerData(){

    }

    /**
     * This method is used
     * to store a customer
     */
    public void storeCustomer(Customer customer) {
        customerList.add(customer);
    }

    /**
     * This method is used to check weather
     * a correct file has been selected
     * in the file dialog
     */
    private boolean isFilePathValid(String filePath) {
        if (filePath == null) {
            System.out.println("Invalid file format");
            return false;
        }
        if (!filePath.contains(".txt")) {
            System.out.println("Please select a txt file");
            return false;

        }
        return true;

    }

    /**
     * This method is used
     * to read vehicle data
     * from a txt file
     * The user is asked to select
     * a file via a fileDialog
     * !!The selected file is checked in
     * the method isFilePathValid()
     */
    public void readVehicleData() {
        String filePath = getFilePathFromDialog();
        if (isFilePathValid(filePath)) {
            File file = new File(filePath);
            Scanner scanner = null;

            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //check if the scanner is null
            if (scanner != null) {
                String dataType = "";
                while (scanner.hasNextLine()) {
                    String outputLine = scanner.nextLine();
                    //check if the line is blank
                    if (!outputLine.isBlank()) {
                        //check if the line is a comment
                        if (!outputLine.startsWith("//")) {       //check if the line is a type of vehicle
                            if (!outputLine.matches("^\\[.+\\]$")) {
                                //       System.out.println(outputLine);
                                Scanner secondScanner = new Scanner(outputLine);

                                secondScanner.useDelimiter("\\s*,\\s*");
                                //check what kind of vehicle we need to read
                                Vehicle vehicle = null;
                                switch (dataType) {
                                    case "[car data]":
                                        vehicle = new Car();
                                        //the readData(scanner of the Car class will be called
                                        vehicle.readData(secondScanner);
                                        vehicleList.add(vehicle);
                                        break;
                                    case "[van data]":
                                        vehicle = new Van();
                                        vehicle.readData(secondScanner);
                                        vehicleList.add(vehicle);
                                        break;
                                }
                            } else {
                                    /*
                                      If the line is a flag set the data type accordingly
                                      I have made the dataType lowercase
                                      in order to get rid of checking
                                      if the dataType is [Car Data],[Car data]..
                                     */
                                dataType = outputLine.toLowerCase();
                            }
                        }
                    }
                }
                //close the scanner after use
                scanner.close();
            }
        }
    }

    private String getFilePathFromDialog() {
        Frame frame = null;
        FileDialog fileDialog = new FileDialog(frame, "Open", FileDialog.LOAD);
        fileDialog.setDirectory("C:/Users/andrei/Desktop/java project");
        fileDialog.setVisible(true);
        return fileDialog.getFile();
    }
}
