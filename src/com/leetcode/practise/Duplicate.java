package com.leetcode.practise;

public class Duplicate {
    public static void main(String[] args) {
        int nums[]=new int[]{1,1,1,3,3,4,3,2,4,2};
        System.out.println(Duplicate.containsDuplicate(nums));
    }
    public static boolean containsDuplicate(int[] nums) {
        boolean flag=false;
        for (int num : nums) {
            flag = isContains(num, nums);
            if (flag)
                break;
        }
        return flag;
    }
    public static boolean isContains(int value,int [] nums){
        int count=0;
        for (int num : nums) {
            if (value == num) {
                count++;
                if (count>1)
                    return true;
            }
        }
        return false;
    }
}

//Simple hashSet solution in java..........
  /*  public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)
            if(hs.contains(nums[i]))
                return true;
            else
                hs.add(nums[i]);
        return false;
    }*/