package com.pepcoding.hashMap;

import com.pepcoding.heap.PriorityQ;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    }
    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int val: nums) {
            if (hmap.containsKey(val)) {
                int of = hmap.get(val);
                hmap.put(val, of + 1);
            } else
                hmap.put(val, 1);
        }
        // make a priority queue but it is dependent on the hashmap entries
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->hmap.get(b)-hmap.get(a));

        q.addAll(hmap.keySet()); // this adds all the keys of hashmap to queue

        // add everything to the result array
        int[] result = new int[k];

        int i =0;
        while(!q.isEmpty() && k>0){
            result[i++] = q.poll();
            k--;
        }

        return result;
    }

}
