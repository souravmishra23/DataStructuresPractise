package hackerrank.com.recursion;

public class StringQue1 {
    public static void main(String[] args) {
        skip("","baacd");
//        String test="baacd";
//        System.out.println(test.substring(1));
    }
     static void skip(String p,String up){
        if (up.isEmpty()){
            System.out.println("The String is="+p);
            return;
        }
        char ch=up.charAt(0);
        if (ch=='a'){
            skip(p,up.substring(1));
        }
        else{
            skip(p+ch,up.substring(1));
        }
     }
}
