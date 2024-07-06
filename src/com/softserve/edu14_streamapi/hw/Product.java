package com.softserve.edu14_streamapi.hw;

import java.time.LocalDate;


public class Product {

    private String category;
    private LocalDate dateOfManufacture;
    private double price;

    public Product(String category, LocalDate dateOfManufacture, double price) {
        this.category = category;
        this.dateOfManufacture = dateOfManufacture;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product {" +
                "category - " + category +
                ", dateOfManufacture - " + dateOfManufacture +
                ", price - " + price + '}';
    }

}
