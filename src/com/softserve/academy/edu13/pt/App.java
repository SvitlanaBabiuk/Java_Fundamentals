package com.softserve.academy.edu13.pt;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class App {

    public static void main(String[] args) {
        task1();
    }

    public static void task1() {
        System.out.println("""
                  Task 1:
                Show which today is a day of a week
                • Show a date of first Monday for current month
                • Write a method for sorting list of Strings using Java 8
                • Create array Integers which has 10 elements, create method count() that takes an array
                of integers as the first parameter and functional interface as the second parameter,
                that functional interface works with integers and defines a condition. Method count()
                return count of elements in array that satisfy the condition defined by the second
                argument.
                """);

        ZoneId zoneId = ZoneId.of("Europe/Kyiv");
        System.out.println("Current time zone: " + zoneId);
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
        LocalDate today = zonedDateTime.toLocalDate();
        DayOfWeek dayOfWeek = today.getDayOfWeek();
        System.out.println("Today is " + dayOfWeek);

        LocalDate firstDayOfMonth = today.withDayOfMonth(1);
        System.out.println("First day of month: " + firstDayOfMonth);
        LocalDate firstMonday = firstDayOfMonth;
        while (firstMonday.getDayOfWeek() != DayOfWeek.MONDAY) {
            firstMonday = firstMonday.plusDays(1);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM dd yyyy");
        System.out.println("The first Monday of the current month is on " + firstMonday.format(formatter) + " in " + zoneId);


        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        integers.add(9);

        System.out.println("Count of even numbers: " + count(integers, list -> {
                            int count = 0;
                            for (Integer integer : list) {
                                count++;
                            }
                            return count;
                        }
                )
        );

    }

    private static Integer count(List<Integer> integers, Function<List<Integer>, Integer> function) {
        return function.apply(integers);
    }
}
