package com.softserve.edu06.pt;

public class Sedan extends Car {

    public Sedan(String model, int maxSpeed, int yearOfProduction) {
        super(model, maxSpeed, yearOfProduction);
    }

    @Override
    public void run() {
        System.out.println(model + " sedan is running.");
    }

    @Override
    public void stop() {
        System.out.println(model + " sedan has stopped.");
    }
}
