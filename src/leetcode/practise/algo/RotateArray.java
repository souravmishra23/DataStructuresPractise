package leetcode.practise.algo;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        rotate(new int[]{-1,-100,3,99},2);
    }
    public static void rotate(int[] nums, int k) {
        int[] result =new int[nums.length];
        int m =0;
        int l=k;
        int t=0;
        int i = nums.length-k;
        for (int b = 0; b < nums.length; b++) {
            if (i< nums.length) {
                result[m] = nums[i];
            }
            if (l<nums.length) {
                result[l] = nums[t];
            }
            m++;
            l++;
            t++;
            i++;
        }
        System.out.println(Arrays.toString(result));
    }
    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        int t = k%len; // you see, after len numbers of rotation , the array become the same , that's why we are taking reminder
        // so we need to move t numbers from the last of nums array to the beginnings, that's it

        // reverse whole array
        reverse(nums, 0, len-1);
        // reverse t numbers from beginning
        reverse(nums, 0, t-1);
        // reverse rest len-t numbers
        reverse(nums, t , len-1);

    }

    public void reverse(int nums[], int start , int end){
        while(start<end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            end--;
            start++;
        }
    }
}

