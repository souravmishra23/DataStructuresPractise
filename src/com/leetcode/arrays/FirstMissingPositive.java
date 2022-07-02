package com.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
    }
    public static int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max =0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            set.add(num);
        }
        for (int i = 1; i < max; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return max + 1;
     }
}
