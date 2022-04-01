package com.pepcoding.recursion;

import java.util.Scanner;

// https://nados.io/question/print-zigzag
// important link to understand recursion
public class PrintZigZag {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        printZigZag(n);
    }
    static void printZigZag(int n){
        if (n==0){
            return;
        }
        System.out.print(n + " ");
        printZigZag(n-1);
        System.out.print(n + " ");
        printZigZag(n-1);
        System.out.print(n + " ");
    }
}
