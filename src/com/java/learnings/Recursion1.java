package com.java.learnings;

import java.math.BigInteger;

public class Recursion1 {
    //Here bigInteger is taken to get factorial of a larger number..........
    static BigInteger factorial(BigInteger n){
        if (n.equals(0) || n.equals(BigInteger.valueOf(1))){
            return BigInteger.valueOf(1);
        }
        else{
            return n.multiply(factorial(n.subtract(BigInteger.valueOf(1))));
        }
    }
    public static void main(String[] args) {
       BigInteger value=new BigInteger(String.valueOf(51));
        System.out.println("The factorial of the number is="+factorial(value));
    }
}
