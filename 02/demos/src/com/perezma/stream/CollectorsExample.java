package com.perezma.stream;

import com.perezma.stream.model.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class also works with a reduction, but rather than aggregating elements,
 * this reduction puts them in a container via the Stream collect operation.
 * The Stream collect operation collects the elements into a String, List, or Map.
 * You can also provide a downstream, secondary collector on the collector,
 * which functions as a post-processor on the original collection.
 */
public class CollectorsExample {

    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();

        try (
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        com.perezma.stream.CollectorsExample.class.getResourceAsStream("people.txt")));

                Stream<String> stream = reader.lines();
        ) {

            stream.map(line -> {
                String[] s = line.split(" ");
                Person p = new Person(s[0].trim(), Integer.parseInt(s[1]));
                persons.add(p);
                return p;
            })
                    .forEach(System.out::println);

        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        // find the youngest person older than 20
        // first filter for persons over 20
        // then use the min reduce to get youngest person
        // by comparing age.
        Stream<Person> stream = persons.stream();

        Optional<Person> opt =
        stream.filter(p -> p.getAge() > 20)
                .min(Comparator.comparing(Person::getAge));
        System.out.println("opt = " + opt);

        // now get the oldest person younger than 30.
        // Remember the stream is already used. To reuse,
        // recreate the stream (persons.stream())
        Optional<Person> optMax =
                persons.stream().filter(p -> p.getAge() < 30)
                        .max(Comparator.comparing(Person::getAge));
        System.out.println("optMax = " + optMax);

        // using Collectors

        // easy way to build a hashmap of persons groups by their age
        Map<Integer, List<Person>> map =
        persons.stream()
                .collect(
                        Collectors.groupingBy(
                                Person::getAge
                        )
                );
        System.out.println("map = " + map);

        // get counts by age in a hashmap
        Map<Integer, Long> mapCounts =
                persons.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getAge,
                                        Collectors.counting()
                                )
                        );
        System.out.println("mapCounts = " + mapCounts);

        // get the names of the persons by age
        Map<Integer, List<String>> mapNames =
                persons.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getAge,
                                        Collectors.mapping(
                                                Person::getName,
                                                Collectors.toList()
                                        )
                                )
                        );
        System.out.println("mapNames = " + mapNames);

        // get the names of the persons by age in alphabetical order
        Map<Integer, Set<String>> mapNamesOrder =
                persons.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Person::getAge,
                                        Collectors.mapping(
                                                Person::getName,
                                                Collectors.toCollection(TreeSet::new)
                                        )
                                )
                        );
        System.out.println("mapNamesOrder = " + mapNamesOrder);

    }
}
