package com.pepcoding.recursion;

public class Subset {
    public static void main(String[] args) {
        // Mathematically the ans is 2 to power of no of elements for example for 1,2,3 ans is 2 to power of 3
        // which is 8
        printSubset(new int[]{1,2,3},0,new int[]{1,2,3}.length,"");
    }
    static void printSubset(int [] arr,int i,int n,String osf){
        if (i==n){
            System.out.println("["+osf+"]");
            return;
        }
        // here first take the first element and attach it to output
        printSubset(arr,i+1,n,osf+ arr[i] +",");
        // here first take the first element and dont attach it to output
        printSubset(arr,i+1,n,osf);
    }
}
