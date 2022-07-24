package com.pepcoding.hashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/smallest-substring-of-a-string-containing-all-unique-characters-of-itself-official/ojquestion
public class MinmumWindowSubstring2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }

    public static int solution(String str){
        int len = str.length();
        HashSet<Character> set = new HashSet<>();
        for (Character ch: str.toCharArray()) {
            set.add(ch);
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        while (true) {
            boolean flag1 = false;
            boolean flag2 = false;
            // acquire until it becomes invalid i.e (set.size() == map.size() )
            while (i < str.length() - 1 && map.size() < set.size()) {
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                flag1 = true;
            }
            //collect and release..
            while (j < i && map.size() == set.size()) {
                int potentialLength = i - j;
                if (potentialLength < len) {
                    len = potentialLength;
                }
                j++;
                char ch = str.charAt(j);
                if (map.get(ch) == 1) {
                    map.remove(ch);
                }else {
                    map.put(ch, map.get(ch) - 1);
                }
                flag2 = true;
            }
            if (flag1 == false && flag2 == false) {
                break;
            }
        }
        return len;
    }

}
