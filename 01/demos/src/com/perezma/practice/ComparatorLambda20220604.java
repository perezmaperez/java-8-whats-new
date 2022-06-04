package com.perezma.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class uses a Lambda expression uses the Comparator functional interface to compare two Strings.
 */
public class ComparatorLambda20220604 {

    public static void main(String[] args) {

        // Step 1: create an anonymous class using Comparator interface
        //         to order the list of String objs by their length.

        Comparator<String> compAnon = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };

        // Step 2: create a lambda expression using Comparator interface
        //         to order the list of String objs by their length.

        Comparator<String> compLambda =
                (String s1, String s2) -> Integer.compare(s1.length(), s2.length());

        // Step 3: build a list of strings of varying length.

        List<String> listAnon = Arrays.asList("****","***","*","*****","**");
        List<String> listLambda = Arrays.asList("****","***","*","*****","**");

        // Step 4: sort the data by length using Anonymous class
        Collections.sort(listAnon,compAnon);

        // Step 5: Print the results
        for (String s: listAnon) {
            System.out.println(s);
        }

        // Step 6: sort the data by length using a lambda expression

        Collections.sort(listLambda,compLambda);

        // Step 7: Print the results
        for (String s: listLambda) {
            System.out.println(s);
        }


    }
}
