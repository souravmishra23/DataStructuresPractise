package hackerrank.com.recursion;

public class PrintPatternRecursively {
    public static void main(String[] args) {
        printPattern(5);
        printPattern1(5,0);
    }
    static void printPattern(int n){
        if (n==1){
            System.out.println("*");
            return;
        }
        helper(n);
        printPattern(n-1);
    }

    private static void helper(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("*" + " ");
        }
        System.out.println();
    }
    static void printPattern1(int n,int i){
        if (n==0) return;
        if (i<n){
            System.out.print("* ");
            printPattern1(n,i+1);
        }
        else {
            System.out.println();
            printPattern1(n-1,0);
        }
    }
}
