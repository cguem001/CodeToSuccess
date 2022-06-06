package com.carloguemes.Arrays;

import java.util.Arrays;
import java.util.List;

public class HourGlass {

    public static void main(String[] args) {

        List<List<Integer>> myArray = Arrays.asList(
                Arrays.asList(-9, -9, -9, 1, 1, 1),
                Arrays.asList(0, -9,  0, 4, 3, 2),
                Arrays.asList(-9, -9, -9, 1, 2, 3),
                Arrays.asList(0, 0, 8, 6, 6, 0),
                Arrays.asList(0, 0, 0, -2, 0, 0),
                Arrays.asList(0, 0, 1, 2, 4, 0));

        System.out.println(hourglassSum(myArray));
    }

    public static int hourglassSum(List<List<Integer>> arr) {
        int sum = 0;
        int counter = 0;
        int quadrantSum = 0;
        int quadrant = 0;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size(); j++) {
                sum += arr.get(i).get(j);
                quadrantSum++;
                counter++;
                if (counter == 3 && quadrantSum != 7) {
                    i++;
                    j--;
                    sum += arr.get(i).get(j);
                    quadrantSum++;
                    i++;
                    j-=2;
                    counter = 0;
                }
                if (quadrantSum==7) {
                    j-=2;
                    i-=2;
                    counter = 0;
                    quadrantSum = 0;
                    quadrant++;
                    if (sum > result) {
                        result = sum;
                    }
                    sum = 0;

                    if (quadrant == 4) {
                        i++;
                        j = -1;
                        quadrant = 0;
                    }
                }
                if (i ==6) {
                    break;
                }


            }
        }


        return result;
    }
}
