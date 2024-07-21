package com.softserve.academy.edu11.pt;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    public static void task1() {
        System.out.println("""
                Task 1:
                Input two String variables. Verify if the first variable is a substring of the second variable.
                For instance, if you entered \"SoftServe\" and \"SoftServe Academy\", the expected result should be true.);
                """);
        String s1 = "SoftServe";
        String s2 = "SoftServe Academy";
        if (s2.contains(s1)) {
            System.out.println("The first variable is a substring of the second variable.");
        } else {
            System.out.println("The first variable is not a substring of the second variable.");
        }
    }

    public static void task2() {
        System.out.println("""
                        Task 2:
                        Input the last name, first name, and middle name as String variables on the console. The
                following outputs will be displayed on the console:
                    • Last name and initials
                    • First name
                    • First name, middle name, and last name.
                """);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the last name, first name, and middle name:");
        String lastName = scanner.nextLine();
        String firstName = scanner.nextLine();
        String middleName = scanner.nextLine();

        System.out.println("Last name and initials: " + lastName + " " + firstName.charAt(0) + "." + middleName.charAt(0) + ".");
        System.out.println("First name: " + firstName);
        System.out.println("First name, middle name, and last name: " + firstName + " " + middleName + " " + lastName);
    }

    public static void task3() {
        System.out.println("""
                Task 3:
                The task requires validation of usernames using regular expressions. The username should be
                between 3 to 15 characters and can contain only Latin alphabet, numbers, and underscores. To
                accomplish this, input five different usernames in the main method and output a message to the
                console indicating whether each of the entered names is valid or not.
                """);

        String[] usernames = new String[5];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter five usernames:");
        for (int i = 0; i < 5; i++) {
            usernames[i] = scanner.nextLine();
        }

        for (String username : usernames) {
            if (username.matches("[a-zA-Z0-9_]{3,15}")) {
                System.out.println(username + " is a valid username.");
            } else {
                System.out.println(username + " is not a valid username.");
            }
        }
    }
}
