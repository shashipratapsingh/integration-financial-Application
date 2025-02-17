package com.IFA.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertListToUppercase {
    public static void main(String[] arg)
    {
        List<String> name= Arrays.asList("apple","boys","cat","dogs");
       List<String> uppercaseName= name.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(uppercaseName);
    }
}
