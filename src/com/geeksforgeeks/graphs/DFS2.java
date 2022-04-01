package com.geeksforgeeks.graphs;

import java.util.ArrayList;

public class DFS2 {
    public static void main(String[] args) {

    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean visited[]=new boolean[V];
        DFUtil(0,visited,adj);
        return null;

    }
    void DFUtil(int v, boolean visited[], ArrayList<ArrayList<Integer>> adj){
        visited[v] = true;
        System.out.print(v + " ");
        ArrayList<Integer> list = adj.get(v);
        for(int v1: list){
            int n = v1;
            if (!visited[n])
                DFUtil(n, visited,adj);
        }

    }
}
