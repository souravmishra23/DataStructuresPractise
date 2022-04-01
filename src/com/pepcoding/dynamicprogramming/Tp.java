package com.pepcoding.dynamicprogramming;
 class Animal {
    public void show() {
        System.out.println("Show====>>>");
    }
    static void display() {
        System.out.println("Display====>>>");
    }
 }
public class Tp {
    public static void main(String[] args) {
        Animal a=new Animal();
        a.show();
        a.display(); // valid

    }
}
