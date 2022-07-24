package com.pepcoding.hashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class EmployeesUnderManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(sc.next(), sc.next());
        }
        findCount(map);
    }
    public static void findCount(HashMap<String, String> map) {
        // Storing key as employee and value as Set of Employees reporting to him
        HashMap<String, HashSet<String>>  tree = new HashMap<>();
        String ceo = "";
        for (String emp: map.keySet()) {
            String manager = map.get(emp);
            if (manager.equals(emp)) {
                // if emp reports to same emp then that emp is a ceo..
                ceo = manager;
            }else {
                if (tree.containsKey(manager)) {
                    HashSet<String> emps = tree.get(manager);
                    emps.add(emp);

                }else {
                    HashSet<String> emps = new HashSet<>();
                    emps.add(emp);
                    tree.put(manager, emps);
                }
            }
        }
        HashMap<String, Integer> result = new HashMap<>();
        getSize(tree, ceo, result);
        for (String emp: result.keySet()) {
            System.out.println(emp + " " + result.get(emp));
        }
    }
    public static int getSize(HashMap<String, HashSet<String>> tree, String manager, HashMap<String, Integer> result) {
        if (!tree.containsKey(manager)) {
            result.put(manager, 0);
            return 1;
        }

        int size = 0;
        for (String emp: tree.get(manager)) {
            int childSize = getSize(tree, emp, result);
            size += childSize;
        }
        result.put(manager, size);
        return size + 1;
    }
 }
