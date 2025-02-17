package com.IFA.util;

import java.util.Arrays;
import java.util.List;

public class FindSecondHighestNumber {
    public static void main(String [] args){
        List<Integer> list= Arrays.asList(2,4,5,4,5,2,3,4,5,2,5,3,10,11,12,800); //10

        List<Integer> l =  list.stream().distinct().sorted((a,b)->b-a).skip(1).findFirst().stream().toList();
        System.out.println(l);


    }
}
