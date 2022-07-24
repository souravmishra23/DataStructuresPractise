package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        // 10,2,-5
        System.out.println(asteroidCollision1(new int[]{5,10,-5}));
    }
    public static int[] asteroidCollision(Integer[] asteroids) {
        List<Integer> ast = new ArrayList<>(Arrays.asList(asteroids));
        for (int i = 1;i < asteroids.length;i++) {
            if (ast.get(i) < 0) {
                if ( -ast.get(i - 1) == ast.get(i)) {
                    ast.remove(i);
                    ast.remove(i - 1);

                }
                else if (ast.get(i - 1) > ast.get(i)) {
                    ast.remove(i);
                }
            }
        }
        System.out.println(ast);
        return new int[]{};
    }
    public static int[] asteroidCollision1(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int asteroid: asteroids) {
            if(asteroid > 0) {
                stack.push(asteroid);
            } else {
                while(!stack.empty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                }
                if(stack.empty() || stack.peek() < 0) {
                    stack.push(asteroid);
                } else if(stack.peek() == Math.abs(asteroid)) {
                    stack.pop();
                }
            }
        }
        System.out.println(stack);
        int[] answer = new int[stack.size()];
        for(int i=answer.length-1;i>=0;i--) {
            answer[i] = stack.pop();
        }
        return answer;
    }
}
