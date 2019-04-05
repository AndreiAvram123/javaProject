package com.company;

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
//       Customer customer = new Customer("Newton", "David", "E" ,"Dr");
//        Customer customer2 = new Customer("Newton", "David", "E" ,"Dr");
//
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

        //TESTS FOR THE DateUtil class


        //test the method convertDateToLongString
        //create an date object with the current time  to test the methods
        // Date currentDate = new Date(Calendar.getInstance().getTimeInMillis());
        //if the method works we should see in the terminal something like this
        // Wednesday, 3 April 2019
        //System.out.println(DateUtil.convertDateToLongString(currentDate));
        //test the method convertDateToShortString() using the same date object
        //if the method works we should see in the terminal something like this
        //03-04-2019
        // System.out.println(DateUtil.convertDateToShortString(currentDate));
        //check the method convert convertStringToDate()
        //the method needs to be passes a String date dd-mm-yyy such as "25-03-2016"
        // Date testDate = DateUtil.convertStringToDate("25-03-2016");
        // if(testDate!=null){
        //    System.out.println("Method convertStringToData with dd-mm-yyy works");
        //}

        //check what happens when we pass a different String date format
        //if the method works we should get a runtime exception

        //because this is a test we should catch the exception if occurs
//        try {
//            testDate = DateUtil.convertStringToDate("Wednesday, 3 April 2019");
//        }catch(RuntimeException e){
//          System.out.println("Method convertStringToDate has thrown the exception for wrong date format");
//        }

        //check if the method next Date works
        //we still have the currentDate object from above
        //which corresponds to the exact date from today (Wednesday, 3 April 2019)

        //Date nextDate = DateUtil.nextDate(currentDate);
        //because the method convertDateToLongString() works
        //we can use it to
        //the output should be Thursday, 4 April 2019
        //System.out.println(DateUtil.convertDateToLongString(nextDate));

        //test the method daysBetween() of the DateUtil class works
        //the current difference between the currentDate object
        //and the nextDate object is one day
        //if the method works we should see 1 in the terminal
        //System.out.println(DateUtil.daysBetween(currentDate,nextDate));

        //test if the method isValidDateString() works
        //for a short String date
        //the output to the terminal should be true
        //System.out.println(DateUtil.isValidDateString("25-03-2016"));
        //check if the method works for a long String date
        //the output should be false
        //System.out.println(DateUtil.isValidDateString("Wednesday, 3 April 2019"));


        //test if we can create a VehicleReservation object
        //  VehicleReservation vehicleReservation = new VehicleReservation("000001","TF-63403","AB-707381"
        //,"25-03-2016",2);

        //test what happens when we create a VehicleReservation object with a long String date
//        VehicleReservation vehicleReservation = new VehicleReservation("000001","TF-63403","AB-707381"
//                ,"Wednesday, 3 April 2019",2);


        //create a vehicleReservation object and test the method printDetails()
        //VehicleReservation vehicleReservation = new VehicleReservation("000001","TF-63403","AB-707381"
        //        ,"25-03-2016",2);
        //vehicleReservation.printDetails();


        //Check if the method readData() from the VehicleReservation class works
        //VehicleReservation  vehicleReservation = new VehicleReservation();
        //create a test Scanner object with data
        //Scanner testScanner = new Scanner("000001,TF-63403,AB-707381,25-03-2016,2");
        //vehicleReservation.readData(testScanner);
        //call the printDetails() method to check if the method readData() worked
        //vehicleReservation.printDetails();

        //create a PrintWriter object and test the method writeData() from the VehicleReservation class
//        try {
//            PrintWriter printWriter = new PrintWriter("test_file.txt");
//             VehicleReservation vehicleReservation = new VehicleReservation("000001","TF-63403","AB-707381"
//                     ,"25-03-2016",2);
//             vehicleReservation.writeData(printWriter);
//             printWriter.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }


        //ReservationSystem reservationSystem = new ReservationSystem();
        //if the method works we should see the number 0 in the file
        //reservationSystem.writeReservationNumberToFile();
        //use the method generateReservationNo() which,at this point,
        // just increments the lastReservationNumber by one
        //reservationSystem.generateReservationNo();
        //if we call now the method writeReservationNumberToFile() our previous 0 should be
        //replaced by 1
        //reservationSystem.writeReservationNumberToFile();

        //TODO
        //test methods from the Diary class


        //test the method makeVehicleReservation() from the ReservationSystem class
        //ReservationSystem reservationSystem = new ReservationSystem();
        //create a Customer object and store it in the ReservationSystem
        //Customer customer = new Customer("Newton", "David", "E", "Dr");
        //reservationSystem.storeCustomer(customer);
        //create a Car object with data
        //Scanner testScanner = new Scanner("AA, TF-63403, MJ09TFE, Fiat, Panda Active Eco, No,  1.1, Unleaded, five-speed manual, FWD, 13584, 29-07-2009, Hatchback, 5, 5");
        //testScanner.useDelimiter("\\s*,\\s*");
       // Car car = new Car();
        //car.readData(testScanner);
        // reservationSystem.storeVehicle(car);
        //if the method works we should see a confirmation message in the terminal
       // reservationSystem.makeVehicleReservation(customer.getCustomerID(),car.getVehID(),"04-04-2019", 3);




        //test the method printDiaryEntries() from the ReservationSystem class
        // ReservationSystem reservationSystem = new ReservationSystem();
        //create a VehicleReservation object
        //VehicleReservation vehicleReservation = new VehicleReservation("000001","TF-63403","AB-707381"
        //        ,"04-04-2019",2);
        //store the vehicleReservation object inside the reservationSystem
        //reservationSystem.storeVehicleReservation(vehicleReservation);
        //now test the method printDiaryEntries() with the following dates
        // reservationSystem.printDiaryEntries("04-04-2019","05-04-2019");
        //because we have one reservation in our system for one vehicle,the
        //method should display that reservation in the terminal


        //test the method deleteVehicleReservation() from the ReservationSystem
        // ReservationSystem reservationSystem = new ReservationSystem();
        //create a VehicleReservation object
        //VehicleReservation vehicleReservation = new VehicleReservation("000001","TF-63403","AB-707381"
        //       ,"04-04-2019",2);
        //store the vehicleReservation object inside the reservationSystem(the method has been tested
        //and works)
        // reservationSystem.storeVehicleReservation(vehicleReservation);
        //call the method deleteVehicleReservation()
        // reservationSystem.deleteVehicleReservation(vehicleReservation.getReservationNo());
        //now, if we call the method printDiaryEntries("04-04-2019","05-04-2019"), there should be no reservations
        //in the terminal
        // reservationSystem.printDiaryEntries("04-04-2019","05-04-2019");


        //test the method make makeVehicleReservation()
        //ReservationSystem reservationSystem = new ReservationSystem();
        //we need to create both an Object of type Vehicle and one of type Customer
        //in order to check the method makeVehicleReservation() properly
        //create a Customer object

         //Customer customer = new Customer("Newton", "David", "E", "Dr");
         //reservationSystem.storeCustomer(customer);

        //create a Car object with data
        //Scanner testScanner = new Scanner("AA, TF-63403, MJ09TFE, Fiat, Panda Active Eco, No,  1.1, Unleaded, five-speed manual, FWD, 13584, 29-07-2009, Hatchback, 5, 5");
        //testScanner.useDelimiter("\\s*,\\s*");
        //Car car = new Car();
        //car.readData(testScanner);
        //reservationSystem.storeVehicle(car);
        //create a customer object and store it inside the customerMap
        //create a VehicleReservation object
        //VehicleReservation vehicleReservation = new VehicleReservation("000001","TF-63403","AB-707381"
          //     ,"04-04-2019",2);
         // store the vehicleReservation object inside the reservationSystem(the method has been tested
         //and works)
        //the reservation has been made from 04-04-2019 to 06-04-2019
        //reservationSystem.storeVehicleReservation(vehicleReservation);

        //now try to make a reservation for our car object from 05-04-2019 to 07-04-2019
        //if the method works it should return false,meaning that we cannot reserve that during
        //that time
        //reservationSystem.makeVehicleReservation(car.getVehID(),customer.getCustomerID(),"05-04-2019",2);

        //now test the method for a valid date
        //reservationSystem.makeVehicleReservation(car.getVehID(),customer.getCustomerID(),"09-04-2019",2);


        //test if the method readVehicleData() still works after refactoring
        //works as well
        //ReservationSystem reservationSystem = new ReservationSystem();
        //reservationSystem.readVehicleData();
        //reservationSystem.printAllVehicles();


        //test if the  method readVehicleData(String fileName) works
//        ReservationSystem reservationSystem = new ReservationSystem();
//        reservationSystem.readVehicleData("vehicle_data_2.txt");
//        reservationSystem.printAllVehicles();


        //test if the method readCustomerData() works after refactoring
//        ReservationSystem reservationSystem = new ReservationSystem();
//        reservationSystem.readCustomerData();
//        reservationSystem.printAllCustomers();


         //test if the method readCustomerData(String fileName) works
//        ReservationSystem reservationSystem = new ReservationSystem();
//        reservationSystem.readCustomerData("customer_data.txt");
//        reservationSystem.printAllCustomers();

         //test if the method readCustomerData(String fileName) works for a wrong
        //data file (it should not read that file)

//          ReservationSystem reservationSystem = new ReservationSystem();
//          reservationSystem.readCustomerData("customer_data");
//          reservationSystem.printAllCustomers();



        //test if the method writeCustomerData() works after refactoring
        //ReservationSystem reservationSystem = new ReservationSystem();
       // reservationSystem.readCustomerData();



        //test if the method writeVehicleReservationData() and readVehicleReservationData work as well
        //TODO
        //where do we read that data from ???


         //test if the default constructor from the ReservationSystem class reads
         //the vehicle data
         //it should read the data from the vehicle_data_2.txt file
         //ReservationSystem reservationSystem = new ReservationSystem();
         //reservationSystem.printAllVehicles();

          //test the new constructor from the ReservationSystem class,
          //the one that takes the name of the reservation System
          // ReservationSystem reservationSystem = new ReservationSystem("my_reservation_system");
           //System.out.println(reservationSystem.getDumpCustomerDataFileName());
           //System.out.println(reservationSystem.getDumpVehicleReservationDataFileName());


          //test the method closeDownSystem() too see if it creates the appropriate
         //data dump txt files in the project folder
        // ReservationSystem reservationSystem = new ReservationSystem("my_reservation_system");
         //read the data on customers
        //  reservationSystem.readCustomerData("customer_data.txt");
          //add VehicleReservation data to the system
         // VehicleReservation vehicleReservation = new VehicleReservation("000001","TF-63403","AB-707381"
            //  ,"04-04-2019",2);
          //reservationSystem.storeVehicleReservation(vehicleReservation);
          //close down the system
         //reservationSystem.closeDownSystem();
         //we should now see two txt files inside the project folder containing our data



        //test the method reloadSystem() after we close down the system
        // ReservationSystem reservationSystem = new ReservationSystem("my_reservation_system");
         //read the data on customers
         // reservationSystem.readCustomerData("customer_data.txt");
         //add VehicleReservation data to the system
         //VehicleReservation vehicleReservation = new VehicleReservation("000001","TF-63403","AB-707381"
         // ,"04-04-2019",2);
        //reservationSystem.storeVehicleReservation(vehicleReservation);
        //close down the system
        //reservationSystem.closeDownSystem();
        //reservationSystem.reloadSystem();
        //if the method works we should see the data before closing down the system
        //in the terminal
        //reservationSystem.printAllCustomers();
        //reservationSystem.printAllVehicleReservations();


        //test the method getNumberOfVehicles()
        //ReservationSystem reservationSystem = new ReservationSystem("my_reservation_system");
        //reservationSystem.readVehicleData("vehicle_data_2.txt");
        //if the method works we should see the number of vehicles from
        //the txt file printed in the terminal
        //System.out.println(reservationSystem.getNumberOfVehicles());

         //test the method getNumberOfCustomers()
         //ReservationSystem reservationSystem = new ReservationSystem("my_reservation_system");
         //reservationSystem.readCustomerData("customer_data.txt");
         //System.out.println(reservationSystem.getNumberOfCustomers());

    }
}