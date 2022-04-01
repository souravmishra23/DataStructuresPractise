package hackerrank.com.recursion;

public class Tp {
    public static void main(String[] args) {
        String str="123";
        String part=str.substring(1, 1 + 1 - 1);
       // System.out.println(part);
       System.out.println(findSubstring(str,0,0+1-0));
    }
    static String findSubstring(String str,int start,int length){
        if (start==length || length==1){

            return ""+str.charAt(start);
        }
        return str.substring(start,start+length-1);
    }
}
