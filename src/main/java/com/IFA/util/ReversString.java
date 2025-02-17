package com.IFA.util;

public class ReversString {
    public static void main(String args[]) {
        String str = "shashi pratap";
        String temp="";
        for (int i = 0; i <= str.length()-1; i++)
        {
            char ch=str.charAt(i);
             temp=ch+temp;
        }
        System.out.println(temp);
    }
}
