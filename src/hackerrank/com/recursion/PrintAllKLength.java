package hackerrank.com.recursion;

public class PrintAllKLength {
    public static void main(String[] args) {
        System.out.println("First Test");
        char[] set1 = {'a', 'b'};
        int k = 3;
        printAllKLen(set1, "", set1.length, k);
    }
    static void printAllKLen(char [] set,String prefix,int n,int k){
        if (k==0){
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i < n; i++) {
            String newPrefix=prefix+set[i];
            printAllKLen(set, newPrefix, n, k-1);
        }
    }
}
