package com.softserve.edu14_streamapi.hw;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hw02 {
    public static void main(String[] args) {

        Stream<Employee> employees = Stream.of(
                new Employee("Bob"),
                new Employee("Din"),
                new Employee("Sam"),
                new Employee("Sam")
        );

        Optional<String> mostPopular = mostPopularName(employees);
        mostPopular.ifPresent(name -> System.out.println("Most popular name: " + name));
    }

    public static Optional<String> mostPopularName(Stream<Employee> employees) {
        Map<String, Long> nameCountMap = employees
                .collect(Collectors.groupingBy(Employee::getName, Collectors.counting()));

        return nameCountMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }
}
