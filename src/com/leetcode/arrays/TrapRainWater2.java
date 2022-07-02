package com.leetcode.arrays;

import java.sql.Struct;
import java.util.PriorityQueue;
// TC n*m log(n*m)
public class TrapRainWater2 {
    public static void main(String[] args) {

    }
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        boolean [][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    priorityQueue.add(new Node(i, j, heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }
        int water = 0;
        while (priorityQueue.size() > 0) {
            Node block = priorityQueue.poll();
            int x = block.i;
            int y = block.j;
            int height = block.height;
            for (int [] dir : dirs) {
                int row = x + dir[0];
                int col = y + dir[1];
                if(row < 0 || col < 0 || row >= m || col >= n || visited[row][col])continue;
                visited[row][col] = true;
                if (height > heightMap[row][col]) {
                    water+= height - heightMap[row][col];
                    heightMap[row][col] = height;
                }
                priorityQueue.add(new Node(row,col,heightMap[row][col]));
            }
        }
        return water;
    }
    static class Node implements Comparable<Node>{
        int i;
        int j;
        int height;
        Node(int i,int j,int height) {
            this.i = i;
            this.j = j;
            this.height = height;
        }

        @Override
        public int compareTo(Node n) {
            return this.height-n.height;
        }
    }
}
