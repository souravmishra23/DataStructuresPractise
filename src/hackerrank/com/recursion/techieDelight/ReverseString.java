package hackerrank.com.recursion.techieDelight;

public class ReverseString {
    static StringBuilder result=new StringBuilder();
    public static void main(String[] args) {
        reverseString("Techie Delight","Techie Delight".length());
        System.out.println(result);
    }
    static void reverseString(String str,int n){
        if (n==0){
            return;
        }
        result.append(str.charAt(n-1));
        reverseString(str,n-1);
    }
}
