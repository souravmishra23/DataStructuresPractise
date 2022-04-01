package leetcode.practise.algo;

import java.util.ArrayList;
import java.util.List;

public class PermutationinString {
    public static void main(String[] args) {
        System.out.println(permute("abc",""));

    }
    static List<String> permute(String s , String answer)
    {
        List<String> result=new ArrayList<>();
        if (s.length() == 0)
        {
            System.out.print(answer + "  ");
            result.add(answer);
            return result;
        }

        for(int i = 0 ;i < s.length(); i++)
        {
            char ch = s.charAt(i);
            String left_substr = s.substring(0, i);
            String right_substr = s.substring(i + 1);
            String rest = left_substr + right_substr;
            permute(rest, answer + ch);
        }
        return result;
    }
}
