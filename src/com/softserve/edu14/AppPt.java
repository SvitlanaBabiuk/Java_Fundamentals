package com.softserve.edu14;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class AppPt {
    public static void main(String[] args) {
        task1();
        task2();
    }

    static void task1() {


        List<String> list = Arrays.asList("bla", "", "simp", "", "second", "third", "third", "sec", "blablabla");
        // Виведення кількості порожніх рядків у списку
        long emptyCount = list.stream().filter(String::isEmpty).count();
        System.out.println("Number of empty strings in the list: " + emptyCount);

        // Видалення порожніх рядків зі списку та виведення результату
        List<String> filtered = list.stream().filter(string -> !string.isEmpty()).toList();

        String mergedString = filtered.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println("Merged string: " + mergedString);

    }

    static void task2() {
        // Створення списку простих чисел
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt(Integer::intValue).summaryStatistics();

        System.out.println("Count: " + stats.getCount());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Sum: " + stats.getSum());
    }
}

