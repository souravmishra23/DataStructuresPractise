package hackerrank.com.recursion;

public class BinarySearch {
    public static void main(String[] args) {
       int [] arr={1,2,3,4};
       System.out.println(search(arr, 2, 0, arr.length-1)); 
    }
    static boolean search(int [] arr,int target,int start,int end){
        if(start>end){
            return false;
        }
        
        int mid=start+(end-1)/2;
        if(arr[mid]==target){
            return true;
        }
        if(arr[mid]<target){
            return search(arr,target,mid+1,end);
        }
        return search(arr,target,start,mid-1);

    }
}
