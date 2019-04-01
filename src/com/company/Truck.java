package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Truck extends Commercial {

    private List<String> attributes;

    public Truck(){
        super();
        attributes = new ArrayList<String>();
    }

    @Override
    public void readData(Scanner scanner){
        super.readData(scanner);
        while(scanner.hasNext()){
            attributes.add(scanner.next());
        }

    }

    /**
     * This method is used to print all the
     * details of a Truck object
     * It overrides the method from the superclass
     * Commercial
     */
    @Override
    public void printDetails(){
        super.printDetails();
        for(String attribute: attributes){
            System.out.print(attribute +" , ");
        }
    }

}
