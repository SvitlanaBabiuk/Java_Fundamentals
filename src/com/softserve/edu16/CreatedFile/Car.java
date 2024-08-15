package com.softserve.edu16.hw;

import java.util.Scanner;

public class Car {
    private static Scanner scanner = new Scanner(System.in);
    private String type;
    private int yearOfProd;
    private int endineCapacity;

    private Car() {

    }

    private Car(String type, int yearOfProd, int endineCapacity) {
        this.type = type;
        this.yearOfProd = yearOfProd;
        this.endineCapacity = endineCapacity;
    }

    private String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    private int getYearOfProd() {
        return yearOfProd;
    }

    private void setYearOfProd(int yearOfProd) {
        this.yearOfProd = yearOfProd;
    }

    private int getEndineCapacity() {
        return endineCapacity;
    }

    private void setEndineCapacity(int endineCapacity) {
        this.endineCapacity = endineCapacity;
    }
}
