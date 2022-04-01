package com.leetcode.practise;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int [] array=twoSum1(new int[]{2,7,11,15},9);
        System.out.println(array.length);
    }
    public static int[] twoSum(int[] nums, int target) {

        //Time complexity O(n^2)
        for (int i=0;i< nums.length;i++){
            for (int j=i+1;j< nums.length;j++){
                if (nums[i]+nums[j]==target){
                    System.out.println(+i+"   "+j);
                    break;
                }
            }
        }
        return new int[]{0,1};
    }
    public static  int[] twoSum1(int[] nums, int target) {
        //TimeComplexity O(n)
        HashMap<Integer,Integer> numsMap=new HashMap();
        for(int i=0;i<nums.length;i++){
            int compliment = target - nums[i];
            if(numsMap.containsKey(compliment)){
                System.out.println(numsMap.get(compliment));
                return new int[]{numsMap.get(compliment),i};
            }
            else{
                numsMap.put(nums[i],i);
            }
        }
        return new int[]{};

    }
}
