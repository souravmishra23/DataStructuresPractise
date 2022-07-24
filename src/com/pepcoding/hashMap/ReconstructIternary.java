package com.pepcoding.hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
// https://www.youtube.com/watch?v=4mi2rO4D_Xk&list=PL-Jc9J83PIiEp9DKNiaQyjuDeg3XSoVMR&index=2
public class ReconstructIternary {
    public static void main(String[] args) {

    }
    public static List<String> findItinerary(List<List<String>> tickets) {
        List<String> ans = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < tickets.size(); i++) {
            List<String> temp = tickets.get(i);
            map.put(temp.get(0), temp.get(1));
        }
       // System.out.println(map);
        HashMap<String, Boolean> potentialSource = new HashMap<>();
        for (String src: map.keySet()) {
            String dest = map.get(src);
            potentialSource.put(dest, false);
            if (!potentialSource.containsKey(src)) {
                potentialSource.put(src, true);
            }
         }
        String src = "";
        for (String pot: potentialSource.keySet()) {
            if (potentialSource.get(pot) == true) {
                src = pot;
                break;
            }
        }
        while (true) {
            if (map.containsKey(src)) {
                ans.add(src);
                src = map.get(src);
            }else {
                ans.add(src);
                break;
            }
        }
        return ans;
    }
}
