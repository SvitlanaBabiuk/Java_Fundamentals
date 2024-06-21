package com.softserve.edu14;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Product { private String manufacture;
    private String category;
    private LocalDate dateOfManufacture;
    private double price;

    public static void main(String[] args) {
        task1();
    }
    public static void task1() {



    }


    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(LocalDate dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static List<Product> sortProductsByPrice(List<Product> products) {
        LocalDate oneYearAgo = LocalDate.now().minusYears(1);
        return products.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("Phone"))
                .filter(product -> product.getPrice() > 3000)
                .filter(product -> product.getDateOfManufacture().isBefore(oneYearAgo))
                .sorted(Comparator.comparing(Product::getPrice))
                .toList();
    }


}

