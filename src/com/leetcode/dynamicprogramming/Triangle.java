package com.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {

    }
    public static int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> sum = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (triangle.get(i).get(j) < min) {
                    min = triangle.get(i).get(j);
                }
            }
            sum.add(min);
        }
        int result = 0;
        for (int i = 0; i < sum.size(); i++) {
            result = result + sum.get(i);
        }
        System.out.println(sum);
        return result;
    }
}
