package com.java.learnings;

public class Driver {
    public static void main(String[] args) {
        BSTDictionary tree=new BSTDictionary();
        tree.insert("Old","Very Old");
        tree.insert("New","New");
        tree.insert("Jump","Very High Jump");
        tree.printTreeInorder();
        tree.searchElement("Jump");
    }
}
