package com.geeksforgeeks.graphs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class SingleSourceShortestPathProblem {
    private int V;
    private LinkedList<Integer> adj[];
    SingleSourceShortestPathProblem(int v)
    {
        V = v;
        adj=new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i]=new LinkedList<>();
        }
    }
    // Function to add an edge into the graph
    public void addEdge(int v,int w){
        adj[v].add(w);
    }

    void findShortestPath(int v){
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean visited[]=new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[v]=true;
        queue.add(v);
        while (queue.size()!=0){
            v=queue.poll();
            System.out.println(v +" ");
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext())
            {
                int n=i.next();
                if (!visited[n]){
                    visited[n]=true;
                    queue.add(n);
                    map.put(n,v);
                }
            }
        }
        System.out.println(map);
    }
    public static void main(String[] args) {
        SingleSourceShortestPathProblem g = new SingleSourceShortestPathProblem(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.findShortestPath(2);
        SingleSourceShortestPathProblem g1 = new SingleSourceShortestPathProblem(7);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 3);
        g1.addEdge(1, 6);
        g1.addEdge(2, 3);
        g1.addEdge(2, 4);
        g1.addEdge(3, 5);
        g1.addEdge(4, 5);
        g1.addEdge(5, 6);
        g1.findShortestPath(0);


    }
}
