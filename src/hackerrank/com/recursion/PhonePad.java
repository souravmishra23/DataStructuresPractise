package hackerrank.com.recursion;

// google question from kunal kushwaha video
public class PhonePad {
    public static void main(String[] args) {
        pad("", "22233");
    }

    static void pad(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char digit = up.charAt(0);
        String code = getCode(digit);
        for (int i = 0; i < code.length(); i++) {
            pad(p + code.charAt(i), up.substring(1));
        }
        /*int digit = up.charAt(0) - '0';
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            pad(p + ch, up.substring(1));
        }*/
    }
    public static String getCode(char n){
        if(n == '2'){
            return "abc";
        }else if( n == '3') {
            return "def";
        }else if( n == '4'){
            return "ghi";
        }else if( n == '5'){
            return "jkl";
        }else if( n == '6'){
            return "mno";
        }else if( n == '7'){
            return "pqrs";
        }else if( n == '8'){
            return "tuv";
        }else if( n == '9'){
            return "wxyz";
        }else{
            return "";
        }

    }
}
