package com.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.Stack;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        System.out.println(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        int [] nge = nextGreaterElements(nums);
        for (int i = 0; i <= nums.length - k; i++) {
            int j = i;
            while (nge[j] < i + k) {
                j = nge[j];
            }
            ans.add(nums[j]);
        }
        int [] res = new int[ans.size()];
        for (Integer i : ans) {
            res[i] = ans.get(i);
        }
        System.out.println(ans);
        return new int[]{};
    }
    public static int[] nextGreaterElements(int[] arr) {
        int [] nge = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        nge[arr.length - 1] = arr.length;
        stack.push(arr.length - 1);
        for (int i = arr.length - 2;i >= 0;i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nge[i] = arr.length;
            }else {
                nge[i] = stack.peek();
            }
            stack.push(i);
         }
        return nge;
    }
}
