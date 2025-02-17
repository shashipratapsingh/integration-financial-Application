package com.IFA.util;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FirstLetter {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(null,null,6,2,5,2,6,7,8);
        Optional<Integer> s =  list.stream().filter(x->x!=null).findFirst();
        if (s.isEmpty())
        {

            System.err.println("No element found in the list; handling exception gracefully.");
        }else {
            List<Integer> first=s.stream().toList();
            System.out.println(first);
        }
       //list.stream().findFirst().ifPresent(System.out::println);
    }
}
