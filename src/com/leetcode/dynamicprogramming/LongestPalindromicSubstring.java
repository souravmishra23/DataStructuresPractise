package com.leetcode.dynamicprogramming;
/*The idea is that we will store the info whether the substring from index i to index j is palindrome or not in a dp table
So the row correspond to start index of substring and column corresponds to the end index.

For eg: Consider the string babad. We know that the string aba is palindrome. The start and end indices are 1 & 3 respectively. Thus dp[1][3] = true.

Now that we have the basis set on what would be the rows and columns of the table, we know that a single character is always palindrome. Thus dp[i][i] will always be true. This means the string starting from index i and ending at index i is always true since its just a character.

We also fill the dp[i][i+1] as true if charAt(i)==charAt(i+1). This takes care of the scenario for a substring of length 2. This ensures now if the charAt(i)==charAt(j) we just have to check if the substring excluding ith and jth character was a substring.

Now because of the above approach the order of filling the dp table has to be such that we fill data for all substrings of length 1, then 2, then 3 and so on.

Thus we will have to traverse the dp table diagonally. Which makes us concerned with only the upper half of the table starting from dp[0][3].*/
// https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaaa"));
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int start = 0;
        int end = 0;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            if (i + 1 < len) {
                dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
                if (dp[i][i + 1]) {
                    start = i;
                    end = i + 1;
                }
            }
        }
        for (int j = 2; j < len; j++) {
            for (int i = 0; i < len; i++) {
                if (j - i > 1) {
                    if (s.charAt(i) != s.charAt(j)) {
                        dp[i][j] = false;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                        if (dp[i + 1][j - 1]) {
                            if (end-start < j - i) {
                                end = j;
                                start = i;
                            }
                        }
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
