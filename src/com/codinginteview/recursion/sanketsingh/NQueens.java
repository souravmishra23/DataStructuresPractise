package com.codinginteview.recursion.sanketsingh;

import java.util.Scanner;
// https://unacademy.com/class/backtracking-deep-dive-part-2/E7CFJENM
// Space Complexity == > O(n^2)
// Time Complexity == > O(n!)
public class NQueens {
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        boolean [][] grid = new boolean[n][n];
        countNQueen(grid,0,n);
        System.out.println(count);
    }
    static void countNQueen(boolean [][] grid,int curr_row,int n) {
        if (curr_row == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isItSafe(grid,curr_row,i)) {
                grid[curr_row][i] = true;
                countNQueen(grid,curr_row + 1,n);
                grid[curr_row][i] = false;
            }
        }
    }
    static boolean isItSafe(boolean[][] chess, int row, int col) {
        for (int i = row - 1, j = col; i >= 0; i--) {
            if (chess[i][j]==true){
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j]==true){
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j]==true){
                return false;
            }
        }
        return true;
    }
}
