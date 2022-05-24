package com.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/is-subsequence/
public class IsSubsequence2 {
   // static List<String> all = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(isSubsequence("b","c"));
    }
    public static boolean isSubsequence(String s, String t) {
        List<String> all = new ArrayList<>();
        subsequence("",t,all);
        System.out.println(all);
        return all.contains(s);
    }
    static void subsequence(String p, String up, List<String> all) {
        if(up.isEmpty()) {
            all.add(p);
            return;
        }
        char ch=up.charAt(0);
        subsequence(p+ch,up.substring(1),all);
        subsequence(p,up.substring(1),all);
    }
}
