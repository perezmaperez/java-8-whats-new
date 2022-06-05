package com.perezma.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * This class invokes the methods in the Predicate Functional Interface
 * using the Stream peek() and filter() methods.
 */
public class PredicatesIntermediaryAndFinal20220604 {

    public static void main(String[] args) {

        // Step 1: Create the Predicate functions

        Predicate<String> p1 = Predicate.isEqual("two");
        Predicate<String> p2 = Predicate.isEqual("three");

        // Step 2: Define a list that contains the data to test
        //         and another to hold the result.

        List<String> list = Arrays.asList("one","two","three","four","five");
        List<String> result = new ArrayList<>();

        // Step 3: First, use the peek() method to print all the elements in the list.
        //         Next, filter for values equal to p1 or p2.
        //         Finally, add filtered values to result list
        //         The peek and forEach operations both take a Consumer,
        //         while the filter operation takes a Predicate.
        //
        //         The peek operation is an intermediary operation because it returns a stream.
        //         The filter operation is an intermediary operation because it returns a stream.
        //         The forEach operation is a terminal operation because it doesn't return anything (void).


        list.stream()
                .peek(System.out::println)
                .filter(p1.or(p2))
                .forEach(result::add);

        // Step 4: print the size of the result list.

        System.out.println("result size = "+result.size());

    }
}
