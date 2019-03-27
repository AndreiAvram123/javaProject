package com.company;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.List;

public class ReservationSystem {

     private List<Vehicle> vehicleList;
      private List<Customer> customerList;
    private Map<String,Vehicle> vehicleMap;
    private Map<String,Customer> customerMap;
    private Random randomGenerator;

    /**
     * Default constructor
     * Used to initialize the vehicleMap
     */
    public ReservationSystem() {
        vehicleList = new ArrayList<Vehicle>();
        customerList = new ArrayList<Customer>();
        vehicleMap = new HashMap<String,Vehicle>();
        customerMap = new HashMap<String,Customer>();
        randomGenerator = new Random();
    }

    /**
     * This method is used in order
     * to print all the details
     * about the vehicles stored in
     * the vehicle list
     */
    public void printAllVehicles() {
//        for (Vehicle vehicle : vehicleMap) {
//            vehicle.printDetails();
//        }

        for(Vehicle vehicle : vehicleMap.values()){
              vehicle.printDetails();
          }

    }

    /**
     * This method is used to
     * print the details of all customers
     */
    public void printAllCusomers() {
        for(Customer customer : customerMap.values()){
            customer.printDetails();
        }

        for(Customer customer : customerMap.values()){
            customer.printDetails();
        }

    }

    /**
     * This method is used to read
     * all data on customers
     */
    public void readCustomerData() {
        String filePath = getFilePathFromDialog();
        if (isFilePathValid(filePath)) {
            File file = new File(filePath);
            Scanner read = null;
            try {
                read = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (read != null) {
                while (read.hasNextLine()) {
                    String readLine = read.nextLine().trim();
                    if (!readLine.isBlank()) {
                        if (!readLine.startsWith("//")) {
                            Scanner scanner = new Scanner(readLine);
                            scanner.useDelimiter("\\s*,\\s*");
                            Customer customer = new Customer();
                            customer.readData(scanner);
                            storeCustomer(customer);
                        }
                    }
                }
            }
        }
    }


    /**
     * This method is used to print all
     * customer data to a txt file
     */
    public void writeCustomerData() {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter("saved_customer_data.txt");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (printWriter != null) {

//            for (Customer customer : customerMap) {
//                customer.writeData(printWriter);
//            }

               for(Map.Entry<String,Customer> entry : customerMap.entrySet()){
                     entry.getValue().writeData(printWriter);
               }

            printWriter.close();
        }

    }

    /**
     * This method is used
     * to store a customer
     */
    public void storeCustomer(Customer customer) {
        String customerID = customer.getCustomerID();
        if(customerID.equals("unknown")){
             String generatedID = generateCustomerID("AB-",6);
             while(!isGeneratedIDUnique(generatedID)){
                 generatedID = generateCustomerID("AB-",6);
             }
            customer.setCustomerID(generatedID);

        }

        customerMap.put(customerID,customer);

    }

    private boolean isGeneratedIDUnique(String generatedID) {
        int index =0;
        while(index < customerMap.size()){
            if(customerMap.get(index).getCustomerID().equals(generatedID))
                return false;
            index++;
        }
        return true;
    }

    /**
     * This method is used
     * to generate a random Customer ID
     * based on a given prefix and a number of digits
     */
    public String generateCustomerID(String prefix,int numberOfDigits){
        //append the prefix to the id
        String generatedID= prefix + "-";
        for(int index=1;index<numberOfDigits;index++){
            //generate a random digit at a time
           int generatedDigit = randomGenerator.nextInt(10);
           generatedID+= generatedDigit;
        }
        return generatedID;
    }




    /**
     * This method is used to check weather
     * a correct file has been selected
     * in the file dialog
     */
    private boolean isFilePathValid(String filePath) {
        if (filePath == null) {
            System.out.println("Please select a file!!");
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
                                          break;
                                    case "[van data]":
                                        vehicle = new Van();
                                        break;
                                    case "[truck data]":
                                        vehicle = new Truck();
                                        break;

                                }
                                vehicle.readData(secondScanner);
                               // vehicleMap.add(vehicle);
                                vehicleMap.put(vehicle.getVehID(),vehicle);




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
        fileDialog.setDirectory("C:\\Users\\andrei\\Desktop\\java project");
        fileDialog.setVisible(true);
        return fileDialog.getFile();
    }

    /**
     * This method is used to
     * get a Customer object from the
     * customerMap by passing a customerID
     */
    public Customer getCustomer(String customerID){
        return customerMap.get(customerID);
    }
    /**
     * This method is used to
     * get a Vehicle object from the
     * vehicleMap by passing a vehicleID
     */
    public Vehicle getVehicle(String vehicleID){
        return vehicleMap.get(vehicleID);
    }

}
