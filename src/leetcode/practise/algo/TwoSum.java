package leetcode.practise.algo;

public class TwoSum {
    public static void main(String[] args) {

    }
    public static int[] twoSum(int[] numbers, int target) {
        //Two pointer approach avoiding dual loop ..O(n)
        //The input array is sorted..
        int l=0;
        int r=numbers.length-1;

        while(l<r){

            if((numbers[l]+numbers[r])==target)
                return new int[] {l+1,r+1};

            if(numbers[l]+numbers[r]<target){
                l++;
            }

            if(numbers[l]+numbers[r]>target){
                r--;
            }
        }
        return numbers;
    }
}
