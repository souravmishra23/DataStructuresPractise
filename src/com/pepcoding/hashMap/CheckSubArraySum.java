package com.pepcoding.hashMap;

import java.util.HashMap;

public class CheckSubArraySum {
    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{23,2,4,6,7}, 6));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        // key = remainder , value = index
        hmap.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if (hmap.containsKey(rem)) {
                int startIndex = hmap.get(rem);
                int endIndex = i;
                if (endIndex - startIndex >= 2) return true;
            } else
                hmap.put(rem, i);
        }
        return false;
    }
}
