package com.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddParentheses {
    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("2*3-4*5"));
    }

    public static List<Integer> diffWaysToCompute(String str) {
        return find(str);
    }

    public static List<Integer> find(String str) {
        if (str.length() <= 2)//Number can be of atmost 2 length
        {
            List<Integer> ls = new ArrayList<>();
            ls.add(Integer.parseInt(str));
            return ls;
        }
        List<Integer> result = new ArrayList<>();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (!Character.isDigit(ch)) {
                List<Integer> left = find(str.substring(0, i));
                List<Integer> right = find(str.substring(i + 1, n));
                for (Integer x1 : left) {
                    for (Integer x2 : right) {
                        if (ch == '+')
                            result.add(x1 + x2);
                        else if (ch == '*')
                            result.add(x1 * x2);
                        else
                            result.add(x1 - x2);
                    }
                }
            }
        }
        return result;
    }
}
