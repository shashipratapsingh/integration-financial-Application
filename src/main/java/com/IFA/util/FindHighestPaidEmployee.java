package com.IFA.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindHighestPaidEmployee {

    public static void main(String[] args) {
        List<Employee> employeeList= Arrays.asList(
                new Employee(1,"shashi",25,30000,"noida"),
                new Employee(2,"Ram",45,40000,"Ayodhya"),
                new Employee(3,"Lakshmi",20,90000,"Mithila"),
                new Employee(4,"Lav",5,10000,"Longhorn"),
                new Employee(5,"Kush",4,15000,"Srinagar")
        );
        employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary)).ifPresent(System.out::println);

    }

}
