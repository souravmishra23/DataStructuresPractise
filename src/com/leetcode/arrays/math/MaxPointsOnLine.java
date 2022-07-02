package com.leetcode.arrays.math;
// https://leetcode.com/problems/max-points-on-a-line/discuss/2061088/From-Brute-Force-to-Optimised-in-Java
public class MaxPointsOnLine {
    public static void main(String[] args) {

    }
    public static int maxPoints(int[][] points) {
        int n = points.length;
        int maxPoints = 0;
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        for (int x = 0; x < n; x++) {
            for (int y = x + 1; y < n; y++) {
                int count = 0;
                for (int i = 0; i < n; i++) {
                if (liesOn(points[x],points[y],points[i])) {
                    count ++;
                }
                }
                maxPoints = Math.max(count,maxPoints);
            }

        }
        return maxPoints;
    }
    // function which checks whether point "i"
// lies on the line created by points "a" & "b"
    private static boolean liesOn(int[] a, int[] b, int[] i) {
        // simplified from (y-y1)/(x-x1) = (y2-y1)/(x2-x1) to
        // (y-y1) * (x2-x1) = (x-x1) * (y2-y1)
        // because as we know floating values are not so accurate.
        return (i[1] - a[1]) * (a[0] - b[0]) == (i[0] - a[0]) * (a[1] - b[1]);
    }
}
