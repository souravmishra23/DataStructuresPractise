package hackerrank.com.recursion;

public class RecursiveDigitSum {
    public static void main(String[] args) {
        superDigit("146",3);
    } 
    public static String appendStrings(String n,int k){
        String superString="";
        for (int i = 0; i <k ; i++) {
            superString=superString.concat(n);
        }
        return superString;
    }
    public static int superDigit(String n){
        int sum=0;
        for (int i = 0; i < n.length() ; i++) {
            String str= String.valueOf(n.charAt(i));
            sum=sum+Integer.parseInt(str);
        }
        return sum;
    }

    public static int superDigit(String number, int k) {

        /// Best solution for recurive approach
        if (number.length() > 1)
        {
            long sum = 0;
            for (int i = 0; i < number.length(); i++)
            {
                sum += Character.getNumericValue(number.charAt(i));
            }
            return superDigit(Long.toString(sum * k), 1);
        }
        else
            return Character.getNumericValue(number.charAt(0));

    }
}
