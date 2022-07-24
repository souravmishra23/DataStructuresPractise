package com.pepcoding.hashMap;

import java.util.HashMap;
// https://leetcode.com/problems/subarray-sums-divisible-by-k/
public class SubArrayDivisibleByK {
    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5));
    }
    public static int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        // remainder and frequency.
        hmap.put(0, 1);
        int sum = 0;
        int ans = 0;
        for (int val: nums) {
            sum += val;
            int rem = sum % k;
            if (rem < 0) {
                rem += k;
            }
            if (hmap.containsKey(rem)) {
                ans += hmap.get(rem);
            }
            hmap.put(rem, hmap.getOrDefault(rem, 0) + 1);
        }
        return ans;
    }
}
