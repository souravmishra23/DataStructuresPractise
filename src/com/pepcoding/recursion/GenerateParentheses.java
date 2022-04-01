package com.pepcoding.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        List<String> result = new ArrayList<>();
        generate(n,n,"",result);
        System.out.println(result);
    }
    public static void generate(int open , int close, String asf , List<String> result) {
        if (open == 0 && close == 0) {
            result.add(asf);
            return;
        }
        if (open != 0) {
            generate(open-1,close,asf + "(",result);
        }
        if (close != 0 && open < close) {
            generate(open,close-1,asf + ")",result);
        }
    }
}
