package com.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/word-break/
// https://leetcode.com/problems/word-break/discuss/1172343/Java-Solution-99-faster-90-less-space-memoization
public class WordBreak_HashMapSolution {
    public static void main(String[] args) {
        wordBreak();
    }

    private static boolean wordBreak() {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        String s = "applepenapple";
        // for memoization
        HashMap<String,Boolean> map= new HashMap<>();
        return canConstruct(s, wordDict, map);
    }

    public static boolean canConstruct(String target,List<String> words, HashMap<String,Boolean> map) {

        // if answer already cached, return it
        if(map.containsKey(target))
            return map.get(target);

        // if target string is empty
        // it can always be constructed by taking no elements from dictionary
        if(target.isEmpty())
            return true;

        // for all words in the dictionary
        for(String word: words)
        {
            // if the target starts with the given word
            if(target.startsWith(word))
            {
                // and it is possible to construct the rest of the string
                // from the words in the dictionary
                if(canConstruct(target.substring(word.length()),words, map))
                {

                    // save and return true
                    map.put(target, true);
                    return true;
                }
            }
        }

        // if it was not possible to construct the target from words from the dictionary
        // save and return false to the previous call
        map.put(target,false);
        return false;
    }
}
