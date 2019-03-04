package com.company;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReservationSystem {

    private ArrayList<Vehicle> vehicleList;

    /**
     * Default constructor
     * Used to initialize the vehicleList
     */
    public ReservationSystem() {
        vehicleList = new ArrayList<Vehicle>();
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

    public void readVehicleData() {
        String filePath = getFilePathFromDialog();
        //check if the filePath is null
        if (filePath != null) {
            if (filePath.contains(".txt")) {
                File file = new File(filePath);

                Scanner scanner = null;
                try {
                    scanner = new Scanner(file);
                    while(scanner.hasNextLine()){
                        String outputLine = scanner.nextLine();
                        if( !outputLine.matches("//.+") && !outputLine.isEmpty() &&!outputLine.contains("^\\[.+\\]$")){
                            System.out.println(outputLine);
                            Scanner secondScanner = new Scanner(outputLine);
                            //set a custom deliminter
                            secondScanner.useDelimiter(",");
                            /*
                              After we extract each token from the line of text,
                              we use the trim() function on each token to eliminate
                              white spaces
                             */

                             Vehicle vehicle = new Vehicle();
                             vehicleList.add(vehicle);

                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println("Invalid file format");
            }
        } else {
            System.out.println("Please select a data file");
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
