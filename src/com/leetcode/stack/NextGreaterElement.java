package com.leetcode.stack;

import java.util.Stack;
// https://leetcode.com/problems/next-greater-element-ii/
public class NextGreaterElement {
    public static void main(String[] args) {
        int [] arr = new int[]{2 ,5 ,9 ,3 ,1 ,12 ,6 ,8 ,7};
        int [] nge = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        nge[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >=0 ; i--) {
            // pop,printans,push
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nge[i] = -1;
            }else {
                nge[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        System.out.println(nextGreaterElements(new int[]{1,2,3,4,3}));
    }
    // for circular array
    public static int[] nextGreaterElements(int[] arr) {

        int[] nge = new int[arr.length];
        Stack<Integer> stack = new Stack();
        for(int i = 2*arr.length-1; i >= 0; i--) {
            int idx = i % arr.length;
            while (!stack.isEmpty() && stack.peek() <= arr[idx]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nge[idx] = -1;
            } else {
                nge[idx] = stack.peek();
            }
            stack.push(arr[idx]);
        }
        for (int i : nge)
            System.out.print(i + " ");
        return nge;
    }
}
