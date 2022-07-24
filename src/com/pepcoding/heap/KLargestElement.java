package com.pepcoding.heap;

import java.util.PriorityQueue;

public class KLargestElement {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 9, 1, 0};
        int k = 3;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                pq.add(arr[i]);
            } else {
                if (arr[i] > pq.peek()) {
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }
        while (pq.size() > 0) {
            System.out.print(pq.remove() + " ");
        }
    }
}
