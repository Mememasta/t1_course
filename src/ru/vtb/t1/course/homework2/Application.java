package ru.vtb.t1.course.homework2;

import ru.vtb.t1.course.homework2.model.Employee;
import ru.vtb.t1.course.homework2.model.Position;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("gena", 25, Position.ENGINEER),
                new Employee("petya", 30, Position.MANAGER),
                new Employee("kyza", 35, Position.MANAGER),
                new Employee("sveta", 19, Position.ENGINEER),
                new Employee("masha", 27, Position.ENGINEER),
                new Employee("anton", 48, Position.ENGINEER)
        );

        distinctList();
        maxValue();
        maxDistinctValue();
        oldestEmployeeEngineer(employees);
        avgAgeEmployeeEngineer(employees);
        longestString();
        mapToStringAndSize();
        printListOrderBy();
        getLongestWord();
    }

    private static void distinctList() {
        List<Integer> distinctList = Stream.of(1, 2, 3, 3, 4, 4)
                .distinct()
                .toList();
        System.out.println(distinctList);
        System.out.println("---------------------------------------");
    }

    private static void maxValue() {
        Optional<Integer> skip = Stream.of(5, 2, 10, 9, 4, 3, 10, 1, 13)
                .sorted(Collections.reverseOrder())
                .skip(2)
                .findFirst();
        skip.ifPresent(System.out::println);
        System.out.println("---------------------------------------");
    }

    private static void maxDistinctValue() {
        Optional<Integer> skip = Stream.of(5, 2, 10, 9, 4, 3, 10, 1, 13)
                .distinct()
                .sorted(Collections.reverseOrder())
                .skip(2)
                .findFirst();
        skip.ifPresent(System.out::println);
        System.out.println("---------------------------------------");
    }

    private static void oldestEmployeeEngineer(List<Employee> employees) {
        List<String> employeeName = employees.stream()
                .filter(employee -> Position.ENGINEER.equals(employee.getPosition()))
                .sorted((Comparator.comparing(Employee::getAge).reversed()))
                .limit(3)
                .map(Employee::getName)
                .toList();
        System.out.println(employeeName);
        System.out.println("---------------------------------------");
    }

    private static void avgAgeEmployeeEngineer(List<Employee> employees) {
        Double averageAge = employees.stream()
                .filter(employee -> Position.ENGINEER.equals(employee.getPosition()))
                .collect(Collectors.averagingInt(Employee::getAge));
        System.out.println(averageAge);
        System.out.println("---------------------------------------");
    }

    private static void longestString() {
        var maxLength = Stream.of("one", "two", "three", "four", "five")
                .max(Comparator.comparing(String::length));
        maxLength.ifPresent(System.out::println);
        System.out.println("---------------------------------------");
    }

    private static void mapToStringAndSize() {
        Map<String, Long> mapWords = Stream.of("programmer worker engineer last one programmer one worker")
                .flatMap(word -> Stream.of(word.split(" ")))
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        System.out.println(mapWords);
        System.out.println("---------------------------------------");
    }

    private static void printListOrderBy() {
        Stream.of("good", "bood", "escape", "one", "two", "three", "four", "five")
                .sorted()
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);
        System.out.println("---------------------------------------");
    }

    private static void getLongestWord() {
        var max = Arrays.stream(new String[]{"one two three four five", "good bad sad happy joy"})
                .flatMap(word -> Stream.of(word.split(" ")))
                .max(Comparator.comparing(String::length));
        max.ifPresent(System.out::println);
        System.out.println("---------------------------------------");
    }

}
