package com.IFA.util;

import java.util.Arrays;
import java.util.List;

public class RemoveDuplicateList {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 10, 3, 4, 5,6,7, 6, 7);

        List<Integer> removedDuplicates=  list.stream().distinct().toList();
        System.out.println(removedDuplicates);


    }
}
