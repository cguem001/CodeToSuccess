package com.carlosguemes.streams;

// https://www.youtube.com/watch?v=t1-YZ6bF-g0&ab_channel=JoeJames

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsWithJoeJames {

    public static void main(String[] args) throws IOException {

        //1. Integer Stream
        IntStream
                .range(1, 10)
                .forEach(System.out::println);
        System.out.println();

        //2. Integer Stream with skip
        IntStream
                .range(1, 10)
                .skip(5)
                .forEach(x -> System.out.println(x));
        System.out.println();

        // 3. Integer Stream with sum
        System.out.println(
                IntStream
                        .range(1, 5)
                        .sum()
        );
        System.out.println();

        // 4. Stream.of, sorted and findFirst
        Stream.of("Ava", "Aneri", "Alberto")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println();

        // 5. Stream from Array, sort, filter and print
        String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda","Hans", "Shivika", "Sal"};
        Arrays.stream(names)    // same as Stream.of(names)
                .filter(x -> x.startsWith("S"))
                .sorted()
                .forEach(System.out::println);

        System.out.println();

        // 6. average of squares of an int array
        Arrays.stream(new int[] {2,4,6,8,10})
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::println);

        System.out.println();

        // 7. Stream from List, filter and print
        List<String> people = Arrays.asList("Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda","Hans", "Shivika", "Sal");

        people
                .stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("a"))
                .forEach(x -> System.out.println(x));

        System.out.println();

        // 8. Stream rows from text file, sort, filter and print
        Stream<String> bands = Files.lines(Paths.get("src/Resources/bands.txt"));
        bands
                .sorted()
                .filter(x -> x.length() > 13)
                .forEach(System.out::println);
        bands.close();

        System.out.println();

        // 9. Stream rows from text file and save to List
        List<String> band2 = Files.lines(Paths.get("src/Resources/bands.txt"))
                .filter(x -> x.contains("jit"))
                .collect(Collectors.toList());
        band2.forEach(System.out::println);

        System.out.println();

        // 10 Stream rows from csv file and count
        Stream<String> rows1 = Files.lines(Paths.get("src/Resources/data.txt"));
        int rowCount = (int)rows1
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .count();
        System.out.println(rowCount + " rows.");
        rows1.close();

        System.out.println();

        // 11. Stream rows from CSV file, parse data from rows
        Stream<String> rows2 = Files.lines(Paths.get("src/Resources/data.txt"));
        rows2
                .map(s -> s.split(","))
                .filter(s -> s.length == 3)
                .filter(s -> Integer.parseInt(s[1]) > 15)
                .forEach(s -> System.out.println(s[0] + " " + s[1] + " " + s[2]));
        rows2.close();

        System.out.println();

        // 12. Stream rows from CSV file, store fields in HashMap
        Stream<String> rows3 = Files.lines(Paths.get("src/Resources/data.txt"));
        Map<String, Integer> map = new HashMap<>();
        map = rows3
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 15)
                .collect(Collectors.toMap(
                        x -> x[0],
                        x -> Integer.parseInt(x[1])
                ));
        rows3.close();
        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }

        System.out.println();

        // 13. Reduction - sum
        double total = Stream.of(7.3, 1.5, 4.8)
                .reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println("Total = " + total);

        System.out.println();

        // 14. Reduction - summary statistics
        IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10)
                .summaryStatistics();
        System.out.println(summary);

    }

}
