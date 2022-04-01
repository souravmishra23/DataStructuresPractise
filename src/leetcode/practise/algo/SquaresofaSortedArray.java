package leetcode.practise.algo;

import java.util.Arrays;

public class SquaresofaSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7,-3,2,3,11})));
    }
    public static int[] sortedSquares(int[] nums) {
        //brute force approach
        int [] result=new int[nums.length];
        for (int i=0;i< nums.length;i++){
            result[i]=nums[i]*nums[i];
        }
        Arrays.sort(result);
        return (result);
    }
    public int[] sortedSquares1(int[] nums) {
        // Classic two pointer approach
        int l=0, r=nums.length-1, idx=nums.length-1;
        int[] res= new int[nums.length];
        while(l<=r){

            if(Math.abs(nums[l])>Math.abs(nums[r])){
                res[idx]=nums[l]*nums[l];
                l++;
            }
            else {
                res[idx]=nums[r]*nums[r];
                r--;
            }
            idx--;
        }
        return res;
    }
}
