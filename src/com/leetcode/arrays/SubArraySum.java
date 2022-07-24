package com.leetcode.arrays;
// https://leetcode.com/problems/subarray-sum-equals-k/
// https://www.youtube.com/watch?v=20v8zSo2v18
import java.util.HashMap;

public class SubArraySum {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1},2));

    }
    public static int subarraySum(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // key = sum , value = frequency
        map.put(0,1);
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
