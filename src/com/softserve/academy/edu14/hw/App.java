package com.softserve.academy.edu14.hw;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {

        task1();
        task2();
    }

    public static void task1() {
        System.out.println("""
                Task 1:
                Create class Product with fields manufacture category, date of manufacture and price. 
                Add all needed methods
                    • Create list Product with 20 objects
                    • Obtain a sorted by the price list of products belong to category Phone with
                    price > 3000, and the date of manufacture was more then 1 year ago.
                    • Realize method
                    static Optional<String> mostPopularName(Stream< Employee> employees) { return null; }
                """);
        List<Product> products = Arrays.asList(
                new Product("Phone1", "Phone", LocalDate.of(2022, 1, 1), 3200),
                new Product("Phone2", "Phone", LocalDate.of(2021, 5, 10), 3100),
                new Product("Phone3", "Phone", LocalDate.of(2023, 2, 20), 3500),
                new Product("Phone4", "Phone", LocalDate.of(2020, 8, 5), 3300),
                new Product("Phone5", "Phone", LocalDate.of(2023, 1, 25), 3400),
                new Product("Tablet", "Tablet", LocalDate.of(2022, 6, 15), 1500),
                new Product("Laptop", "Laptop", LocalDate.of(2021, 7, 25), 5000),
                new Product("Watch", "Watch", LocalDate.of(2020, 9, 10), 800),
                new Product("Phone6", "Phone", LocalDate.of(2022, 11, 15), 3600),
                new Product("Phone7", "Phone", LocalDate.of(2022, 9, 5), 3000),
                new Product("Phone8", "Phone", LocalDate.of(2021, 12, 1), 3150),
                new Product("Camera", "Camera", LocalDate.of(2022, 2, 20), 2400),
                new Product("Phone9", "Phone", LocalDate.of(2020, 1, 1), 2900),
                new Product("Phone10", "Phone", LocalDate.of(2021, 3, 10), 3200),
                new Product("Fridge", "Home", LocalDate.of(2022, 4, 10), 4000),
                new Product("Phone11", "Phone", LocalDate.of(2021, 8, 20), 3050),
                new Product("Phone12", "Phone", LocalDate.of(2020, 2, 5), 4100),
                new Product("Mixer", "Home", LocalDate.of(2023, 5, 15), 550),
                new Product("Phone13", "Phone", LocalDate.of(2022, 7, 25), 3100),
                new Product("Phone14", "Phone", LocalDate.of(2023, 1, 15), 2999)
        );

        LocalDate currentDate = LocalDate.now();

        List<Product> filteredProducts = products.stream()
                .filter(p -> "Phone".equals(p.getCategory()) && p.getPrice() > 3000
                        && p.getDateOfManufacture().isBefore(currentDate.minusYears(1)))
                .sorted(Comparator.comparing(Product::getPrice))
                .toList();

        filteredProducts.forEach(System.out::println);
    }

    public static void task2() {
        System.out.println("""
                For given a stream with objects of Employee class, return the optional, containing the most
                  popular name. If this stream is empty, Optional.empty should be returned. For example:
                  empl1.name = “Bob”, empl2.name = “Din”,
                  empl3.name = “Sam”, empl4.name = “Sam”
                  “Sam” should be returned.
                """);

        List<Employee> employeesList = Arrays.asList(
                new Employee("Bob"),
                new Employee("Din"),
                new Employee("Sam"),
                new Employee("Sam"),
                new Employee("Alice"),
                new Employee("Alice"),
                new Employee("Alice")
        );

        Optional<String> mostPopularName = mostPopularName(employeesList.stream());
        System.out.println("Most popular name: " + mostPopularName.orElse("No popular name found"));
    }

    public static Optional<String> mostPopularName(Stream<Employee> employees) {
        return employees
                .collect(Collectors.groupingBy(Employee::name, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }
}
