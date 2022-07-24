package com.pepcoding.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQ {
    public static void main(String[] args) {
        // priority q with naturally smallest element at the peek..
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int [] arr = {3,1,5,6,7};
        for (int val: arr) {
            pq.add(val); // takes log(n) time for this operations
        } // overall nlog(n)..
        int i = 0;
        // gives output in sorted order..
        while (i < arr.length) {
            System.out.print(pq.peek() + " "); // O(1) complexity.
            pq.remove(); // log(n) complexity.
            i++;
        }
        // priority q with naturally largest element at the peek..
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
    }
}
