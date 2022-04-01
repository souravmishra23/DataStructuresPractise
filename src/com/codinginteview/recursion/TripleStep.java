package com.codinginteview.recursion;

public class TripleStep {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(countWays(6));
    }

    static int countWays(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else
            return countWays(n - 3) + countWays(n - 2) + countWays(n - 1);
    }
}
