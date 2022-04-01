package hackerrank.com.recursion;

public class ArraySorted {
    public static void main(String[] args) {
        int a[]={2,4,5,7};
        System.out.println(checkSorted(a));
    }
    static boolean checkSorted(int a[]){
        boolean flag =true;
        int min=-1;
        for (int i : a) {
            if(i>min){
                min=i;
            }
            else{
                flag=false;
                break;
            }
        }
        return flag;
    }
}
