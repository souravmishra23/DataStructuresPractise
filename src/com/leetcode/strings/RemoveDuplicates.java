package com.leetcode.strings;

import java.util.Stack;

public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates1("abbaca"));
    }
    public static String removeDuplicates(String s) {
        StringBuffer str = new StringBuffer(s);
        for (int i =1;i < str.length();i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                str.deleteCharAt(i);
                str.deleteCharAt(i -1);
                i = 0;
            }
        }
        return str.toString();
    }
    public static String removeDuplicates1(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < s.length();i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
            }
            else if (stack.peek() == s.charAt(i)) {
                stack.pop();
            }
            else {
                stack.push(s.charAt(i));
            }
        }
        String str = "";
        while (!stack.isEmpty()) {
            str =  stack.pop() + str ;
        }
        return str;
    }
}
