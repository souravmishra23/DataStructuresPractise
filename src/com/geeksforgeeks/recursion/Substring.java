package com.geeksforgeeks.recursion;

import java.util.ArrayList;
import java.util.List;

public class Substring {
    static List<String> result=new ArrayList<>();
    public static void main(String[] args) {
        generate("abc");
        result.remove("");
        for (String str:result){
           // if (str.charAt(0)==str.charAt(str.length()-1)){
                System.out.println(str);
           // }
        }
    }
    public static void generate(String word) {
        if (word.length() == 1) {
            System.out.println(word);
            return;
        }else{
            System.out.println(word);
            generate(word.substring(0, word.length()-1));
            generate(word.substring(1));
        }

    }
}
