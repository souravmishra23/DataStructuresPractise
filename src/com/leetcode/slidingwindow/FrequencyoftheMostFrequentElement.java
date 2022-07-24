package com.leetcode.slidingwindow;

import java.util.Arrays;
// https://leetcode.com/problems/frequency-of-the-most-frequent-element/submissions/
public class FrequencyoftheMostFrequentElement {
    public static void main(String[] args) {
        System.out.println(maxFrequency(new int[] {1,4,8,13}, 5));
    }
    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0,right = 0;
        int total = 0,result = 0;
        while (right < nums.length) {
            total += nums[right];
            while (nums[right]*(right - left + 1) - total >  + k) { // window size (right - left + 1)

                total -= nums[left];
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}
