package com.IFA.util;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByLength {
    public static void main(String [] args)
    {
        List<String> list= Arrays.asList("apple", "bat", "car", "elephant", "dog");
        Map<Integer, List<String>> list1=  list
                .stream()
                .collect(Collectors
                        .groupingBy(String::length));
        System.out.println(list1);
    }
}
