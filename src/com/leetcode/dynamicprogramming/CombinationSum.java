package com.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7},7));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Stack<Integer> ls = new Stack<>();  // our inside list to store different combinations
        int index = 0; // starting from index 0
        combSum(index,ans,candidates,target,ls,0); // recursive function
        return ans;
    }
    static void combSum(int i, List<List<Integer>> ans, int[] a, int target, Stack<Integer> ds, int total) {
        if (total == target) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        if (i >= a.length || total > target) {
            return;
        }
        ds.push(a[i]);
        combSum(i,ans,a,target,ds,total + a[i]);
        ds.pop();
        combSum(i + 1,ans,a,target,ds,total);
    }

}
