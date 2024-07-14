package com.softserve.graduation_project;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exceptions {
    private static final Scanner scan = new Scanner(System.in);

    public static String readName(String promt) {
        String pattern = "^[a-zA-ZА-Яа-я\\s-]+$";
        Pattern p = Pattern.compile(pattern);

        String name = "";
        while (true) {
            System.out.println("Input first name: ");
            name = scan.nextLine();
            Matcher mf = p.matcher(name);

            if (mf.matches()) {
                break;
            } else {
                System.out.println("Please input only letters, spaces, or hyphens.");
            }
        }
        return pattern;
    }

    public static int readCourse(String promt) {
        var scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(promt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("Please use only numbers");
            }
        }
    }

    public static double readGrade(String promt) {
        var scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(promt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println("It should be a number/double number");
            }
        }
    }
}
