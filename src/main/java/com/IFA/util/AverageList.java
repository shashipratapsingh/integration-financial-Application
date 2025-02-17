package com.IFA.util;

import java.util.Arrays;
import java.util.List;

public class AverageList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList();

        // Calculate the average
        list.stream()
                 .mapToInt(Integer::intValue)
                .average()
                .ifPresent(avg -> System.out.println("Average: " + avg));
    }
}