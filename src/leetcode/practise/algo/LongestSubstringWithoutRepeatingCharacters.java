package leetcode.practise.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    public static int lengthOfLongestSubstring(String s) {
        //Sliding window solution
        int left = 0;
        int right = 0;
        int biggestLength = 0;
        HashSet<Character> set = new HashSet<>();
        while (left < s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right = right < s.length() - 1? right + 1 : right;
            }
            else{
                biggestLength = Math.max(set.size(), biggestLength);
                set.remove(s.charAt(left++));
            }
        }
        return biggestLength;
    }
}
