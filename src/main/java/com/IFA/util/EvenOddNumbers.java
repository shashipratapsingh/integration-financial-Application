package com.IFA.util;

import java.util.Arrays;
import java.util.List;

public class EvenOddNumbers {
    public static void main(String arg[]){
        List<Integer> list= Arrays.asList(2,4,5,6,7,8,9);

       List<Integer> even=list.stream().filter(a->a%2==0)
                .toList();




        System.out.println("Even number"+even);


    }
}
