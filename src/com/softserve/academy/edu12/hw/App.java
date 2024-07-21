package com.softserve.academy.edu12.hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) {
        task1();
        task2();
    }

    public static void task1() {
        System.out.println("""
                Task 1:
                Create div() method, which calculates the dividing of two double type numbers.
                In main() method input 2 double numbers and call this method. Catch all exceptions.
                """);

        try {
            double a = 10;
            double b = 0;
            System.out.println(div(a, b));
        } catch (ArithmeticException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }


    }

    private static double div(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    public static void task2() {
        System.out.println("""
                2. Create a method readNumber(int start, int end), that read from console integer number
                and return it, if it is in the range [start...end]. If an invalid number or non-number text is
                read, the method should throw an exception.
                    Using this method write a method main(), that must enter 10 numbers:
                        a1, a2, ..., a10, such that 1 < a1 < ... < a10 < 100
                """);


        try {
            int start = 1;
            int end = 100;
            for (int i = 0; i < 10; i++) {
                System.out.println(readNumber(start, end));
            }
        } catch (IllegalArgumentException | java.io.IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static int readNumber(int start, int end) throws IllegalArgumentException, java.io.IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the value of 'a': ");
        int a = Integer.parseInt(br.readLine());
        if (a < start || a > end) {
            throw new IllegalArgumentException("The value should be in the range [" + start + "..." + end + "]");
        }
        return a;
    }
}
