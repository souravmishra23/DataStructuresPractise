package com.pepcoding.hashMap;

import java.util.HashMap;
import java.util.Scanner;

public class FrequencyMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int [] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        int n2 = sc.nextInt();
        int [] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> fmap = new HashMap<>();
        for (int val: arr1) {
            if (fmap.containsKey(val)) {
                int oldFreq = fmap.get(val);
                fmap.put(val, oldFreq + 1);
            }else {
                fmap.put(val, 1);
            }
        }
        for (int val: arr2) {
            if (fmap.containsKey(val)) {
                System.out.print(val + " ");
                fmap.remove(val);
            }
        }
    }
}
