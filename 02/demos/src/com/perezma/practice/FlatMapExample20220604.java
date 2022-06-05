package com.perezma.practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * This class uses the Stream operations to process a List of lists.
 * The two Stream operations highlighted in the code below are map() and flatMap().
 * This is the first step of the Map/Filter/Reduce algorithm.
 */
public class FlatMapExample20220604 {

    public static void main(String[] args) {

        // Step 1: Define the Lists of Integers
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> list2 = Arrays.asList(2,4,6);
        List<Integer> list3 = Arrays.asList(3,5,7);

        // Step 2: Build a List of lists
        List<List<Integer>> lists = Arrays.asList(list1,list2,list3);

        // Step 3: Print the contents of the List of lists
        System.out.println(lists);

        // Step 4: First, build a Stream of this list.
        //         Next, map it (3 lists, get size of each).
        //         Finally, print the output.
        //         The map operation takes a Function.
        System.out.println("contents of the list using the lambda expression in the map operation.");
        lists.stream()
                .map(l -> l.size())
                .forEach(System.out::println);

        // Step 5: take the lambda expression of the map operation
        //         and make it a first-class (separate) function.
        //         The function takes a List of any object (?) and returns an Integer.
        Function<List<?>, Integer> size = List::size;

        // Step 6: replace the lambda expression with the function in the map operation.
        System.out.println("contents of the list using the Function functional interface in a map operation.");
        //         The map operation takes a Function, while the forEach operation takes a Consumer.
        lists.stream()
                .map(size)
                .forEach(System.out::println);

        // Step 7: build a function for a flatmap. This function should take an element
        //         of type List and returns a Stream of objects (Integer).
        Function<List<Integer>, Stream<Integer>> flatMapper =
                l -> l.stream();

        // Step 8: replace the map with a flatMap operation.
        //         It will flatten values in the stream into a single stream.
        //         The flatMap operation takes a Function, while the forEach operation takes a Consumer.
        System.out.println("contents of the list using the flatMap operation.");
        lists.stream()
                .flatMap(flatMapper)
                .forEach(System.out::println);
    }
}
