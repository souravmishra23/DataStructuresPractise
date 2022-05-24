package com.leetcode.dynamicprogramming;
// https://leetcode.com/problems/trapping-rain-water/
// https://www.youtube.com/watch?v=ZI2z5pq0TqA
public class TrappingRainWater {
    public static void main(String[] args) {
        trap(new int[]{4,2,0,3,2,5});
    }
    public static int trap(int[] height) {
        int n = height.length;
        int [] maxLeft = new int[n];
        int [] maxRight = new int[n];
        maxLeft[0] = 0;
        // calculating the max height to every element on the left side
        int prevmax = maxLeft[0];
        for (int i = 0; i < maxLeft.length; i++) {
            maxLeft[i] = prevmax;
            if (height[i] > prevmax) {
                prevmax = height[i];
            }
        }
        /*for (int i = 0; i < maxLeft.length; i++) {
            System.out.print(maxLeft[i] + " ");
        }*/
        // calculating the max height to every element on the right side
        maxRight[n -1] = 0;
        int rightMax = maxRight[n -1];
        for (int i = n-1; i >= 0; i--) {
            maxRight[i] = rightMax;
            if (height[i] > rightMax) {
                rightMax = height[i];
            }

        }
        // taking the min of the height that is the amount of water that can be trapped..minus the block height
        int total = 0;
        for (int i = 0; i < height.length; i++) {
            int i1 = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (i1 > 0)
                total = total + i1;
        }
        System.out.println(total);
        return total;
    }
}
