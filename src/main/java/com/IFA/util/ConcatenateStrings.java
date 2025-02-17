package com.IFA.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcatenateStrings {
    public static void main(String[] args) {
        List<String> list1= Arrays.asList("shashi", "pratap");
        List<String> list2= Arrays.asList("Singh");
        List<String> concatinate=new ArrayList<>(list1);
        concatinate.addAll(list2);
        System.out.println(concatinate);




    }
}
