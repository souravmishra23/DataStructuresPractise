package hackerrank.com.recursion;

public class PrintPatternRecursively1 {
   static int k=1;
    public static void main(String[] args) {
        //printPattern(5);
       printPattern1(5,0,1);
    }
    static void printPattern(int n){

        if (n==0){
           // System.out.println("*");
            return;
        }
        helper(n,k);
        k++;

        printPattern(n-1);
    }

    private static void helper(int n,int k) {
        for (int i = 0; i < k; i++) {
            System.out.print("*" + " ");
        }
        System.out.println();
    }
    static void printPattern1(int n,int i,int k){
        if (n==0) return;
        if (i<k){
            System.out.print("* ");

            printPattern1(n,i+1,k);

        }
        else {
            System.out.println();
            printPattern1(n-1,0,k+1);
        }
    }
}
