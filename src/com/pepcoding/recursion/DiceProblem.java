package com.pepcoding.recursion;

// this problem is from recursion video part 3 on youtube by sanket singh..
public class DiceProblem {
    public static void main(String[] args) {
        dicePath(4,0,"");
    }

    static void dicePath(int n, int i, String osf) {
        if (i >= n) return;
        if (i == n - 1) {
            System.out.println(osf);
            return;
        }
        for (int j = 1; j <= 6; j++) {
            dicePath(n,i+j,osf+j);
        }
    }
}
