package com.softserve.edu14.pt.pt1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("bla", "", "simp", "", "second", "third", "third", "sec", "blablabla");

        long emptyCount = list.stream()
                .filter(String::isEmpty)
                .count();
        System.out.println("Empty count: " + emptyCount);

        List<String> nonEmptyList = list.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        System.out.println("Removed: " + nonEmptyList);

        String result = nonEmptyList.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println("Uppercase strings with comma: " + result);
    }
}
