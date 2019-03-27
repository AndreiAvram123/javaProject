package com.company;

import java.util.Scanner;

public abstract class Commercial extends Vehicle {
    protected int payload;

    public Commercial(){

    }

    public int getPayload(){
        return payload;
    }

    @Override
    public void readData(Scanner scanner){
        super.readData(scanner);
    }

}
