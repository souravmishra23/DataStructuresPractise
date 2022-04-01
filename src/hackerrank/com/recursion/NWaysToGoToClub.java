package hackerrank.com.recursion;

public class NWaysToGoToClub {
    public static void main(String[] args) {
        // Here n is no of people that want to go to the club
        // they can either go alone or go in a pair
        // for example if n==3 ABC
        // the solution can be -> {A}{B}{C}, {A}{BC},{AB}{C},{AC}{B} -> 4 ways is the answer.
        System.out.println(noOfWays(4));
    }
    static int noOfWays(int n){
        // this is the base case where if n==1 or n==2 then no of ways can only be or 2
        if (n==1 || n==2){
            return n;
        }
        // this is the recurrence relation where solution is either A goes alone if so then no of ways depends on
        // the other ppl how they go in the club which is n-1
        // other way can be if A goes in pair with the other ppl which can AB or AC
        // the num ber of ways to make a pair is N-1 and other ppl how they can go it F(N-2)
        return noOfWays(n-1)+(n-1)*noOfWays(n-2);
    }
}
