package com.softserve.edu03.hw.task3;
import java.time.LocalDate;
import java.util.Scanner;
public class Person {
    private String firstName;
    private String lastName;
    private int birthYear;  //the birthday year

    public Person() {
    }

    public Person(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthYear;
    }

    public void output() {// Name should start from lowercase
        System.out.println("First Name: " + firstName + '\n' +
                "Last Name: " + lastName + '\n' +
                "Age: " + getAge());
    }

    public void input() {// The same here
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter First Name");
        firstName = scanner.nextLine();

        System.out.println("Enter Last Name");
        lastName = scanner.nextLine();

        System.out.println("Enter the birthday year");
        birthYear = Integer.parseInt(scanner.nextLine());
    }

    public void changeName(String firstName, String lastName) {// Name of the method should start from lowercase
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

