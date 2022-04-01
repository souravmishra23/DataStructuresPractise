package com.codinginteview.recursion.sanketsingh;

import java.util.ArrayList;
import java.util.Stack;

public class SubSet {
    public static void main(String[] args) {
        //ArrayList<Integer> temp=new ArrayList<>();
        Stack<Integer> temp = new Stack<>();
        subsetBacktrack(new int[]{1,2,3},temp,0,new int[]{1,2,3}.length);

    }
    static void subsetBacktrack(int arr[], Stack<Integer> temp ,int i, int n) {
        if (i == n) {
            System.out.println(temp);
            return;
        }
        temp.push(arr[i]);
        subsetBacktrack(arr,temp,i+1,n);
        temp.pop();
        subsetBacktrack(arr,temp,i+1,n);
    }
}
