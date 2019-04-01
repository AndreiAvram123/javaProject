package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class is used for testing
 * the application
 */
public class TestClass {
    //call this method to run all tests
    public void executeTests() {
        //check if we are able to create a vehicle
        //with the custom constructor
        //and print out the details
        //  Vehicle vehicle = new Vehicle("A3","Jy-5623","GF08R","Ford");
        // vehicle.printDetails();

        //create a reservation system and attempt to read
        //the data from the file and check if it prints all the lines
        //at this stage
        //ReservationSystem reservationSystem = new ReservationSystem();
        // reservationSystem.readVehicleData();


        //create a reservation system and then read the data from vehicle_data1.txt
        //then call the method printAllVehicles() to see the output
        //if the method works we should see the content of vehicle_data1.txt in the terminal
        //  ReservationSystem reservationSystem = new ReservationSystem();
        //reservationSystem.readVehicleData();
        //reservationSystem.printAllVehicles();

        //test if the method readData from the Vehicle class works
        //create a Vehicle object
        //Vehicle vehicle = new Vehicle();
        //create a Scanner object with data
        //Scanner testScanner = new Scanner("A3,Jy-5623,GF08R,Ford");
        //testScanner.useDelimiter("\\s*,\\s*");
        //vehicle.readData(testScanner);
        //if the method readData() works we should see the output in the terminal
        //vehicle.printDetails();
        //check what happens if we pass null to the readData()
        //vehicle.readData(null);

        //check if the method readData() still works after we have
        //added additional fields
        //  Scanner testScanner = new Scanner("AA, TF-63403, MJ09TFE, Fiat, Panda Active Eco, No,  1.1, Unleaded, five-speed manual, FWD, 13584, 29-07-2009, Hatchback, 5, 5");
        // testScanner.useDelimiter("\\s*,\\s*");
        // Vehicle vehicle = new Vehicle();
        //vehicle.readData(testScanner);
        //check if the method printDetails() still works
        //vehicle.printDetails();


        //check if we are able to read the car data
        //right now ,because of the switch statement I implemented
        //the  other vehicle data except from car data will not be read
        // ReservationSystem reservationSystem = new ReservationSystem();
        //reservationSystem.readVehicleData();
        //check if we the data has been read properly
        //reservationSystem.printAllVehicles();


        //Check if the method readData from the Van class works as expected
        //If the method works fine then we should see the
        //data passed to the scanner
//        Scanner scanner = new Scanner(
//                "C1, GH-68135, TG59DCF, Volkswagen, Caddy 140PS,  No, 2.0, Diesel, five-speed manual, FWD,  2795, 23-11-2009, 724, 3.2, Yes")
//        scanner.useDelimiter("\\s*,\\s*");
//        Van van = new Van();
//        van.readData(scanner);
//        van.printDetails();
//


        //check if we are able now to read van data
        //ReservationSystem reservationSystem = new ReservationSystem();
        //reservationSystem.readVehicleData();
        //if the data has been read successfully then we should be able
        //to see the output with car data along with van data
        //reservationSystem.printAllVehicles();

        //check if we are able to create a customer
        //using the constructor with 4 parameters
        //Customer customer = new Customer("Newton", "David", "E" ,"Dr");
        //customer.printDetails();

        //check if the method readData from the Customer class works
        //by passing a scanner with data
//        Customer customer = new Customer();
//        Scanner scanner = new Scanner("unknown, Newton, David, E, Dr");
//        scanner.useDelimiter("\\s*,\\s*");
//        customer.readData(scanner);
//        customer.printDetails();


        //Check to see what happens if we don't select a file
        //for customer data or we select a file that is not .txt
        //ReservationSystem reservationSystem = new ReservationSystem();
        //reservationSystem.readCustomerData();
        //read the data from the proper txt file and check if we get
        //the expected output
        //reservationSystem.readCustomerData();
        //reservationSystem.printAllCustomers();


        //Check if the method writeData() from the Customer class
        //works
        //if the method works we should see a file name test_file.txt
        //with the data passed to the Customer constructor for
        //each object
////        Customer customer = new Customer("Newton", "David", "E" ,"Dr");
////        Customer customer2 = new Customer("Newton", "David", "E" ,"Dr");
////
//        try {
//            PrintWriter printWriter = new PrintWriter("test_file.txt");
//            customer.writeData(printWriter);
//            customer2.writeData(printWriter);
//            printWriter.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }


        //Check if the method writeCustomerData() works
        //after we read the customers from the data file
//        ReservationSystem reservationSystem = new ReservationSystem();
//        reservationSystem.readCustomerData();
//        reservationSystem.writeCustomerData();


           //Check the method readData() from the Truck class
           // if we are able to read data on a Truck
//           Truck truck = new Truck();
//           Scanner testScanner = new Scanner(
// "T4, JK-64294, GH08YFT, Ford, Transit TD Ci 100 PS , No, 2.4, " +
//         "Diesel, five-speed manual, RWD, 25334, 17-03-2008, 1100, Double cab, Tipper, dual rear wheels");
//           truck.readData(testScanner);
//           truck.printDetails();


        //check if the generateCustomerID() works as expected
//        ReservationSystem reservationSystem = new ReservationSystem();
//        String generatedID = reservationSystem.generateCustomerID("AB",6);
//        //we should now see a generated random number in the terminal
//        System.out.println(generatedID);
//


          //test if everything works after changing the data structures
//           ReservationSystem reservationSystem = new ReservationSystem();
//           //test if we are able to read vehicle data
//           reservationSystem.readVehicleData();
//           reservationSystem.printAllVehicles();
//           //test if we are able to read customer data
//           reservationSystem.readCustomerData();
//           reservationSystem.printAllCustomers();
//

    }
}