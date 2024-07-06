package com.softserve.edu14_streamapi.pt;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;


public class Pt {
    public static void main(String... args) {
        task1();
        task2();
    }

    private static void task1() {
        List<String> list = Arrays.asList("bla", "", "simp",
                "", "second", "third", "third", "sec", "blablabla");
        System.out.println("List: " + list);

        long count = list.stream()
                .filter(String::isEmpty).count();
        System.out.println("The number of empty strings in the list: " + count);

        List<String> filtered = list.stream().filter(string -> !string.isEmpty()).toList();
        System.out.println("The list without empty strings: " + filtered);

        String mergedString = filtered.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println("Merged string: " + mergedString);

        System.out.println("------------------------------");
    }


    private static void task2() {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("The count of numbers of list: " + stats.getCount());
        System.out.println("The highest number in List : " + stats.getMax());
        System.out.println("The lowest number in List : " + stats.getMin());
        System.out.println("The sum of numbers : " + stats.getSum());
    }


}
