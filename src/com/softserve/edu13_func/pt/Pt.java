package com.softserve.edu13_func.pt;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;

public class Pt {
    public static void main(String... args) {
        task1();
        task2();
        task3();
        task4();
    }


    private static void task1() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        System.out.println("Today is " + dayOfWeek);
    }

    private static void task2() {
        LocalDate currentDate = LocalDate.now();
        LocalDate firstInMonth = currentDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));

        System.out.println("A date of first Monday of current month: " + firstInMonth);
    }

    private static void task3() {
        List<String> list = Arrays.asList("One", "Two", "Tree", "Four", "Five", "Six");

        List<String> sortedList = list.stream().sorted().toList();

        System.out.println("Sorted list " + sortedList);

    }

    public static void task4() {
        int[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Integer array: " + Arrays.toString(integers));
        long count = count(integers, num -> num % 2 == 0);
        System.out.println("The number of even numbers in the list: " + count);

    }

    private static long count(int[] ints, IntPredicate predicate) {
        return Arrays.stream(ints).filter(predicate).count();
    }

}
