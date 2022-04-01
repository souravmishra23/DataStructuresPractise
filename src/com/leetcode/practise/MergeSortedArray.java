package com.leetcode.practise;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int a[]=new int[]{1,2,3,0,0,0};
        int b[]=new int[]{2,5,6};
        int fal = a.length;        //determines length of firstArray
        int sal = b.length;
        int dstPosition=a.length-b.length;
        int[] result = new int[fal + sal];  //resultant array of size first array and second array
        System.arraycopy(a, 0, result, dstPosition, fal);
        System.arraycopy(b, 0, result, fal, sal);
        System.out.println(Arrays.toString(result));    //prints the resultant array
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int j=0;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]==0 && j<n){
                nums1[i] = nums2[j];
                j++;
            }
        }
        Arrays.sort(nums1);
    }
}
