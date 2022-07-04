package com.carlosguemes.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsWithBlondie {

    public static void main(String[] args) {

        //ARRAYS
        int[] numbers = {1, 2, 3, 4, 5, 6};

//        for (int num : numbers) {
//            System.out.println(num);
//        }

        Arrays.stream(numbers).forEach(System.out::println);

        // LIST
        List<Integer> myList = Arrays.stream(numbers)
                .filter(x -> x % 2 == 0)
                .boxed()
                .collect(Collectors.toList());

        List<String> words = Arrays.asList("Apples", "", "Oranges", "Winter");
        words.stream().filter(x -> !x.isEmpty()).forEach(System.out::println);

//        for (String word : words) {
//            if (word.contains("g")) {
//                return true;
//            }
//        }
//        else false;

        boolean hasG = words.stream().anyMatch(x -> x.contains("g"));
        List<String> lowerCasedWords1 = words.stream().map(String::toLowerCase).collect(Collectors.toList());
        List<String> lowerCasedWords = words.parallelStream().map(String::toLowerCase).collect(Collectors.toList());
        lowerCasedWords.forEach(System.out::println);

        "hello world".chars().distinct();
    }
}
