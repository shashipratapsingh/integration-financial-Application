package com.IFA.util;

import java.util.Arrays;
import java.util.List;

public class LengthGreaterGivenNumber {

    public static void main(String[] args) {
        List<Integer> list=Arrays.asList(2,4,6,7,8,2,8,3,5);
        List<Integer> numberLessThenFive=  list.stream().sorted().distinct().filter((a->a<=5)).toList();
        long c=  numberLessThenFive.stream().count();
        System.out.println("Elements which in less then Five : "+numberLessThenFive);
        System.out.println("Total Elements which in less then Five : "+c);
    }
}
