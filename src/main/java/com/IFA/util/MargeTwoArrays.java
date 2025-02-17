package com.IFA.util;

public class MargeTwoArrays {
    public static void main(String[] args) {
        int [] arr1={1,2,3,4,5};

        int [] arr2 ={10,11,12,14};

        int [] arr3=new int[arr1.length+arr2.length];

        System.arraycopy(arr1,0,arr3,0,arr1.length);

        System.arraycopy(arr2,0,arr3,arr1.length,arr2.length);

        for (int i = 0; i < arr3.length; i++) {
            System.out.println(arr3[i]);
        }
    }
}
