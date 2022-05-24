package com.leetcode.dynamicprogramming;
// https://leetcode.com/problems/arithmetic-slices/
public class ArithmeticSlices {
    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[] {1,2,3,4}));
    }
    public static int numberOfArithmeticSlices(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            int elements = 1;
            int diff = nums[i] - nums[i - 1];
            for (int j = i; j < nums.length; j++) {

                if (nums[j] - nums[j - 1] == diff) {
                    elements++;
                    if (elements >= 3) {
                        count++;
                    }
                }
                else {
                    break;
                }
            }

        }
        return count;
    }
}
