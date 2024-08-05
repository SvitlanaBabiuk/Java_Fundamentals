package com.softserve.academy.edu14.hw;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Product {
    private String name;
    private String category;
    private LocalDate dateOfManufacture;
    private double price;

    public Product(String name, String category, LocalDate dateOfManufacture, double price) {
        this.name = name;
        this.category = category;
        this.dateOfManufacture = dateOfManufacture;
        this.price = price;
    }

    public String getName() {
        return name;
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
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", dateOfManufacture=" + dateOfManufacture +
                ", price=" + price +
                '}';
    }
}
