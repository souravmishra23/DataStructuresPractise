package com.leetcode.dynamicprogramming;

public class ImplementstrStr {
    public static void main(String[] args) {
        strStr("mississippi","mississippi");
        System.out.println("gg".indexOf("g"));

    }
    public static int strStr(String haystack, String needle) {
        int count = 0;
        int end = 0;
        for (int i = 0; i < haystack.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i) == needle.charAt(j)) {
                    end = i;
                    count ++;
                    break;
                }else {
                    if (count == needle.length()) {

                        break;
                    }else
                        count = 0;
                }
            }
        }
        System.out.println(count);
        System.out.println(end + 1 - needle.length());
        System.out.println(haystack.length() - count - 1);
        return 0;
    }
}
