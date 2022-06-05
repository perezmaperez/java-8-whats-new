package com.perezma.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * This class contains examples of using the reduce operation of a Stream
 * to get an aggregate value.
 */
public class ReductionExample20220604 {

    public static void main(String[] args) {

        // Step 1: Create a list of Integers
        List<Integer> list = Arrays.asList(10,10,10);

        // Step 2: Reduce (aggregate) the values by summing them.
        //         Use a lambda expression to get the sum.
        //         The sum operation has an identity (default) value of 0.
        Integer sum1 =
                list.stream()
                        .reduce(0, (i1,i2) -> i1 + i2);

        // Step 3: Print the result of the reduce operation.
        System.out.println("sum1 = " + sum1);

        // Step 4: Reduce (aggregate) the values by summing them.
        //         Use the Integer method reference to get the sum.
        //         The sum operation has an identity (default) value of 0.
        Integer sum2 =
                list.stream()
                        .reduce(0, Integer::sum);

        // Step 5: Print the result of the reduce operation.
        System.out.println("sum2 = " + sum2);

        // Step 6: Reduce the values by getting the max value in the list.
        //         Must use Optional because the max operation does not have
        //         an identity (default) value.
        Optional<Integer> maxValue =
                list.stream()
                        .reduce(Integer::max);

        // Step 7: Print the result of the reduce operation.
        System.out.println("max = " + maxValue);

    }
}
