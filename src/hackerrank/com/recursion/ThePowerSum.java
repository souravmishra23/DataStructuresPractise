package hackerrank.com.recursion;

public class ThePowerSum {
    public static void main(String[] args) {
        powerSum(13,2);
    }
    public static int powerSum(int X, int N) {
        System.out.println(countSumPower(X,N,1,0,0));
        return 0;
    }

    public static int countSumPower(int num, int power, int curr, int carry, int count){
        int sum = carry + (int) Math.pow(curr,power);
        if (sum == num)
            return 1;
        else if (sum > num)
            return 0;

        count += countSumPower(num, power, curr+1, sum, 0); // choose curr
        count += countSumPower(num, power, curr+1, carry, 0); // dont choose curr

        return count;
    }
}
