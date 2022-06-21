package com.carloguemes.Arrays;

import java.util.Arrays;
import java.util.List;

public class HourGlass {

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
