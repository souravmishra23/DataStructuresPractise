package com.pepcoding.hashMap;

import java.util.HashMap;

public class CheckIfArrayPairsAreDivisibleByK {
    public static void main(String[] args) {
        System.out.println(canArrange(new int[]{1, 2, 3, 4, 5, 10, 6, 7, 8, 9}, 5));
    }

    public static boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> remainderFreqMap = new HashMap<>();
        for (int val : arr) {
            int rem = val % k;
            if (rem < 0) rem += k; // for negative remainder

            int oldf = remainderFreqMap.getOrDefault(rem, 0);
            remainderFreqMap.put(rem, oldf + 1);
        }
        System.out.println(remainderFreqMap);
        for (int rem : remainderFreqMap.keySet()) {
            // int rem = val % k;
            if (rem == 0) {
                int freq = remainderFreqMap.get(rem);
                if (freq % 2 == 1) {
                    return false;
                }
            } else if (2 * rem == k) { // it is same as k / 2 = rem
                int freq = remainderFreqMap.get(rem);
                if (freq % 2 == 1) {
                    return false;
                }
            } else {
                int freq = remainderFreqMap.get(rem);
                int otherFreq = remainderFreqMap.getOrDefault(k - rem, 0);
                if (freq != otherFreq) {
                    return false;
                }
            }
        }
        return true;
    }
}
