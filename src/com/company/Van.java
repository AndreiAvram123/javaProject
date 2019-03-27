package com.company;

import java.util.Scanner;

public class Van extends Commercial {
    private double loadVolume;
    private boolean slidingSideDoor;

    public Van() {
        super();
    }

    /**
     * This method is used to read all the data about
     * a Van object by passing a scanner objectc
     * @param scanner -contains a line of text
     *                with all the values of the
     */
    @Override
    public void readData(Scanner scanner) {
        if (scanner != null) {
            super.readData(scanner);
            payload = scanner.nextInt();
            loadVolume = scanner.nextDouble();
            slidingSideDoor = super.convertToBoolean(scanner.next());

        }
    }

    public double getLoadVolume() {
        return loadVolume;
    }

    public boolean isSlidingSideDoor() {
        return slidingSideDoor;
    }

    @Override
    public void printDetails(){
        super.printDetails();
        //TODO
        //more things
    }

}
