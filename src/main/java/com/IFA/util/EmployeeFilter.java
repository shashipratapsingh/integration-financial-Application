package com.IFA.util;


import java.util.Arrays;
import java.util.List;

public class EmployeeFilter {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
//                new Employee("Alice", 28),
//                new Employee("Bob", 35),
//                new Employee("Charlie", 32),
//                new Employee("Diana", 25),
//                new Employee("Ethan", 40)
        );

        // Using Stream API to filter employees older than 30
        List<Employee> olderThan30 = employees.stream().filter(e -> e.getAge() > 30)
                .toList();

        // Display the result
        olderThan30.forEach(System.out::println);
    }
}