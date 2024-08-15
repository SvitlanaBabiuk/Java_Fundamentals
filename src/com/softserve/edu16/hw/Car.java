package com.softserve.edu16.hw;

import java.util.Scanner;

public class Car {
    public static Scanner scanner = new Scanner(System.in);
    private String type;
    private int yearOfProd;
    private int endineCapacity;

    private Car() {

    }

    public Car(String type, int yearOfProd, int endineCapacity) {
        this.type = type;
        this.yearOfProd = yearOfProd;
        this.endineCapacity = endineCapacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYearOfProd() {
        return yearOfProd;
    }

    public void setYearOfProd(int yearOfProd) {
        this.yearOfProd = yearOfProd;
    }

    public int getEndineCapacity() {
        return endineCapacity;
    }

    public void setEndineCapacity(int endineCapacity) {
        this.endineCapacity = endineCapacity;
    }
}