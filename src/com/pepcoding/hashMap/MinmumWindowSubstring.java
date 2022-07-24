package com.pepcoding.hashMap;

import java.util.HashMap;
import java.util.Scanner;
// https://leetcode.com/problems/minimum-window-substring/
public class MinmumWindowSubstring {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(solution(s1,s2));
    }
    public static String solution(String s1, String s2){
        String ans = "";
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (Character ch: s2.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        int matchCount = 0;
        int desiredMatchCount = s2.length();
        HashMap<Character, Integer> map1 = new HashMap<>();
        int i = -1;
        int j = -1;
        while (true) {
            // acquire
            boolean flag1 = false;
            boolean flag2 = false;
            while (i < s1.length() - 1 && matchCount < desiredMatchCount) {
                i++;
                char ch = s1.charAt(i);
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);
                if (map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)) {
                    matchCount++;
                }
                flag1 = true;
            }
            // collect ans and release
            while (j < i && matchCount == desiredMatchCount) {
                String potentialAns = s1.substring(j + 1, i+ 1);
                if (ans.length() == 0 || ans.length() > potentialAns.length()) {
                    ans = potentialAns;
                }
                j++;
                char ch = s1.charAt(j);
                if (map1.get(ch) == 1) {
                    map1.remove(ch);
                }else {
                    map1.put(ch, map1.get(ch) - 1);
                }
                if (map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)) {
                    matchCount--;
                }
                flag2 = true;
            }
            if (flag1 == false && flag2 == false) {
                break;
            }
        }
        return ans;
    }
}
