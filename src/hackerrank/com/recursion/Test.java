package hackerrank.com.recursion;

import java.util.HashMap;


public class Test {
    public static void main(String[] args) {
        String str="aabbccd";
        HashMap<Character,Integer> result=new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
           // System.out.println(ch+ " =="+countCharacters(str,ch));
         result.put(ch, countCharacters(str, ch)); 
        }
        System.out.println(result);
    }

    private static int countCharacters(String str, char ch) {
        int count=0;
        for(int i=0;i<str.length();i++){
            if (str.charAt(i)==ch){
                count++;
            }
        }
        return count;
    }
}
