package com.softserve.edu14_streamapi.hw;

import java.time.LocalDate;
import java.util.*;

public class Hw01 {
    public static void main(String[] args) {
        List<Product> products = generateRandomProducts(20);
        List<Product> filteredProducts = products.stream()
                .filter(p -> p.getCategory().equals("Phone"))
                .filter(p -> p.getPrice() > 3000.0)
                .filter(p -> p.getDateOfManufacture().isBefore(LocalDate.now().minusYears(1)))
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .toList();

        filteredProducts.forEach(System.out::println);

    }

    public static List<Product> generateRandomProducts(int numberOfProducts) {
        List<Product> productList = new ArrayList<>();
        String[] categories = {"Phone", "Clothes", "Shoes", "Food", "Books", "Decoration"};
        Random rand = new Random();

        for (int i = 0; i < numberOfProducts; i++) {
            String category = categories[rand.nextInt(categories.length)];

            LocalDate date = LocalDate.now().minusDays(rand.nextInt(730));

            double price = 10 + (5000 - 10) * rand.nextDouble();

            Product product = new Product(category, date, price);
            productList.add(product);
        }
        return productList;
    }

}
