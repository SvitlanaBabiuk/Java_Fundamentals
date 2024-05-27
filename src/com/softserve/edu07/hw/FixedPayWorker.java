package com.softserve.edu07.hw;

public class FixedPayWorker extends SalariedEmployee{
    private double salary;


    public FixedPayWorker(double salary, String... args){
        super(args[0], args[1], args[2]);
        this.salary = salary;
    }

    // Add getter and setter

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double calculatePay() {
        return salary;
    }
}
