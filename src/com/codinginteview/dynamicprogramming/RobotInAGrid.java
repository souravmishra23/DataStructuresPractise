package com.codinginteview.dynamicprogramming;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class RobotInAGrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean [][] maze = new boolean[n][n];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                int i1 = sc.nextInt();
                if (i1 == 1) {
                    maze[i][j] = false;
                }else
                    maze[i][j] = true;
            }
        }
        System.out.println(getPath(maze));
    }

   static ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) {
            return null;
        }
        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> failedPoints = new HashSet<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
            return path;
        }
        return null;
    }

    static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
        /* if out of bound or not available*/
        if (col < 0 || row < 0 || !maze[row][col]) {
            return false;
        }
        Point p = new Point(row, col);

        /*if we have already visited return */
        if (failedPoints.contains(p)) {
            return false;
        }
        boolean isAtOrigin = (row == 0) && (col == 0);
        /*if there is a path from start to my current location, add my location*/
        if (isAtOrigin || getPath(maze, row, col - 1, path, failedPoints) ||
                getPath(maze, row - 1, col, path, failedPoints)) {
            path.add(p);
            return true;
        }
        failedPoints.add(p);
        return false;

    }
}
