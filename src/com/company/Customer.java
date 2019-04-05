package com.company;

import java.io.PrintWriter;
import java.util.Scanner;

public class Customer {
    private String customerID;
    private String surname;
    private String firstName;
    private String otherInitials;
    private String title;

    //constructor used to read data
    public Customer() {

    }


    public Customer(String surname, String firstName, String otherInitials, String title) {
        this.customerID = "unknown";
        this.surname = surname;
        this.firstName = firstName;
        this.otherInitials = otherInitials;
        this.title = title;

    }

    /**
     * This method is used to read data
     * for the fields from a scanner object
     *
     * @param scanner
     */
    public void readData(Scanner scanner) {
        if (scanner != null) {
            customerID = scanner.next();
            surname = scanner.next();
            firstName = scanner.next();
            otherInitials = scanner.next();
            title = scanner.next();
            scanner.close();
        }
    }

    /**
     * This method is used to print
     * the details for each Customer
     */
    public void printDetails() {
        System.out.println(String.format("Customer ID : %s" +
                "\n%s  %s %s \n", customerID, title, firstName, surname, otherInitials));
        //check if there are no other initials
        if (otherInitials.trim().isEmpty()) {
            System.out.println("Other initials : None");
        }

    }

    /**
     * This method is used in order to
     * print the data for the current
     * customer inside a txt file
     *
     * @param printWriter
     */
    public void writeData(PrintWriter printWriter) {
        String outputLine = String.format("%s , %s , %s , %s , %s",
                customerID, surname, firstName, otherInitials, title);
        printWriter.println(outputLine);
    }


    public String getCustomerID() {
        return customerID;
    }

    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getOtherInitials() {
        return otherInitials;
    }

    public String getTitle() {
        return title;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
}
