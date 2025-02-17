package com.IFA.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShortList {
    public static void main(String[] arg)
    {
        List<Integer> list= Arrays.asList(1,10,3,4,5,6,7);
        List<Integer> listDescendingOrder =list.stream().sorted((a,b)->b-a).collect(Collectors.toList());
        System.out.println(listDescendingOrder);



    }
}
