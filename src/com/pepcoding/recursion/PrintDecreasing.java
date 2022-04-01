package com.pepcoding.recursion;

public class PrintDecreasing {
    public static void main(String[] args) {
        printDec(5);
    }
    static void printDec(int n){
        if (n==1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printDec(n-1);
    }
}
