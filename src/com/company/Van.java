package com.company;

public class Van extends Commercial {
    private int loadVolume;
    private boolean slidingSideDoor;

    public Van(){
        super();
    }
    public int getLoadVolume() {
        return loadVolume;
    }

    public boolean isSlidingSideDoor() {
        return slidingSideDoor;
    }
}
