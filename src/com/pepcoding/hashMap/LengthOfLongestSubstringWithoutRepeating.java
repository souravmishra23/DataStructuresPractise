package com.pepcoding.hashMap;

import java.util.HashMap;
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LengthOfLongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
    public static int lengthOfLongestSubstring(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = 0;
        int i = -1;
        int j = -1;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            // acquire
            while (i < str.length() - 1) {
                f1 =true;
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.get(ch) == 2) {
                    break;
                }else {
                    int potentialLength = i - j;
                    if (potentialLength > len) len = potentialLength;

                }
            }

            // relase...
            while (j < i) {
                f2 = true;
                j++;
                char ch = str.charAt(j);
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 1) {
                    break;
                }
            }
            if (f1 == false && f2 == false) {
                break;
            }
        }
        return len;
    }
}
