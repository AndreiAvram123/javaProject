package com.company;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class VehicleReservation {

    private String reservationNo;
    private String vehID;
    private String customerID;
    private Date startDate;
    private int noOfDays;

    /**
     * Default constructor for creating
     * a VehicleReservation object to use the method
     * readData()
     */
    public VehicleReservation(){

    }

    public VehicleReservation(String reservationNo, String vehID,
                              String customerID, String startDate, int noOfDays) {

        this.reservationNo = reservationNo;
        this.vehID = vehID;
        this.customerID = customerID;
        //check if startDate is a shortDatePattern
        if (DateUtil.isValidDateString(startDate)) {
            this.startDate = DateUtil.convertStringToDate(startDate);
        } else {
            this.startDate = null;
        }
        this.noOfDays = noOfDays;

    }

    /**
     * This method is used to print all the details
     * of a particular VehicleReservation object
     */
    public void printDetails(){
        String outputLine = String.format("Reservation number: %s , Vehicle ID: %s , Customer id: %s , Start date: %s , Number of days: %s",
                                          reservationNo,vehID,customerID,startDate,noOfDays);
        System.out.println(outputLine);
    }

    /**
     * This method is used to read data for a
     * a VehicleReservation object from a given scanner
     * If the date from the scanner is not valid
     * initialize the startDate with null
     * @param readScanner
     */
    public void readData(Scanner readScanner){
        reservationNo = readScanner.next();
        vehID = readScanner.next();
        customerID = readScanner.next();
        //read the start date as a String from the scanner
        String startDateString = readScanner.next();
        //check if the date is valid
        if(DateUtil.isValidDateString(startDateString)){
            startDate = DateUtil.convertStringToDate(startDateString);
        }else {
            startDate = null;
        }
        noOfDays = readScanner.nextInt();
    }


    /**
     * This method is used to write data into a txt
     * file given a PrintWriter object
     */
    public void writeData(PrintWriter printWriter){
        String outputLine = String.format("%s ,%s , %s , %s , %s",
                reservationNo,vehID,customerID,DateUtil.convertDateToShortString(startDate),noOfDays);
        printWriter.println(outputLine);
    }

    /**
     * This method has been overridden for displaying
     * the details of a VehicleReservation object
     *
     */
     @Override
     public String toString(){
         return String.format("Reservation number: %s , Vehicle ID: %s , Customer id: %s , Start date: %s , Number of days: %s",
                 reservationNo,vehID,customerID,DateUtil.convertDateToShortString(startDate),noOfDays);
     }

    public int getNoOfDays() {
        return noOfDays;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getReservationNo() {
        return reservationNo;
    }

    public String getVehID() {
        return vehID;
    }

    public String getCustomerID() {
        return customerID;
    }
}


