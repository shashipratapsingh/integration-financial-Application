package com.IFA.util;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SecondHeightNumber {
    public static void main(String arg[])
    {
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7);// 56

       Optional<Integer> optional= list.stream().distinct().sorted((a, b)->b-a).skip(1).findFirst();

        Integer number=optional.get();
        System.out.println(number);

    }
}
