package com.pepcoding.recursion;
// this is the problem from recursion video part-3 by Sanket Singh on youtube...
public class MazeProblem {
    static int totalPaths;
    public static void main(String[] args) {
        solveMaze(0,0,3,7,"");
        System.out.println("total paths="+totalPaths);
    }
    static void solveMaze(int i,int j,int n,int m,String osf){
        if (i==n-1 && j==m-1){
            totalPaths+=1;
            System.out.println(osf);
            return;
        }
        if (i>=n || j>=m){
            return;
        }
        solveMaze(i,j+1,n,m,osf+"R");
        solveMaze(i+1,j,n,m,osf+"D");
    }
}
