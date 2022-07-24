package com.pepcoding.hashMap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
// https://www.youtube.com/watch?v=U33blOQRaJ0
// https://leetcode.com/problems/reconstruct-itinerary/
public class ReconstructIternary2 {
    public static void main(String[] args) {

    }

   static HashMap<String, PriorityQueue<String>> graph;
    // taking linked list because its time is O(1) to add..
   static LinkedList<String> ans;
    public static List<String> findItinerary(List<List<String>> tickets) {
        graph = new HashMap<>();
        ans = new LinkedList<>();
        for (List<String> ticket: tickets) {
            // fetching the existing the neighbors if present
            // if not then initialize it with new PriorityQueue and add neighbor
            PriorityQueue<String> temp = graph.getOrDefault(ticket.get(0), new PriorityQueue<>());
            temp.add(ticket.get(1));
            graph.put(ticket.get(0), temp);


        }
        dfs("JFK");
        return ans;
    }

    private static void dfs(String src) {
        // fetching neighbors of src
        PriorityQueue<String> nbrs = graph.get(src);
        while (nbrs != null && nbrs.size() > 0) {
            String nbr = nbrs.remove();
            dfs(nbr);
        }
        ans.addFirst(src);
    }
}
