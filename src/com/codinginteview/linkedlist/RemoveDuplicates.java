package com.codinginteview.linkedlist;


import java.util.HashSet;

class Node {
    int data;
    Node next;
    int size;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveDuplicates {
    public static void main(String[] args) {

    }

    // my solution
    public static void removeDuplicates(Node head) {
        Node temp = head;
        while (temp != null) {
            int data = temp.data;
            temp = temp.next;
            if (data == temp.data) {
                temp = temp.next;
            }
        }
    }

    void deleteDups(Node n) {
        HashSet<Integer> set = new HashSet<>();
        Node previous = null;
        while (n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }
    boolean deleteFromMiddle(Node n) {
        // n is the node to be deleted...
        if (n == null || n.next == null) {
            // since last node cannot be deleted by this method..
            return false;
        }
        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }
}

