package com.company;

import java.util.Scanner;

public class Van extends Commercial {
    private int loadVolume;
    private boolean slidingSideDoor;

    public Van() {
        super();
    }

    @Override
    public void readData(Scanner scanner) {
        if (scanner != null) {
            super.readData(scanner);
            loadVolume = scanner.nextInt();
            slidingSideDoor = scanner.nextBoolean();
        }
    }

    public int getLoadVolume() {
        return loadVolume;
    }

    public boolean isSlidingSideDoor() {
        return slidingSideDoor;
    }
}
