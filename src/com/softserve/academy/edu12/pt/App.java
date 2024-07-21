package com.softserve.academy.edu12.pt;

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
                1. It is required to create a method named squareRectangle that takes two integer parameters "a" and "b" and
                calculates the area of a rectangle: int squareRectangle (int a, int b),
                In case the user enters negative values, the method should throw an exception. The values of "a" and "b" should be
                taken as input from the console. It is recommended to check the correctness of the squareRectangle() method in the
                main() method. Furthermore, it is necessary to verify that the input values are numeric and handle non-numeric
                input accordingly.
                """);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter the value of 'a': ");
            int a = Integer.parseInt(br.readLine());
            System.out.println("Enter the value of 'b': ");
            int b = Integer.parseInt(br.readLine());
            System.out.println("The area of the rectangle is: " + squareRectangle(a, b));
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static int squareRectangle (int a, int b) throws IllegalArgumentException{
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("The values of 'a' and 'b' should be positive");
        }
        return a * b;
    }

    public static void task2() {
        System.out.println("""
                Task 2:
                2. To complete the given task, it is required to create a class named Plant which includes the following fields:
                int size, Color color (an Enum), Type type (an Enum)
                A constructor must be created to initialize these fields. The toString() method should be overridden to provide a
                string representation of the Plant object.
                Two separate classes named ColorException and TypeException should be created to describe all possible
                colors and types of plants respectively. In the main() method, an array of five plants
                should be created, and it should be ensured that the exception handling is working correctly for invalid color and type values.
                 **Add a method that will verify whether the size of the plant is correct and throw an exception if it is too small or too large.
                 **Add a method that will verify whether the color and type are both valid and throw an exception if invalid parameters are entered.
                """);

        Plant[] plants = new Plant[5];
        plants[0] = new Plant(1, Color.RED, Type.INDOOR);
        plants[1] = new Plant(2, Color.GREEN, Type.OUTDOOR);
        plants[2] = new Plant(3, Color.BLUE, Type.INDOOR);
        plants[3] = new Plant(4, Color.YELLOW, Type.OUTDOOR);
        plants[4] = new Plant(5, Color.RED, Type.TREE);

        for (Plant plant : plants) {
            System.out.println(plant);
        }

        try {
            plants[0].validateSize(plants[0].getSize());
            plants[0].validateColorAndType(plants[0].getColor(), plants[0].getType());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
