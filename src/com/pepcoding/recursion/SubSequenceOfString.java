package com.pepcoding.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class SubSequenceOfString {
    static ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        subSequence(str, 0, str.length(), "");
        System.out.println(result);
    }

    static void subSequence(String str, int i, int n, String osf) {
        if (i == n) {

            result.add(osf);

            return;
        }
        // here first take the first element and dont attach it to output
        subSequence(str, i + 1, n, osf);
        // here first take the first element and attach it to output
        subSequence(str, i + 1, n, osf + str.charAt(i));


    }
}
