package com.pepcoding.hashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/count-distinct-elements-in-every-window-of-size-k-official/ojquestion
public class DistinctELementsInWindowSizeK {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        ArrayList<Integer> ans = solution(arr,k);
        for(int a : ans){
            System.out.print(a + " ");
        }
    }
    public static ArrayList<Integer> solution(int[] arr, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < k - 1; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }
        for (int j = 0, i = k - 1;i < arr.length;) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1); // acquire
            ans.add(hashMap.size()); // work
            int freq = hashMap.get(arr[j]); // release
            if (freq == 1) {
                hashMap.remove(arr[j]);
            }else {
                hashMap.put(arr[j], freq - 1);
            }
            i++;
            j++;
        }
        return ans;
    }
}
