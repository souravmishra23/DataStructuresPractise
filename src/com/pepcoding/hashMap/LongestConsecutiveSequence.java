package com.pepcoding.hashMap;


import java.util.Arrays;
import java.util.HashMap;
// https://leetcode.com/problems/longest-consecutive-sequence/submissions/
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1,2,0,1}));
    }
    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> hmap = new HashMap<>();
        for (int val : nums) {
            hmap.put(val, true);
        }

        for (int val : nums) {
            if (hmap.containsKey(val - 1)) {
                hmap.put(val, false);
            }
        }
        System.out.println(hmap);
        int max = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (hmap.get(nums[i]) == true) {
                int element = nums[i];
                int count = 0;
                while (hmap.containsKey(element++)) {
                    count++;
                }
                if (count > max) max = count;
            }
        }
        return max;
    }
}

