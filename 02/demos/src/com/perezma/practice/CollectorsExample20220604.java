package com.perezma.practice;

import com.perezma.stream.model.Person;

import javax.swing.text.html.Option;
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
public class CollectorsExample20220604 {

    public static void main(String[] args) {

        // Prerequisite: create a text file of people and their age.
        //               See people.txt
        //               Create a java bean called Person to hold the name, age data.

        // Step 1: Create a list called Persons that will hold the Person data.
        List<Person> persons = new ArrayList<>();

        // Step 2: Load the persons list from the text file.
        try (
                BufferedReader reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        com.perezma.stream.CollectorsExample.class
                                                .getResourceAsStream("people.txt")));

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

        // Step 3: Convert the List into a Stream
        Stream<Person> stream = persons.stream();

        // Step 4: Interrogate the stream - find the youngest person older than 20.
        //         First filter the stream and set up the Predicate to test the age in each element.
        //         Next, use the Comparator.comparing on getAge() to find the min in the stream.
        //         The min() returns an Optional of type Person.
        //         Print the results.
        System.out.println("Find the youngest person older than 20.");
        Optional<Person> opt =
        stream.filter(p -> p.getAge() >= 20)
                .min(Comparator.comparing(Person::getAge));
        System.out.println("opt = "+ opt);

        // Step 5: Interrogate the stream - find the oldest person in the list.
        //         Remember you can only use a stream once. Instead, call the stream operation on the list.
        System.out.println("Find the oldest person in the list.");
        Optional<Person> optOldest =
        persons.stream()
                .max(Comparator.comparing(Person::getAge));
        System.out.println("optOldest = "+ optOldest);

        // Step 6: Let's interrogate the stream using a collector. Build a HashMap of Person grouped by their age.
        //         The collect operation returns a Map where the key = the grouping by age
        //         and the value by default is the List.
        //         In this case, the result is a Map<Integer, List<Person>>.
        //         Print out the Map to see the results.
        System.out.println("Build a HashMap of Person grouped by their age.");
        Map<Integer, List<Person>> map =
        persons.stream()
                .collect(Collectors.groupingBy(
                        Person::getAge
                ));
        System.out.println(map);

        // Step 7: Let's interrogate the stream using a downstream collector.
        //         Build a HashMap of count of people grouped by their age.
        //         The downstream collector Collectors.counting() is added within the collect operation.
        //         The collect operation returns a Map where the key = the grouping by Age
        //         and the value is the count.
        //         In this case, the result is a Map<Integer, Long>.
        //         Print out the Map to see the results.
        System.out.println("Build a HashMap of count of people grouped by their age.");
        Map<Integer, Long> mapCounts =
                persons.stream()
                        .collect(Collectors.groupingBy(
                                Person::getAge,
                                Collectors.counting()
                        ));
        System.out.println(mapCounts);

        // Step 8: Let's interrogate the stream using another downstream collector.
        //         Build a HashMap of names of people grouped by their age.
        //         You get the names by using the downstream collector Collectors.mapping().
        //         The collect operation returns a Map where the key = the grouping by Age
        //         and the value is the names list.
        //         In this case, the result is a Map<Integer, List<String>>.
        //         Print out the Map to see the results.
        System.out.println("Build a HashMap of names of people grouped by their age.");

        Map<Integer, List<String>> mapNames =
                persons.stream()
                        .collect(Collectors.groupingBy(
                                Person::getAge,
                                Collectors.mapping(
                                        Person::getName,Collectors.toList()
                                )
                        ));
        System.out.println(mapNames);

        // Step 9: Let's interrogate the stream using a downstream collector.
        //         Build a HashMap of names of people in alphabetical order (TreeSet) grouped by their age.
        //         You get the names by using the downstream collector Collectors.mapping().
        //         The collect operation returns a Map where the key = the grouping by Age
        //         and the value is a set of names in alphabetical order.
        //         In this case, the result is a Map<Integer, Set<String>>.
        //         Print out the Map to see the results.
        System.out.println("Build a HashMap of names of people in alphabetical order grouped by their age.");

        Map<Integer, Set<String>> mapAlphaNames =
                persons.stream()
                        .collect(Collectors.groupingBy(
                                Person::getAge,
                                Collectors.mapping(
                                        Person::getName,Collectors.toCollection(TreeSet::new)
                                )
                        ));
        System.out.println(mapAlphaNames);

        // Step 10: Let's interrogate the stream using a downstream collector.
        //         Build a HashMap of names of people in a comma-separated String grouped by their age.
        //         You get the names by using the downstream collector Collectors.mapping().
        //         The collect operation returns a Map where the key = the grouping by Age
        //         and the value is a set of names in alphabetical order.
        //         In this case, the result is a Map<Integer, String>.
        //         Print out the Map to see the results.
        System.out.println("Build a HashMap of names of people in a comma-separated String grouped by their age.");

        Map<Integer, String> mapCommaSepNames =
                persons.stream()
                        .collect(Collectors.groupingBy(
                                Person::getAge,
                                Collectors.mapping(
                                        Person::getName,Collectors.joining(", ")
                                )
                        ));
        System.out.println(mapCommaSepNames);

    }
}
