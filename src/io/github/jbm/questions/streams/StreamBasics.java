package io.github.jbm.questions.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// This class can't be public
class Person implements Comparable<Person> {
    String name;
    Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person other) {
        return getName().compareTo(other.name);
    }
}

public class StreamBasics {
    public static void main(String[] args) {

        // Filter Example
        var persons = new ArrayList<Person>();
        persons.add(new Person("Test1", 10));
        persons.add(new Person("Test2", 20));
        persons.add(new Person("Test3", 30));
        persons.add(new Person("Test4", 18));
        persons.add(new Person("Test5", 50));
        persons.add(new Person("Test6", 14));
        persons.add(new Person("Test7", 70));
        persons.add(new Person("Test8", 80));
        persons.add(new Person("Test9", 13));
        persons.add(new Person("Test10", 38));

        List<Person> minorPersons = persons
                .stream()
                .filter(p -> p.getAge() < 18)
                .toList();

        System.out.println(minorPersons);

        // Limit example
        int [] numbers = {1,2,3,4,5,6,7,8,9,10};
        Arrays.stream(numbers)
                .limit(4)
                .forEach(System.out::println);

        // Map Example (print all the names)
        persons.stream()
                .map(Person::getName)
                .forEach(System.out::println);

        // Sort (sort all the names)
        persons.stream()
                .sorted((p1,p2) -> p1.getName().compareTo(p2.getName()))
                .map(Person::getName)
                .forEach(System.out::println);

        // Get the 5 Youngest!
        persons.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .limit(5)
                .forEach(System.out::println);

        // Get the 5 Oldest!
        persons.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .limit(5)
                .forEach(System.out::println);

        // Sort using names (we implement comparable interface)
        persons.stream()
                .sorted()
                .limit(5)
                .forEach(System.out::println);
    }
}


