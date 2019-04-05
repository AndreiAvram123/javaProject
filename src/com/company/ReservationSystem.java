package com.company;
//TODO
//reafactor the write to file data to avoid file duplication

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.List;

//TODO
//generate a random digit and then check if that unique number is IN THE SYSTEM
public class ReservationSystem {

    // private List<Vehicle> vehicleList;
    // private List<Customer> customerList;
    private Map<String, Vehicle> vehicleMap;
    private Map<String, Customer> customerMap;
    private Map<String, VehicleReservation> vehicleReservationMap;
    private Random randomGenerator;
    private boolean firstCallToGenerateReservationNo;
    private int lastReservationNumber;
    private String lastNumberGeneratedFileName;
    private Diary diary;
    private String dumpCustomerDataFileName;
    private String dumpVehicleReservationDataFileName;

    /**
     * Allow the user to give a name to the
     * reservation system or stick with
     * the default name which is "reservation_system_name_default"
     *
     * @param reservationSystemName
     */
    public ReservationSystem(String reservationSystemName) {
        this();
        dumpCustomerDataFileName = reservationSystemName + "_customer_dump.txt";
        dumpVehicleReservationDataFileName = reservationSystemName + "_reservation_vehicle_dump.txt";


    }

    /**
     * Default constructor
     */
    public ReservationSystem() {
//        vehicleList = new ArrayList<Vehicle>();
//        customerList = new ArrayList<Customer>();
        vehicleMap = new HashMap<String, Vehicle>();
        customerMap = new HashMap<String, Customer>();
        vehicleReservationMap = new HashMap<String, VehicleReservation>();
        randomGenerator = new Random();
        firstCallToGenerateReservationNo = true;
        lastReservationNumber = 0;
        lastNumberGeneratedFileName = "LastNumberGenerated.txt";
        diary = new Diary();
        //read the vehicle_data_2.txt file
        readVehicleData("vehicle_data_2.txt");

        //assign default values to these files, assume that the user will not
        //call the other custom constructor
        dumpCustomerDataFileName = "reservation_system_name_default" + "_customer_dump.txt";
        dumpVehicleReservationDataFileName = "reservation_system_name_default" + "_reservation_vehicle_dump.txt";
        reloadSystem();

    }

    /**
     * This method is used to close down
     * the reservation system and
     * save all important data
     */
    public void closeDownSystem() {
        writeCustomerData(dumpCustomerDataFileName);
        writeVehicleReservationData(dumpVehicleReservationDataFileName);
    }

    /**
     * This method is used to reload the
     * data on the system when restarted
     */
    public void reloadSystem(){
         //check if we have the dumpCustomerDataFileName
        if(isFilePathValid(dumpCustomerDataFileName)) {
           readCustomerData(dumpCustomerDataFileName);
       }
        //check if we have the dumpVehicleReservationDataFileName
       if(isFilePathValid(dumpVehicleReservationDataFileName)) {
           readVehicleReservationData(dumpVehicleReservationDataFileName);
       }
    }




    /**
     * This method is used to store a vehicle
     * reservation
     */
    public void storeVehicleReservation(VehicleReservation vehicleReservation) {
        vehicleReservationMap.put(vehicleReservation.getReservationNo(), vehicleReservation);
        diary.addReservation(vehicleReservation);
    }

    /**
     * This method is used to delete a VehicleReservation
     * object from the ReservationSystem
     */
    public void deleteVehicleReservation(String reservationNumber) {
        //check if the actual reservation exists in the system
        if (vehicleReservationMap.get(reservationNumber) != null) {
            //delete the reservation from the diary
            diary.deleteReservation(vehicleReservationMap.get(reservationNumber));
            vehicleReservationMap.remove(reservationNumber);
        } else {
            System.out.println("Reservation does not exist");
        }
    }


    /**
     * This method will enable a user
     * of the system to display diary entries for
     * a specific period
     *
     * @param startDate
     * @param endDate
     */
    public void printDiaryEntries(String startDate, String endDate) {
        //check if the start date and the end date are valid
        //TODO
        // I assume that startDate and endDate are short format?
        if (DateUtil.isValidDateString(startDate)) {
            if (DateUtil.isValidDateString(endDate)) {
                //convert the Strings to Date objects
                Date start = DateUtil.convertStringToDate(startDate);
                Date end = DateUtil.convertStringToDate(endDate);
                diary.printEntries(start, end);

            } else {
                System.out.println("Invalid end date.Enter a date of the following pattern 25-03-2016");
            }
        } else {
            System.out.println("Invalid start date.Enter a date of the following pattern 25-03-2016");
        }


    }


    //TODO
    //write this method
    //this method should be private

    /**
     * This method is used to generate a unique reservation
     * number
     * <p>
     * This method was public for testing purposes
     *
     * @return
     */
    private String generateReservationNo() {
        //increment the lastReservationNumber by one
        String generatedNumber = "0";
        lastReservationNumber++;
        writeReservationNumberToFile();
        return generatedNumber;
    }

    /**
     * This method is used to get
     * a VehicleReservation object from the
     * vehicleReservationMap given an unique reservationID
     *
     * @param reservationID
     * @return
     */
    private VehicleReservation getVehicleReservation(String reservationID) {
        return vehicleReservationMap.get(reservationID);
    }

    /**
     * This method is used to print all the vehicle reservations
     * stored into the reservation system
     */
    public void printAllVehicleReservations() {
        for (VehicleReservation vehicleReservation : vehicleReservationMap.values()) {
            vehicleReservation.printDetails();
        }
    }


    /**
     * This method is used to write the last reservation number
     * to the a file name stored in the field
     *
     * @field lastNumberGeneratedFilename
     * <p>
     * The method was public only for testing purposes
     */
    private void writeReservationNumberToFile() {
        try {
            PrintWriter printWriter = new PrintWriter(lastNumberGeneratedFileName);
            printWriter.println(lastReservationNumber);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method is used to create a VehicleReservation using
     * the following parameters
     *
     * @param customerID
     * @param vehID
     * @param startDate
     * @param noOfDays
     * @return
     */
    public boolean makeVehicleReservation(String customerID, String vehID,
                                          String startDate, int noOfDays) {
        String reservationNo = generateReservationNo() + "";
        if (vehicleMap.get(vehID) == null) {
            //this means that there isn't a vehicle with a corresponding id available
            System.out.println("There is not a vehicle with the corresponding id available");
            return false;
        }
        if (customerMap.get(customerID) == null) {
            //this means that the customer with that id does not exist
            System.out.println("There is not a customer with the corresponding id available");
            return false;
        }
        //check if the startDate is of correct format
        if (DateUtil.isValidDateString(startDate)) {
            Date start = DateUtil.convertStringToDate(startDate);
            //loop through all days, starting from the first day
            //and check if there is a reservation for that specific vehicle

            //the loop will check first for the first day
            //At the end of the loop we increment the start Date object
            //by one day
            for (int index = 1; index <= noOfDays; index++) {
                VehicleReservation[] vehicleReservations = diary.getReservations(start);
                //loop through all the reservations
                for (VehicleReservation vehicleReservation : vehicleReservations) {
                    //check if there is a reservation for that specific vehID
                    if (vehicleReservation.getVehID().equals(vehID)) ;
                    //exit method if there is already a reservation
                    return false;
                }
                //increment the start Date object by one day
                DateUtil.nextDate(start);
                VehicleReservation vehicleReservation = new VehicleReservation(reservationNo, vehID, customerID, startDate, noOfDays);
                storeVehicleReservation(vehicleReservation);
                System.out.println("We have successfully booked your reservation");
                return true;
            }
            //we exit the loop,this means that there is no reservation for that vehicle
        } else {
            System.out.println("The date is not of correct format.Enter a date such as 25-03-2016");
        }

        return false;
    }


    /**
     * This method is used in order
     * to print all the details
     * about the vehicles stored in
     * the vehicle list
     */
    public void printAllVehicles() {
//        for (Vehicle vehicle : vehicleList) {
//            vehicle.printDetails();
//        }

        for (Vehicle vehicle : vehicleMap.values()) {
            vehicle.printDetails();
        }

    }

    /**
     * This method is used to
     * print the details of all customers
     */
    public void printAllCustomers() {
//        for(Customer customer : customerList){
//            customer.printDetails();
//        }

        for (Customer customer : customerMap.values()) {
            customer.printDetails();
        }

    }


    //TODO
    //reservation data file???

    /**
     * This method is used to read vehicle reservation from
     * a given txt file
     *
     * @param fileName
     */
    public void readVehicleReservationData(String fileName) {
        Scanner read = getScannerFromFilePath(fileName);
        if (read != null) {
            while (read.hasNextLine()) {
                //the method nextLine() jumps to the next line after reading as well
                String readLine = read.nextLine().trim();
                if (!readLine.isBlank()) {
                    if (!readLine.startsWith("//")) {
                        Scanner scanner = new Scanner(readLine);
                        scanner.useDelimiter("\\s*,\\s*");
                        VehicleReservation vehicleReservation = new VehicleReservation();
                        vehicleReservation.readData(scanner);
                        scanner.close();
                    }
                }

            }
        }
    }

    /**
     * This method is used to read vehicle reservation
     * from a txt file that the user is asked to choose
     * from a file dialog
     */
    public void readVehicleReservationData() {
        String filePath = getFilePathFromDialog();
        //no need to check if the filePath is null here
        readVehicleReservationData(filePath);
    }

    public void writeVehicleReservationData(String fileName) {
        if (isFilePathValid(fileName)) {
            PrintWriter printWriter = null;
            try {
                //printWriter = new PrintWriter("vehicle_data.txt");
                printWriter = new PrintWriter(fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //check if the printWriter is null
            if (printWriter != null) {
                for (VehicleReservation vehicleReservation : vehicleReservationMap.values()) {
                    vehicleReservation.writeData(printWriter);
                }
                //close the scanner after use
                printWriter.close();
            }
        }
    }

    /**
     * This method is used to write the all the
     * data regarding vehicle reservation to a txt file
     */
    public void writeVehicleReservationData() {
        //after refactoring
        String filePath = getFilePathForSave();
        writeCustomerData(filePath);

//         if(isFilePathValid(filePath)) {
//             PrintWriter printWriter = null;
//             try {
//                 //printWriter = new PrintWriter("vehicle_data.txt");
//                   printWriter = new PrintWriter(filePath);
//             } catch (FileNotFoundException e) {
//                 e.printStackTrace();
//             }
//             //check if the printWriter is null
//             if (printWriter != null) {
//                 for (VehicleReservation vehicleReservation : vehicleReservationMap.values()) {
//                     vehicleReservation.writeData(printWriter);
//                 }
//                 //close the scanner after use
//                 printWriter.close();
//             }
//         }
    }


    /**
     * This method is used to avoid code duplication
     * It takes a String as a filePath for the parameter
     * and creates a Scanner object if there is a file in that
     * specified filePath
     *
     * @return -null if there is not a file in the system with
     * the corresponding path
     */
    private Scanner getScannerFromFilePath(String filePath) {
        Scanner readScanner = null;
        if (isFilePathValid(filePath)) {
            File file = new File(filePath);
            try {
                readScanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                 e.printStackTrace();
            }
        }
        return readScanner;
    }

    public void readCustomerData(String fileName) {

        Scanner read = getScannerFromFilePath(fileName);
        //the scanner remains null if the file does not exist
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
            read.close();
        }
    }


    /**
     * This method is used to read
     * all data on customers
     */
    public void readCustomerData() {
        String filePath = getFilePathFromDialog();
        //no need to check if the filePath is null here
        readCustomerData(filePath);
    }


    public void writeCustomerData(String fileName) {
        //create a PrintWriter object
        PrintWriter printWriter = null;
        //get the filePath and check if it is valid or not
        if (isFilePathValid(fileName)) {
            try {
                printWriter = new PrintWriter(fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //check if the PrintWriter object  is null
            if (printWriter != null) {
                //loop through the CustomerList
//            for (Customer customer : customerList) {
//                customer.writeData(printWriter);
//            }
                //loop through the customer map
                for (Map.Entry<String, Customer> entry : customerMap.entrySet()) {
                    entry.getValue().writeData(printWriter);
                }

                printWriter.close();
            }
        }
    }

    /**
     * This method is used to print all
     * customer data to a txt file
     */
    public void writeCustomerData() {
        //after refactoring
        String filePath = getFilePathForSave();
        writeCustomerData(filePath);


        //create a PrintWriter object
        // PrintWriter printWriter = null;
        //get the filePath and check if it is valid or not
//        if(isFilePathValid(getFilePathForSave())) {
//            try {
//                printWriter = new PrintWriter(getFilePathForSave());
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//            //check if the PrintWriter object  is null
//            if (printWriter != null) {
//              //loop through the CustomerList
//            for (Customer customer : customerList) {
//                customer.writeData(printWriter);
//            }
//                //loop through the customer map
//                for (Map.Entry<String, Customer> entry : customerMap.entrySet()) {
//                    entry.getValue().writeData(printWriter);
//                }
//
//                printWriter.close();
//            }
//        }
    }

    /**
     * This method is used
     * to select a specific location
     * where the user wants to save the data file
     *
     * @return
     */
    private String getFilePathForSave() {
        Frame frame = null;
        FileDialog saveFileDialog = new FileDialog(frame, "Save", FileDialog.SAVE);
        saveFileDialog.setDirectory("C:\\Users\\andrei\\Desktop\\java project");
        saveFileDialog.setVisible(true);
        String filePath = saveFileDialog.getFile();
        //check if the user has entered the type of the file at the end(.txt)
        if (!filePath.contains(".txt")) {
            filePath += ".txt";
        }

        return filePath;
    }

    /**
     * This method is used
     * to store a customer
     */
    //the method is made private after testing
    private void storeCustomer(Customer customer) {
        String customerID = customer.getCustomerID();
        if (customerID.equals("unknown")) {
            customerID = generateCustomerID("AB-", 6);
            while (!isGeneratedIDUnique(customerID)) {
                customerID = generateCustomerID("AB-", 6);
            }
            customer.setCustomerID(customerID);

        }

        customerMap.put(customerID, customer);

    }

    private boolean isGeneratedIDUnique(String generatedID) {
        // int index = 0;
//        while (index < customerList.size()) {
//            if (customerList.get(index).getCustomerID().equals(generatedID))
//                return false;
//            index++;
//        }
        for (Customer customer : customerMap.values()) {
            if (customer.getCustomerID().equals(generatedID))
                return false;
        }

        return true;
    }

    /**
     * This method is used
     * to generate a random Customer ID
     * based on a given prefix and a number of digits
     */
    //the method is made private after testing
    private String generateCustomerID(String prefix, int numberOfDigits) {
        //append the prefix to the id
        String generatedID = prefix + "-";
        for (int index = 1; index < numberOfDigits; index++) {
            //generate a random digit at a time
            int generatedDigit = randomGenerator.nextInt(10);
            generatedID += generatedDigit;
        }
        return generatedID;
    }


    /**
     * This method is used to check weather
     * there is a txt file with that specific path
     * exists in memory
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
        //check for the existence of the file
        File file = new File(filePath);
        if(!file.exists() || file.isDirectory())
        {
            return false;
        }
        return true;

    }


    /**
     * This method is used to read Vehicle
     * data from a given txt file
     *
     * @param fileName
     */
    public void readVehicleData(String fileName) {
        Scanner scanner = getScannerFromFilePath(fileName);
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
                            //after entering the switch statement the
                            //vehicle should never be null, but we will
                            //still check
                            if (vehicle != null) {
                                vehicle.readData(secondScanner);
                                // vehicleMap.add(vehicle);
                                storeVehicle(vehicle);
                            }

                        } else {
                                    /*
                                      If the line is a flag set the data type accordingly
                                      I have made the dataType lowercase
                                      in order to get rid of checking
                                      if the dataType is [Car Data],[Van data] or [Truck data]
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


    /**
     * This method is used to
     * read Vehicle Data from a txt
     * file chosen by the user
     */
    public void readVehicleData() {
        //get the absolute path from the dialog
        String filePath = getFilePathFromDialog();
        // !! There is no need to check here if the filePath is null
        //this check is accomplished in the other readVehicleData() method
        readVehicleData(filePath);
    }

    /**
     * This method is used to store a vehicle
     * inside the vehicleMap
     * This is also a helpful method for testing
     * purposes
     * The method was public for testing and then
     * modified to private
     *
     * @param vehicle
     */
    private void storeVehicle(Vehicle vehicle) {
        vehicleMap.put(vehicle.getVehID(), vehicle);
    }

    private String getFilePathFromDialog() {
        Frame frame = null;
        FileDialog fileDialog = new FileDialog(frame, "Open", FileDialog.LOAD);
        //use the method setDirectory redirect the user
        //to a specific directory
        fileDialog.setDirectory("C:\\Users\\andrei\\Desktop\\java project");
        fileDialog.setVisible(true);
        return fileDialog.getFile();
    }

    /**
     * This method is used to
     * get a Customer object from the
     * customerMap by passing a customerID
     */
    public Customer getCustomer(String customerID) {
        return customerMap.get(customerID);
    }

    /**
     * This method is used to
     * get a Vehicle object from the
     * vehicleMap by passing a vehicleID
     */
    public Vehicle getVehicle(String vehicleID) {
        return vehicleMap.get(vehicleID);
    }

    /**
     * This method is used to get the
     * total number of vehicles stored in the
     * system
     */
    public int getNumberOfVehicles(){
        return vehicleMap.size();
    }

    /**
     * This method is used to get the
     * total number of customers stored
     * in the system
     */
    public int getNumberOfCustomers(){
        return customerMap.size();
    }


    /**
     * Method only used for testing purposes
     *
     */
//    public String getDumpCustomerDataFileName(){
  //      return  dumpCustomerDataFileName;
   // }

    /**
     * Method only used for testing purposes
     * @return
     */
   // public String getDumpVehicleReservationDataFileName(){
     //   return  dumpVehicleReservationDataFileName;
    //}

}
