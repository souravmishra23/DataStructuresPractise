package com.leetcode.slidingwindow;

import java.util.HashMap;

public class CountNumberofNiceSubarrays {
    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{1,1,2,1,1}, 3));
    }
    public static int numberOfSubarrays(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                nums[i] = 1;
            }else {
                nums[i] = 0;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        // key = sum , value = frequency
        map.put(0,1);
        int ans = 0;
        int sum = 0;
        for (int n : nums) {
            sum += n;
            int remainingSum = sum - k;
            if (map.containsKey(remainingSum)) {
                ans += map.get(remainingSum);
            }
            map.put(sum,map.getOrDefault(sum,0) + 1);
        }
        return ans;
    }


}
