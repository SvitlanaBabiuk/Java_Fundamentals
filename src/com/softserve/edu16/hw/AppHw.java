package com.softserve.edu16.hw;

import com.softserve.edu16.pt.AppPt;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class AppHw {
    public static String READPATH = "src/com/softserve/edu16/hw/file1.txt";
    public static String WRITEPATH = "src/com/softserve/edu16/hw/file2.txt";
    public static String CARREADPATH = "src/com/softserve/edu16/hw/Car.java";
    public static String CARWRITEPATH = "src/com/softserve/edu16/CreatedFile/Car.java";


    public static void main(String[] args) {
        System.out.println("-".repeat(30) + "First homework" + "-".repeat(30));
        hw1();
        System.out.println("-".repeat(30) + "Second homework" + "-".repeat(30));
        hw2();
    }

    public static void hw1() {
        String[] lines = new String[0];
        try {
            lines = Files.readAllLines(Paths.get(READPATH)).toArray(new String[0]);
            if (lines.length == 0) {
                System.err.println("File is empty or could not be read.");
            }
        } catch (IOException e) {
            System.err.println("File could not be read" + e.getMessage());
        }

        AppPt.printArrFromFile(lines);
        String numberOfLines = "The number of lines in file1.txt:" + lines.length + "\n";
        String longestLine = findLongestLines(lines) + "\n";
        String name = "Name:Pavlo Chernyavckiy\n";
        String birthday = "Date of birthday:18/02/2004\n";

        try (FileWriter fw = new FileWriter(WRITEPATH);
             BufferedWriter bw = new BufferedWriter(fw)) {

            System.out.println("Write data to file: " + WRITEPATH);
            bw.write(numberOfLines);
            bw.write(longestLine);
            bw.write(name);
            bw.write(birthday);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static String findLongestLines(String[] arr) {
        String longest = Arrays.stream(arr)
                .max(Comparator.comparing(String::length))
                .orElse("The array is clear");

        return "The longest line in file1.txt: " + longest;
    }

    public static void hw2() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(CARREADPATH));

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(CARWRITEPATH))) {
                for (int i = 0; i < lines.size(); i++) {
                    String line = lines.get(i);

                    if (line.trim().matches("^public\\s+(class|interface|enum)\\s+.*")) {
                        bw.write(line + "\n");
                    } else {
                        String modiifedLine = line.replaceAll("\\bpublic\\b", "private");
                        bw.write(modiifedLine + "\n");
                    }
                }
                System.out.println("File has been processed and saved to: " + CARWRITEPATH);

            }
        } catch (IOException e) {
            System.err.println("File could not be read" + e.getMessage());
        }
    }
}
