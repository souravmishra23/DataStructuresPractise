package com.codinginteview.recursion.sanketsingh;

import java.util.Scanner;
// video link sanket singh
// https://unacademy.com/class/backtracking-deep-dive-part-1/T10BA9S6
// problem link..
// https://www.codechef.com/problems/BPHC03
// Sample Input
/*      7
        0 0 1 0 0 1 0
        1 0 1 1 0 0 0
        0 0 0 0 1 0 1
        1 0 1 0 0 0 0
        1 0 1 1 0 1 0
        1 0 0 0 0 1 0
        1 1 1 1 0 0 0 */
// 1.30 hr in video lecture.
// time complexity is O(3^(n^2 - (4n-4)) x 2^(4n-4))...
public class MazeProblem {
    static int totalPaths = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int [][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(solveMaze(grid));
    }

    static int solveMaze(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid.length];
        helper(grid, visited, 0, 0, grid.length);
        return totalPaths;
    }

    private static void helper(int[][] grid, boolean[][] visited, int i, int j, int n) {
        if (i == n - 1 && j == n - 1) {
            totalPaths++;
            return;
        }
        if (!isItSafe(i, j, n, visited)) {
            return;
        }
        visited[i][j] = true;
        if (i + 1 < n && grid[i + 1][j] == 0) { // down
            helper(grid, visited, i + 1, j, n);
        }
        if (i - 1 >= 0 && grid[i - 1][j] == 0) { // up
            helper(grid, visited, i - 1, j, n);
        }
        if (j + 1 < n && grid[i][j + 1] == 0) { // right
            helper(grid, visited, i, j + 1, n);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 0) { // left
            helper(grid, visited, i, j - 1, n);
        }
        visited[i][j] = false;  /// backtracking done here..
        return;
    }

    private static boolean isItSafe(int i, int j, int n, boolean[][] visited) {
        return i >= 0 && j >= 0 && i < n && j < n && !visited[i][j];
    }
}
