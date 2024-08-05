package com.softserve.academy.edu14.pt;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        task1();
        task2();
    }

    public static void task1() {
        System.out.println("""
                Task 1:
                Suppose you have next list
                List<String> list = Arrays.asList("bla", "", "simp",
                "", "second", "third", "third", "sec", "blablabla");
                2.
                •Print how many empty strings are in this list
                •Remove all empty Strings from list and print the result
                •Convert String to uppercase and Join them with coma. Print the result
                """);
        List<String> list = Arrays.asList("bla", "", "simp", "", "second", "third", "third", "sec", "blablabla");

        long emptyStringCount = list.stream().filter(String::isEmpty).count();
        System.out.println("Number of empty strings: " + emptyStringCount);

        List<String> listWithoutEmptyStrings = list.stream().filter(s -> !s.isEmpty()).toList();
        System.out.println("List without empty strings: " + listWithoutEmptyStrings);

        String joinedString = listWithoutEmptyStrings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));
        System.out.println("Joined string in uppercase: " + joinedString);
    }

    public static void task2() {
        System.out.println("""
                For given collection
                List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
                calculate count, min, max, sum, for numbers and print all results
                """);
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);

        System.out.println("Count: " + primes.size());

        int min = primes.stream().min(Integer::compareTo).orElseThrow(NoSuchElementException::new);
        System.out.println("Min: " + min);

        int max = primes.stream().max(Integer::compareTo).orElseThrow(NoSuchElementException::new);
        System.out.println("Max: " + max);

        System.out.println("Sum: " + primes.stream().mapToInt(Integer::intValue).sum());

        double average = primes.stream().mapToInt(Integer::intValue).average().orElseThrow(NoSuchElementException::new);
        System.out.println("Average: " + average);
    }
}
