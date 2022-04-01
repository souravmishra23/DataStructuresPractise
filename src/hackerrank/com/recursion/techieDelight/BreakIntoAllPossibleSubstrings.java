package hackerrank.com.recursion.techieDelight;

public class BreakIntoAllPossibleSubstrings {
    public static void main(String[] args) {
        String str="ABC";
        recur(str,0,"");
    }
        static void recur(String s,int i,String out) {
            if (s == null || s.length() == 0) {
                return;
            }
            if (i == s.length()) {
                System.out.println(out);
            }
            for (int j = s.length() - 1; j >= i; j--)
            {
                String substr = "{" + s.substring(i, j + 1) + "}";

                // append the substring to the result and recur with an index of
                // the next character to be processed and the result string
                recur(s, j + 1, out + substr);
            }
        }
}
