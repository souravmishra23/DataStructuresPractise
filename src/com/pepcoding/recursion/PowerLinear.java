package com.pepcoding.recursion;

import java.util.Scanner;

public class PowerLinear {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int n= sc.nextInt();
        System.out.println(power(x,n));
        System.out.println(power1(x,n));
    }

    // this has Time Complexity of O(n) & Space Complexity of O(n)
    public static int power(int x,int n){
        if (n==1){
            return x;
        }
        return x*power(x,n-1);
    }
    // this has Time Complexity of O(log2(n)) & Space Complexity of O(log2(n))
    public static int power1(int x,int n){
        if (n==0){
            return 0;
        }
        if (n==1){
            return x;
        }
        int temp=power1(x,n/2);
        if (n % 2==0){
            return temp*temp;
        }
        else
            return x*temp*temp;
    }

    // if temp would have been replaced by all the recursive calls then complexity would have been O(N)
    // as so many recursive calls would have been made
    /*   int temp=power1(x,n/2);
        if (n % 2==0){
            return power1(x,n/2)*power1(x,n/2);
        }
        else
            return x*power1(x,n/2)*power1(x,n/2);
    }*/
}
