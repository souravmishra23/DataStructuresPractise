package com.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/word-break/
public class WordBreak {
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        wordBreak("applepenapple", wordDict);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        // i is the end index of the word and j is the start index eg "pen" in "applepenapple" => i =7 & j =5
        // important logic to get all the substring from a string..
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                String check = s.substring(j, i + 1);
                if (wordDict.contains(check)) {
                    if (j > 0) {
                        dp[i] += dp[j - 1];
                    } else {
                        dp[i] += 1;
                    }


                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        //System.out.print(dp[s.length()-1]);
        return dp[s.length() - 1] > 0;

    }
}
