package hackerrank.com.recursion;

public class PermutationsOfString {
    public static void main(String[] args) {
        String s = "abc";
        //printPermutn(s, "");
        printPermutnOptimized(s.toCharArray(),0);
    }

    private static void printPermutn(String str, String ans) {
        if (str.length()==0){
            System.out.println(ans +" ");
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            String ros=str.substring(0,i)+str.substring(i+1);
            printPermutn(ros, ans + ch);
        }
    }

    // more optimized solution using backtring bty sanket singh...
    private static void printPermutnOptimized(char [] str,int j) {
        if (str.length -1 == j) {
            for (int i = 0; i < str.length; i++) {
                System.out.print(str[i]);
            }
            System.out.println();
            return;
        }
        for (int i = j; i < str.length; i++) {
            swap(str,i,j);
            printPermutnOptimized(str,j+1);
            swap(str,i,j);   // this is the backtracking here used

        }
    }
    static void swap(char[] str, int i, int j)
    {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }


}
