package leetcode.practise.algo;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,3,5,9,12},91));
        System.out.println(search1(new int[]{-1,0,3,5,9,12},9));
    }
    public static int search (int []  nums,int target){
        //traditional way O(n)
        for (int i=0;i< nums.length;i++){
            if (nums[i]==target){
                return i;
            }
        }
        return -1;
    }
    public static int search1 (int []  nums,int target){
        //Binary Search O(log(n)) for a sorted array
        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(target > nums[mid]){
                start = mid + 1;
            }
            else if(target < nums[mid]){
                end = mid - 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
