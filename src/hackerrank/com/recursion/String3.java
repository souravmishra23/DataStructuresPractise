package hackerrank.com.recursion;

import java.util.ArrayList;
import java.util.List;

public class String3 {
    public static void main(String[] args) {
        String input="123";
        int target=6;
        List<String> res=getExprs(input, target);
        System.out.println(res);
    }
    static String findSubstring(String str,int start,int length){
        if (start==length || length==1){

            return ""+str.charAt(start);
        }
        return str.substring(start,start+length-1);
    }

    private static List<String> getExprs(String input, int target) {
        List<String> res = new ArrayList<>();
        getExprUtil(res, "", input, target, 0, 0, 0);
        return res;
    }
    private static void getExprUtil(List<String> res,String curExp,String input,int target,int pos,int curVal,int last){
        if (pos==input.length()){
            if (curVal==target){
                res.add(curExp);
            }
            return;
        }
        for (int i = pos; i < input.length(); i++) {
            if (i != pos && input.charAt(pos) == '0')
                break;

            String part= findSubstring(input,pos,i+1-pos);
            int cur;
            if (part.isEmpty())
                cur=0;
            else
             cur=Integer.parseInt(part);
            if (pos == 0)
                getExprUtil(res, curExp + part, input,
                        target, i + 1, cur, cur);


                // try all given binary operator for evaluation
            else
            {
                getExprUtil(res, curExp + "+" + part, input,
                        target, i + 1, curVal + cur, cur);
                getExprUtil(res, curExp + "-" + part, input,
                        target, i + 1, curVal - cur, -cur);
                getExprUtil(res, curExp + "*" + part, input,
                        target, i + 1, curVal - last + last * cur,
                        last * cur);
            }
        }
    }
}
