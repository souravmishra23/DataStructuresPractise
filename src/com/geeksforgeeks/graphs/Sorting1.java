package com.geeksforgeeks.graphs;

public class Sorting1 {
    public static void main(String[] args) {
        int a[]=new int[]{3,1,0,8};
        for (int i = 0; i < a.length; i++) {
            for (int j=i+1;j<a.length;j++) {
                if (a[i] < a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]+" ");
        }


    }
}
