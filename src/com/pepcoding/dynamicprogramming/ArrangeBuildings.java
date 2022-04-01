package com.pepcoding.dynamicprogramming;

import java.util.Scanner;

public class ArrangeBuildings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int oldCountZeros = 1;
        int oldCountOnes = 1;
        for (int i = 2; i <= n; i++) {
            int newCountZeros = oldCountOnes;
            int newCountOnes = oldCountZeros + oldCountOnes;
            oldCountOnes = newCountOnes;
            oldCountZeros = newCountZeros;

        }
        int total = oldCountOnes + oldCountZeros;
        System.out.println(total * total);
    }
}
