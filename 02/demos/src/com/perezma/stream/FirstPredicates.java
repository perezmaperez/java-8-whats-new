package com.perezma.stream;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class FirstPredicates {

    public static void main(String... args) {

        Predicate<String> p1 = s -> s.length() > 3;

        Predicate<String> p2 = Predicate.isEqual("two");
        Predicate<String> p3 = Predicate.isEqual("three");

        Stream<String> stream1 = Stream.of("one","two","three","four","five");
        stream1
                .filter(p1)
                .forEach(System.out::println);
        System.out.println();

        Stream<String> stream2 = Stream.of("one","two","three","four","five");
        stream2
                .filter(p2.or(p3))
                .forEach(System.out::println);
    }
}
