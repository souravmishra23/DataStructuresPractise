package hackerrank.com.recursion;

public class DiceProblem1 {
    public static void main(String[] args) {
        printResult("",4);
    }

    static void printResult(String p,int target) {
        if (target == 0) {
            System.out.println(p);
            return;
        }
        for (int i = 1; i <= 6 && i<=target; i++) {
            printResult(p+i,target-i);
        }
    }

}
