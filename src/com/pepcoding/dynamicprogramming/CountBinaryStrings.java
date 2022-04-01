package com.pepcoding.dynamicprogramming;

import java.util.Scanner;
// https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/count-binary-strings-official/ojquestion
public class CountBinaryStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // storing the count of binary string ending with 0
        int[] dp0 = new int[n + 1];
        // storing the count of binary string ending with 0
        int[] dp1 = new int[n + 1];
        dp0[1] = 1;
        dp1[1] = 1;
        for (int i = 2; i < dp0.length; i++) {
            dp0[i] = dp1[i -1];
            dp1[i] = dp0[i-1] + dp1[i-1];
        }
        System.out.println(dp0[n] + dp1[n]);
        /* other soltuion can be
        int oldCountZeros = 1
        int oldCountOnes = 1
         for (int i = 2; i < dp0.length; i++) {
           int newCountZeros = oldCountOnes;
           int newCountOnes =  oldCountZeros + oldCountOnes;
           oldCountOnes = newCountOnes;
           oldCountZeros = newCountZeros;

        }
        * */
    }

}
