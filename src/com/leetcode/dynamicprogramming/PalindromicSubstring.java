package com.leetcode.dynamicprogramming;
// https://leetcode.com/problems/palindromic-substrings/
public class PalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(countSubstrings("aab"));
    }

    public static int countSubstrings(String s) {
        int count = 0;

        //First of all we create a 2-D boolean DP array and fill true on all the pallindromic substrings.

        //This array is filled using "Gap Strategy" or diagonal traversal.
        boolean[][] dp1 = new boolean[s.length()][s.length()];
        for (int g = 0; g < dp1.length; g++) {
            for (int i = 0, j = g; j < dp1.length; i++, j++) {
// for single char 'a' which is always a substring of itself..
                if (g == 0) {
                    dp1[i][j] = true;
                    count++;
                } else if (g == 1) { // for double char 'ab' ..
                    if (s.charAt(i) == s.charAt(j)) {
                        dp1[i][j] = true;
                        count++;
                    }
                } else { // more than two char
                    if (s.charAt(i) == s.charAt(j)) {
                        if (dp1[i + 1][j - 1] == true) {
                            dp1[i][j] = true;
                            count++;
                        }
                    } else {
                        dp1[i][j] = false;

                    }
                }

            }
        }

        return count;
    }
}
