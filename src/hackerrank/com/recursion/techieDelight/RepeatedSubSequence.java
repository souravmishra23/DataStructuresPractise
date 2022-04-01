package hackerrank.com.recursion.techieDelight;

import java.util.ArrayList;
import java.util.List;

public class RepeatedSubSequence {
    static List<Character> result=new ArrayList<>();
    public static void main(String[] args) {
        checkRepeatedSubSequence("XYBYAXBY");
        System.out.println(result);
    }
    static void checkRepeatedSubSequence(String str){
        if (str.isEmpty()){
            return;
        }
        char ch=str.charAt(0);
        if (checkForTheCharInString(ch,str)){
            result.add(ch);
        }
        checkRepeatedSubSequence(str.substring(1));
    }

    private static boolean checkForTheCharInString(char ch, String str) {
        int count=0;
        for (int i = 0; i < str.length(); i++) {
            if (ch==str.charAt(i)){
                count++;
            }
        }
       if (count>1){
           return true;
       }
       return false;
    }
}
