package com.perezma.practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * This class invokes methods of the Predicate Functional Interface using a Stream filter() method.
 */
public class FirstPredicates20220604 {

    public static void main(String[] args) {

        // Step 1: Create Predicate expressions

        // Returns a String if its length is greater than 3
        Predicate<String> p1 = s -> s.length() > 3;

        // Returns a String if the String is equal to "two"
        Predicate<String> p2 = Predicate.isEqual("two");

        // Returns a String if the String is equal to "three"
        Predicate<String> p3 = Predicate.isEqual("three");

        // Step 2: Define list of Strings
        List<String> list = Arrays.asList("one","two","three","four","five");

        // Step 3: filter the list for p1 and print the result
        //         The filter operation takes a Predicate and is an intermediary operation
        //         because it returns a stream.
        //         The forEach operation is a terminal operation because it doesn't return anything.
        System.out.println("filtered list for string length > 3");
        list.stream()
                .filter(p1)
                .forEach(System.out::println);

        // Step 4: filter the list for p2 or p3 using the Predicate default method or()
        System.out.println("filtered list for values equal two or three");
        list.stream()
                .filter(p2.or(p3))
                .forEach(System.out::println);



    }
}
