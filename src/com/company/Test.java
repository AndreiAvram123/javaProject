package com.company;

import java.util.Scanner;

public class Test {


    public void executeTests(){
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
        //vehicle.readData(testScanner);
        //if the method readData() works we should see the output in the terminal
        //vehicle.printDetails();
        //check what happens if we pass null to the readData()
        //vehicle.readData(null);

        //check if the method readData() still works after we have
        //added additional fields
      //  Scanner testScanner = new Scanner("AA, TF-63403, MJ09TFE, Fiat, Panda Active Eco, No,  1.1, Unleaded, five-speed manual, FWD, 13584, 29-07-2009, Hatchback, 5, 5");
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

       //TODO
        // check if we are able to read the data for the van


        //TODO
        //check if we are able to create a customer


        //TODO
        //check if the method readData() from the customer class works

        //Check to see what happens if we don't select a file
        //for customer data or we select a file that is not .txt
        ReservationSystem reservationSystem = new ReservationSystem();
        reservationSystem.readCustomerData();
        //read the data from the proper txt file and check if we get
        //the expected output
        reservationSystem.readCustomerData();
        reservationSystem.printAllCusomers();



        //TODO
        //check if storeCustomer works

        //TODO
        //check everything


        //TODO
        //take a look at Junit testing


    }
}
