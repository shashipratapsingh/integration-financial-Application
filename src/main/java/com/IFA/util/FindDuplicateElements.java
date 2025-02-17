package com.IFA.util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicateElements {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12, 3, 34,34, 12, 34, 4, 3, 6, 7);

        // Find duplicate elements
        Set<Integer> duplicates = list.stream().collect(Collectors.groupingBy(a -> a, Collectors.counting()))
                .entrySet().stream()
                .filter(a -> a.getValue()>2)
                .map(a -> a.getKey())
                .collect(Collectors.toSet());

        System.out.println("Duplicate elements: " + duplicates);
    }
}
