package hackerrank.com.recursion;

public class Fibonacci {
    public static void main(String[] args) {
        fibonacci(12); 
    }
    static void fibonacci(int range){

        if(range<=2){
            System.out.println(range);
            return ;
        }
        System.out.println((range-1)+(range-2));
    fibonacci(range-1);
    }
}
