package com.geeksforgeeks.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class TopoLogicalSort {
    private int V;

    // Adjacency List as ArrayList of ArrayList's
    private ArrayList<ArrayList<Integer>> adj;

    TopoLogicalSort(int v)
    {
        V = v;
        adj = new ArrayList<ArrayList<Integer> >(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<Integer>());
    }
    // Function to add an edge into the graph
    void addEdge(int v, int w) { adj.get(v).add(w); }
    void topologicalSort(){
        Stack<Integer> stack=new Stack<>();
        boolean visited[]=new boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i]=false;
        }
        for (int i = 0; i < V; i++) {
            if (visited[i]==false){
                topologicalUtil(i,visited,stack);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        // Print contents of stack
        while (stack.empty() == false){
            int top = stack.peek();
            ans.add(top);
            stack.pop();
           // System.out.print(stack.pop() + " ");
            }
        System.out.println("ans=="+ans);

    }

    private void topologicalUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v]=true;
        Integer i;
        // Recur for all the vertices adjacent
        // to thisvertex
        Iterator<Integer> it = adj.get(v).iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i])
                topologicalUtil(i, visited, stack);
        }

        // Push current vertex to stack
        // which stores result
        stack.push(v);
    }

    public static void main(String[] args) {
        TopoLogicalSort g = new TopoLogicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological "
                + "sort of the given graph");
        // Function Call
        g.topologicalSort();
    }
}
