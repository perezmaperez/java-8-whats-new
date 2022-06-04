package com.perezma.stream.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionExample {

    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(10,10,10);

        List<Integer> list2 = Arrays.asList(-10,-10);

        Integer sumamt =
        list1.stream()
                .reduce(0, Integer::sum);

        System.out.println("sumamt = " + sumamt);

        Optional<Integer> maxval =
        list2.stream()
                .reduce(Integer::max);

        System.out.println("maxval = " + maxval);
    }
}
