package com.leetcode.stack;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }
    public static boolean isValid(String s) {
        Stack stack = new Stack();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }
            else if(!stack.empty() && ch == ')' && stack.peek().equals('(') ){
                stack.pop();
            }
            else if(!stack.empty() && ch == ']' &&stack.peek().equals('[') ){
                stack.pop();
            }
            else if(!stack.empty() && ch == '}' && stack.peek().equals('{') ){
                stack.pop();
            }
            else{
                return false;
            }
        }
        return stack.empty();
    }
}
