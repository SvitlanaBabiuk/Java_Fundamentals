package com.softserve.academy.edu11.hw;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                The task involves inputting a sentence of five words through the console.
                The following actions must be performed:
                 • Identify the longest word in the sentence and display it on the console.
                 • Determine the number of letters in the longest word.
                 • Display the second word of the sentence in reverse order on the console.
                """);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence of five words:");
        String sentence = scanner.nextLine();
        String[] words = sentence.split(" ");
        String longestWord = words[0];
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        System.out.println("The longest word in the sentence is: " + longestWord);
        System.out.println("The number of letters in the longest word is: " + longestWord.length());
        System.out.println("The second word of the sentence in reverse order is: " + new StringBuilder(words[1]).reverse());

    }

    public static void task2() {
        System.out.println("""
                Іnput a sentence that contains words separated by more than one space on the console.
                The goal is to replace all consecutive spaces with a single space. For instance, if you entered the
                sentence "I am learning Java Fundamental", the expected result should be "I am learning Java Fundamental".
                """);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence with multiple spaces:");
        String sentence = scanner.nextLine();
        System.out.println("The sentence with multiple spaces replaced with a single space is: " + sentence.replaceAll("\\s+", " "));
    }

    public static void task3() {
        System.out.println("""
                Task 3:
                The task requires implementation of a pattern to match US currency format, which includes a
                dollar sign ($) followed by any number of digits, a dot, and two digits after the dot. The next step
                is to input a text containing several instances of US currency format via the console. Finally,
                display all the occurrences of US currency format on the console screen.
                """);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a text containing US currency formats:");
        String inputText = scanner.nextLine();
        String regex = "\\$\\d+\\.\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputText);
        System.out.println("Found currency formats:");
        boolean found = false;
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }

        if (!found) {
            System.out.println("No currency formats found.");
        }
        scanner.close();
    }

    public static void task4() {
        System.out.println("""
                Task 4:
                4*. Create a console application that validates user input for their first and last name, ensuring that
                they only contain English letters, spaces, and hyphens. If the input data is incorrect, prompt the user
                to re-enter the data. Upon successful entry of the user's first and last names, generate a random
                greeting message that includes the user's name.
                To validate the user input, utilize String class methods, control loops, and regular expressions.
                Generate the random greeting message (use printf() method for output) by creating an array of
                phrases that contain various text options with the user's name inserted.
                """);
        Scanner scanner = new Scanner(System.in);

        String firstName;
        String lastName;
        boolean validInput = false;
        do {
            System.out.println("Enter your first name:");
            firstName = scanner.nextLine();
            System.out.println("Enter your last name:");
            lastName = scanner.nextLine();
            if (firstName.matches("[a-zA-Z -]+") && lastName.matches("[a-zA-Z -]+")) {
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter only English letters, spaces, and hyphens.");
            }
        } while (!validInput);
        scanner.close();
    }

}
