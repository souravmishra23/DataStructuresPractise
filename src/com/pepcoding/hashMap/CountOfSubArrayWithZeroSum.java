package com.pepcoding.hashMap;

import java.util.HashMap;

public class CountOfSubArrayWithZeroSum {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{15 ,-2 ,2 ,-8 ,1 ,7 ,10 ,23}));
    }
    public static int solution(int[] arr) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        // key sum, value = frequency;
        int count = 0;
        int sum = 0;
        hmap.put(0, 1);
        for (int val: arr) {
            sum += val;
            if (hmap.containsKey(sum)) {
                count += hmap.get(sum);
            }
            hmap.put(sum, hmap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}
