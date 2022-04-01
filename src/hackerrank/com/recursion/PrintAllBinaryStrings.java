package hackerrank.com.recursion;

public class PrintAllBinaryStrings {
    // Array conversion to String--
    public static String toString(char[] a) {
        String string = new String(a);
        return string;
    }
    static  void generate(int k,char ch[],int n){
        if (n==k){
            System.out.println(toString(ch));
            return;
        }
        if (ch[n - 1] == '0') {
            ch[n] = '0';
            generate(k, ch, n + 1);
            ch[n] = '1';
            generate(k, ch, n + 1);
        }

        // If the Character is One
        // then add Zero to next**
        if (ch[n - 1] == '1') {

            ch[n] = '0';

            // Calling Recursively for the
            // next value of Array
            generate(k, ch, n + 1);

        }
    }
    static void fun(int k) {

        if (k <= 0) {
            return;
        }

        char[] ch = new char[k];

        // Initializing first character to Zero
        ch[0] = '0';

        // Generating Strings starting with Zero--
        generate(k, ch, 1);

        // Initialized first Character to one--
        ch[0] = '1';
        generate(k, ch, 1);

    }
    public static void main(String[] args) {
        int k = 3;

        //Calling function fun with argument k
        fun(k);
    }
}
