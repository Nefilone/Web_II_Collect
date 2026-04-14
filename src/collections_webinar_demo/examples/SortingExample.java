package collections_webinar_demo.examples;
import collections_webinar_demo.model.Person;

import java.util.*;

public class SortingExample {

    public static void run() {

        System.out.println("\n=== SORTING ===");

        List<Person> people = new ArrayList<>();

        people.add(new Person("Alice",25));
        people.add(new Person("Bob",30));
        people.add(new Person("Charlie",20));

        System.out.println("Original:");

        System.out.println(people);


        people.sort(Comparator.comparing(Person::getAge));

        System.out.println("Sorted by age:");

        System.out.println(people);


        people.sort(
                Comparator.comparing(Person::getName)
                        .thenComparing(Person::getAge)
        );

        System.out.println("Sorted by name then age:");

        System.out.println(people);

    }

}