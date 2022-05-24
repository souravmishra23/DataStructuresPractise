package com.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/container-with-most-water/submissions/
public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    public static int maxArea(int[] height) {
        int leftPtr = 0;
        int rightPtr = height.length - 1;

        int maxArea = 0;

        while(leftPtr < rightPtr) {
            int leftHeight = height[leftPtr];
            int rightHeight = height[rightPtr];

            int minHeight = Math.min(leftHeight, rightHeight);
            int width = rightPtr - leftPtr;

            int currentArea = minHeight * width;

            maxArea = Math.max(maxArea, currentArea);

            if(leftHeight > rightHeight) rightPtr--;
            else if(leftHeight < rightHeight) leftPtr++;
            else {
                rightPtr--;
                leftPtr++;
            }

        }

        return maxArea;
    }
}
