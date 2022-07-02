package com.leetcode.arrays;

public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
        productExceptSelf(new int[]{-1,1,0,-3,3});
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            if (i > 0) {
                for (int j = 0; j < i; j++) {
                    product = product * nums[j];
                }
            }
            for (int j = i + 1; j < nums.length; j++) {
                product = product * nums[j];
            }
            ans[i] = product;
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
        return ans;
    }
}
