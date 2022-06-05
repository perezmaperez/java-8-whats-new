package com.perezma.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionExample {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10,10,10);

        Integer sum1 =
        list.stream()
                .reduce(0, (i1,i2) -> i1 + i2);
        System.out.println("sum1 = " + sum1);

        Integer sum2 =
        list.stream()
                .reduce(0, Integer::sum);
        System.out.println("sum2 = " + sum2);


        // Must use Optional because the max operation does not have an identity (default) value.
        Optional<Integer> maxValue =
                list.stream()
                        .reduce(Integer::max);

        System.out.println("max = " + maxValue);

    }
}
