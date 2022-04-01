package com.pepcoding.recursion;

import java.util.Scanner;
// https://nados.io/question/josephus-problem
public class JosephusProblem {
    public static int solution(int n, int k){
        //write your code here
        if (n==0){
            return 0;
        }
        int x = solution(n-1,k);
        int y = (x+k) % n;
        return y;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        System.out.println(solution(n,k));
    }

}