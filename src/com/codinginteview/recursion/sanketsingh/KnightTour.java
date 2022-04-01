package com.codinginteview.recursion.sanketsingh;

import java.util.Scanner;

public class KnightTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = -1;
            }
        }
        boolean[][] visited = new boolean[n][n];
        knightstour(grid,n,0,0,0,visited);
    }

    static void knightstour(int[][] grid, int n, int i, int j, int count, boolean[][] visited) {
        if (count == (n * n) - 1) {
            grid[i][j] = count;
            //display(grid,n);
            System.out.println(count);
            return;
        }
        if (count == n * n) {
            return;
        }
        int xdir[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int ydir[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
        visited[i][j] = true;
        grid[i][j] = count;
        for (int k = 0; k < 8; k++) {
            if (isItSafe(grid, n, i + xdir[k], j + ydir[k], visited)) {
                knightstour(grid, n, i + xdir[k], j + ydir[k], count+1, visited);
            }
        }
        grid[i][j] = -1;
        visited[i][j] = false;
    }

    static boolean isItSafe(int[][] grid, int n, int i, int j, boolean[][] visited) {
        return i >= 0 && j >= 0 && i < n && j < n && visited[i][j] == false;
    }
    static void display(int [][] grid,int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] +" ");
            }
        }
    }
}
