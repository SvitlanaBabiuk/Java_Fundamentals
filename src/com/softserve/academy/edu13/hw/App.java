package com.softserve.academy.edu13.hw;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }

    public static void task1() {
        System.out.println("""
                Task 1:
                1. Create two methods String encrypt(String s, int n) and String decrypt(Stirng s, int n)
                Method encrypt should take a string and return coded string where every letter is moved
                on n positions in alphabet (e.g. encrypt("abc", 3) returns "def“). Method decrypt should
                return decoded value
                """);
        System.out.println(encrypt("abc", 3));
        System.out.println(decrypt("def", 3));

    }

    public static String encrypt(String s, int n) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] + n);
        }
        return new String(chars);
    }

    public static String decrypt(String s, int n) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] - n);
        }
        return new String(chars);
    }


    public static void task2() {
        System.out.println("""
                2. Create method to validate date according to format "mm.dd.yy"
                """);

        System.out.println(validateDate("01.06.12"));
    }

    public static boolean validateDate(String date) {
        return date.matches("\\d{2}\\.\\d{2}\\.\\d{2}");
    }

    public static void task3() {
        System.out.println("""
                Create method which take year as a parameter and return true if year is a leap
                """);

        System.out.println("2000 is leap year: " + isLeapYear(2000));
        System.out.println("2001 is leap year: " + isLeapYear(2001));

    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    public static void task4() {
        System.out.println("""
                Create variable LocalDate birthday and set to that variable date your birthday.
                Create method that take as a parameter object LocalDate and print the day of the week
                and what was the day of the week after 6 months and what was the day of the week after
                12 months.
                """);

        printBirthdayData(LocalDate.of(1985, 9, 15));
    }

    public static void printBirthdayData(LocalDate birthday) {
        System.out.println("Day of the week: " + birthday.getDayOfWeek());
        System.out.println("Day of the week after 6 months: " + birthday.plusMonths(6).getDayOfWeek());
        System.out.println("Day of the week after 12 months: " + birthday.plusMonths(12).getDayOfWeek());
    }
}
