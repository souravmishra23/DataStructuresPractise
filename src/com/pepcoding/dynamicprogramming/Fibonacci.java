package com.pepcoding.dynamicprogramming;
// https://www.youtube.com/watch?v=94dfRrDANRY&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=1&t=10s
public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;
       // System.out.println(fib(n));
        System.out.println(fibMemoized(n,new int[n+1]));
    }
    static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int fibnm1 = fib(n-1);
        int fibnm2 = fib(n-2);
        int fibn = fibnm1 + fibnm2;
        return fibn;
     }
// dynamic programming is the way to optimize the solution by reducing the time complexity of the solution.
// same problem bar bar solve ho rahi hai..
// neeche ate hue solve ho rahi hai problem..
    static int fibMemoized(int n,int [] qb) {
        if (n == 0 || n == 1) {
            return n;
        }
        // here we check if the answer is present we directly return that ans.
        if (qb[n] != 0) {
            return qb[n];
        }
        int fibnm1 = fibMemoized(n-1,qb);
        int fibnm2 = fibMemoized(n-2,qb);
        int fibn = fibnm1 + fibnm2;
        // here we store the answer into the array so that repeated calls  are not made..
        qb[n] = fibn;
        return fibn;
    }
}
