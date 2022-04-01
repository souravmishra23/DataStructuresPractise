package com.geeksforgeeks.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfIslands {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine().trim());
        while (T --> 0){
            String [] s=br.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int m=Integer.parseInt(s[1]);
            char [][] grid=new char[n][m];
            for (int i = 0; i < n; i++) {
                String [] S=br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j]=S[j].charAt(0);
                }
            }
            NumberOfIslands obj=new NumberOfIslands();
            int ans= obj.numIslands(grid);
        }
    }
    public int numIslands(char[][] grid) {
        // Code here
        int count=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j=0;j<grid[i].length;j++){
                if (grid[i][j]=='0')
                    continue;
                DFS(grid,i,j);
                count++;
            }

        }
        return count;
    }
    void DFS(char [][] A,int i,int j){
        if(i==A.length || j==A[i].length || i<0 || j<0) // boundary conditions...
        return;
        if(A[i][j]=='0') // water...
            return;
        A[i][j]='0'; // marked as visited...
        DFS(A,i+1,j);
        DFS(A,i,j+1);
        DFS(A,i-1,j);
        DFS(A,i,j-1);
        DFS(A,i-1,j-1);
        DFS(A,i+1,j+1);
        DFS(A,i-1,j+1);
        DFS(A,i+1,j-1);
    }
}
