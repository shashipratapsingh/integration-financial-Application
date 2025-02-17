package com.IFA.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class FindTheMostFrequentElement {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 2, 3, 4, null, 3, 2, 4, 4, 4);
        Map<Integer,Long> map= numbers.stream().filter(Objects::nonNull).collect(Collectors.groupingBy(a->a,Collectors.counting()));
        System.out.println(map);
        map.values().stream().mapToInt(Long::intValue).min().ifPresent(System.out::println);
        map.values().stream().mapToInt(Long::intValue).max().ifPresent(System.out::println);
    }
}
