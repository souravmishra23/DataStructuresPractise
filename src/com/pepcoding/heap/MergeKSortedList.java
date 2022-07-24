package com.pepcoding.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedList {
    public static class Pair implements Comparable<Pair> {
        int listIndex;
        int dataIndex;
        int val;

        public Pair(int listIndex, int dataIndex, int val) {
            this.listIndex = listIndex;
            this.dataIndex = dataIndex;
            this.val = val;
        }

        @Override
        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < k; i++){
            ArrayList<Integer> list = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                list.add(Integer.parseInt(elements[j]));
            }

            lists.add(list);
        }

        ArrayList<Integer> mlist = mergeKSortedLists(lists);
        for(int val: mlist){
            System.out.print(val + " ");
        }
        System.out.println();
    }
    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> rv = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < lists.size(); i++) {
            Pair p = new Pair(i, 0, lists.get(i).get(0));
            pq.add(p);
        }
        while (!pq.isEmpty()) {
            Pair rem = pq.remove();
            rv.add(rem.val);
            rem.dataIndex++;
           if (rem.dataIndex < lists.get(rem.listIndex).size()) {
               rem.val = lists.get(rem.listIndex).get(rem.dataIndex);
               pq.add(rem);
           }
        }

        return rv;
    }
}
