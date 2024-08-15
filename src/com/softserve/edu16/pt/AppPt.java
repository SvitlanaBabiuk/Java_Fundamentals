package com.softserve.edu16.pt;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class AppPt {
    public static String PATH = "src/com/softserve/edu16/pt/mytext.txt";

    public static void main(String[] args) {
        System.out.println("-".repeat(40) + "First practical task" + "-".repeat(40));
        pt1();
        System.out.println("-".repeat(40) + "Second practical task" + "-".repeat(40));
        pt2();
    }


    public static void pt1() {
        List<String> lines = readDataFromFile(PATH);
        String[] linesArray = lines.toArray(new String[0]);

        printArrFromFile(linesArray);
        System.out.println();

        findNumberSymbolInLines(linesArray);
        System.out.println();

        findLongestline(lines);
        findShortestline(lines);

        System.out.println("\nFirst method");
        printVarLines(linesArray);//Перший спосіб

        System.out.println("\nSecond method");
        printVarLinesStream(linesArray);//Другий спосіб     Який краще?
    }

    public static void printArrFromFile(String[] arr) {
        System.out.println("Text from file:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + 1 + " " + arr[i]);
        }
    }

    public static void findNumberSymbolInLines(String[] arr) {
        System.out.println("The number of symbols in each lines:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Line number = " + (i + 1) + "  Count of symbols = " + arr[i].length());
        }
    }

    public static void findLongestline(List<String> arrlist) {
        String longest = arrlist.stream().max(Comparator.comparing(String::length)).orElse("The list is clear");
        System.out.println("The longest string: " + longest);
    }

    public static void findShortestline(List<String> arrlist) {
        String shortest = arrlist.stream().min(Comparator.comparing(String::length)).orElse("The list is clear");
        System.out.println("The shortest string: " + shortest);
    }

    private static void printVarLines(String[] lines) { //Перший спосіб
        String varRegex = "\\bvar\\b";
        Pattern varPattern = Pattern.compile(varRegex);

        System.out.println("Var lines:");
        for (int i = 0; i < lines.length; i++) {
            if (varPattern.matcher(lines[i]).find()) {
                System.out.printf("Line %d: %s%n", i + 1, lines[i]);
            }

        }
    }

    private static void printVarLinesStream(String[] lines) { //Другий спосіб
        List<String> ListWithVarLines = Arrays.stream(lines)
                .filter(s -> s.matches(".*\\bvar\\b.*"))
                .toList();

        System.out.println("List of lines that include the word 'Var': ");
        for (String varLines : ListWithVarLines) {
            System.out.println(varLines);
        }
    }

    private static List<String> readDataFromFile(String path) {
        FileReader fr = null;
        BufferedReader br = null;
        List<String> lines = new ArrayList<>();
        String read;

        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            System.out.println("Read data from file: " + path);

            while ((read = br.readLine()) != null) {
                lines.add(read);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        return lines;
    }

    private static void pt2() {
        String[] words = new String[0];
        try {
            String[] lines = Files.readAllLines(Paths.get(PATH)).toArray(new String[0]);

            words = Arrays.stream(lines)
                    .flatMap(line -> Arrays.stream(line.split("[\\s.,!?;:\\[\\]()\"']+")))
                    .toArray(String[]::new);


        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Received text:\n" + Arrays.toString(words));
        System.out.println();
        findVowelWords(words);
        System.out.println();
        firstLastLetter(words);

    }

    public static void findVowelWords(String[] words) {
        System.out.println("/Words starting with a vowel:/");

        for (String word : words) {
            if (word.toLowerCase().matches("^[aeiou].*")) {
                System.out.print(word + "; ");
            }
        }
    }

    public static void firstLastLetter(String[] words) {
        System.out.println("\n/Words for which the last letter of one words matches " +
                "the first letter of the next word:/");

        for (int i = 0; i < words.length - 1; i++) {
            char currentWordLastLetter = Character.toLowerCase(words[i].charAt(words[i].length() - 1));
            char nextWordFirstLetter = Character.toLowerCase(words[i + 1].charAt(0));

            if (currentWordLastLetter == nextWordFirstLetter) {
                System.out.println(words[i] + " " + words[i + 1]);
            }
        }
    }

}




