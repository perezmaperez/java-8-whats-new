package com.perezma;

import java.util.*;

/**
 * This class uses a Lambda expression uses the Comparator functional interface to compare two Strings.
 */
public class ComparatorLambda {
    public static void main(String[] args) {

        // anonymous class
        Comparator<String> compAnon = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };

        // Lambda expression
        Comparator<String> compLambda = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());

        // data
        List<String> list = Arrays.asList("****","***","*","*****","**");

        // sort the data by length
        Collections.sort(list,compAnon);

        // output of list using anonymous class
        for(String s : list) {
            System.out.println(s);
        }

        System.out.println();

        // sort the data by length
        Collections.sort(list,compLambda);

        // output of list using lambda expression
        for(String s : list) {
            System.out.println(s);
        }
    }
}
