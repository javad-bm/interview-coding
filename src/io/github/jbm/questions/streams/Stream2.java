package io.github.jbm.questions.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    String name;
    Integer age;

    public Employee(String name, Integer age) {
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
        return "Person [name: " + this.name + ", Age: " + this.age + "]";
    }
}

class Business {
    String name;
    List<Employee> employees;

    public Business(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public String getName() {
        return this.name;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    @Override
    public String toString() {
        return "Business{" +
                "name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}

public class Stream2 {

    public static void main(String[] args) {

//        /*
//        This code uses double brace initialization, which is considered an anti-pattern in Java because it:
//            1.	Creates an anonymous subclass of ArrayList, adding overhead.
//            2.	Can accidentally hold a reference to the enclosing instance (causing memory leaks).
//        */
//        var testListString = new ArrayList<>() {{
//            add("Test1");
//            add("Test2");
//            add("Test3");
//            add("Test4");
//        }};
//
//        // A cleaner, modern way in Java would be one of these
//
//        // 1) Immutable list (cannot add/remove elements) Java 9+
//        List<String> testListString1 = List.of("Test1", "Test2", "Test3", "Test4");
//
//        // 2) Mutable list , Java 5+
//        List<String> testListString2 = new ArrayList<>(Arrays.asList("Test1", "Test2", "Test3", "Test4"));
//
//        // 3) Using stream, flexible, if we need transformations!
//        List<String> testListString3 = Stream.of("Test1", "Test2", "Test3", "Test4").toList();
//        List<String> testListString4 = Stream.of("Test1", "Test2", "Test3", "Test4").collect(Collectors.toList());
//

        var businesses = new ArrayList<Business>();

        businesses.add(
                new Business("Google", List.of(
                        new Employee("Gemp1", 20),
                        new Employee("Gemp2", 30),
                        new Employee("Gemp3", 40)
                ))
        );
        businesses.add(
                new Business("Yahoo", List.of(
                        new Employee("Yemp1", 20),
                        new Employee("Yemp2", 30),
                        new Employee("Yemp3", 40)
                ))
        );
        businesses.add(
                new Business("Meta", List.of(
                        new Employee("Memp1", 20),
                        new Employee("Memp2", 30),
                        new Employee("Memp3", 40)
                ))
        );

        // Print name of businesses
        businesses.stream()
                .map(Business::getName)
                .forEach(System.out::println);

        // Print sorted list of all employees
        businesses.stream()
                .flatMap(b -> b.getEmployees().stream())
                .sorted(Comparator.comparing(Employee::getName))
                .map(Employee::getName)
                .forEach(System.out::println);

        // Print sorted list of employees based on Age
        businesses.stream()
                .flatMap(b -> b.getEmployees().stream())
                .sorted(Comparator.comparing(Employee::getAge).reversed())
                .map(Employee::getName)
                .forEach(System.out::println);


        // Get list of employees if their name starts with G
        String s = businesses.stream()
                .flatMap(b -> b.getEmployees().stream())
                .map(Employee::getName)
                .filter(name -> name.startsWith("G"))
                .collect(Collectors.joining(","));
        System.out.println(s);

    }
}



