package com.pepcoding.hashMap;

import java.util.HashMap;
import java.util.Scanner;
// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/largest-subarray-with-zero-sum-official/ojquestion
public class LargestSubArrayWithZeroSum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }
    public static int solution(int[] arr) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        // key sum, value = index;
        int i = -1;
        int sum = 0;
        hmap.put(sum, i);
        int max = 0;
        while (i < arr.length - 1) {
            i++;
            sum += arr[i];
            if (hmap.containsKey(sum) == false) {
                hmap.put(sum, i);
            }
            else   {
                int index = i - hmap.get(sum);
                if (index > max) max = index;
            }

        }
        return max;
    }
}
