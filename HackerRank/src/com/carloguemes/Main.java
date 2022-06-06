package com.carloguemes;

import com.carloguemes.Arrays.HourGlass;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<List<Integer>> myArray = Arrays.asList(
                Arrays.asList(-9, -9, -9, 1, 1, 1),
                Arrays.asList(0, -9,  0, 4, 3, 2),
                Arrays.asList(-9, -9, -9, 1, 2, 3),
                Arrays.asList(0, 0, 8, 6, 6, 0),
                Arrays.asList(0, 0, 0, -2, 0, 0),
                Arrays.asList(0, 0, 1, 2, 4, 0));



        System.out.println(HourGlass.hourglassSum(myArray));
    }
}
