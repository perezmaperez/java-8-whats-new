package com.perezma.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * This class chains two functional consumers using the andThen default method in the Consumer Functional Interface.
 * A consumer accepts an input argument and does not return anything.
 */
public class ChainConsumers20220604 {

    public static void main(String[] args) {

        // Step 1: Create a list of Strings as source list
        List<String> strings = Arrays.asList("one","two","three","four","five");

        // Step 2: Create an empty list to hold the results of the chaining method.
        List<String> result = new ArrayList<>();

        // Step 3: Create the two consumers
        //         the first one is the System.out.println() as a method reference.
        //         the second is the List.add() method invoked on the result list.

        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = result::add;

        // Step 4: chain the consumers: first print c1 and then add to result list.
        //         use the List.forEach() method to iterate through each element in the list
        //         and then invoke the consumer chaining function to print and
        //         add the string to the result list.

        strings.forEach(c1.andThen(c2));

        // Step 5: Print out size of the result list.

        System.out.println("size of result list = " + result.size());
    }
}
