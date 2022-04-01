package com.java.learnings;

public class BSTDictionary {

    class Node{
        String word,meaning;
        Node left,right;
        Node(String word,String meaning){
            this.word=word;
            this.meaning=meaning;
            left=right=null;
        }
    }
    Node root;
    BSTDictionary(){
        root = null;
    }
    void insert(String word,String meaning){
        root=insert_record(root,word,meaning);
    }
    void printTreeInorder(){
        printTree(root);
    }
    private Node insert_record(Node root, String word, String meaning) {
        if (root==null){
            root=new Node(word,meaning);
            return root;
        }
        if (word.compareTo(root.word)<0){
            root.left=insert_record(root.left,word,meaning);
        }
        else if (word.compareTo(root.word)>0){
            root.right=insert_record(root.right,word,meaning);
        }
        return root;
    }
    private void printTree(Node root) {
        if (root == null)
            return;
        printTree(root.left);
        System.out.println(root.word);
        printTree(root.right);
    }
    public void searchElement(String word){
        Node temp;
        boolean flag=false;
        if (root==null){
            System.out.println("Tree is empty!!");
            return;
        }
        temp=root;
        while(temp!=null){
            if (word.compareTo(temp.word)==0){
                System.out.println("The word is="+word);
                System.out.println("The meaning is="+temp.meaning);
                flag=true;
                break;
            }
            temp=(word.compareTo(temp.word)>0) ? temp.right:temp.left;
        }
        if (!flag)
            System.out.println("No Search result !!");
        return;
    }
}
