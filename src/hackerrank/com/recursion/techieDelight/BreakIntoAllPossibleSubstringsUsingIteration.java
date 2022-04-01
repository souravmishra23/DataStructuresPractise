package hackerrank.com.recursion.techieDelight;

import java.util.ArrayList;
import java.util.HashSet;


public class BreakIntoAllPossibleSubstringsUsingIteration {
    public static void main(String[] args) {
        String str="abc";
        HashSet<String> result=new HashSet<>();
        for (int i = 1; i <=str.length(); i++) {

            for (int j = 0; j <= str.length()-i; j++) {
                result.add(str.substring(j, j+i));
            }

        }
        System.out.println(result);
    }
}
