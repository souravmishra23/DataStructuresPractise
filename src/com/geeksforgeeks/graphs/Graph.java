package com.geeksforgeeks.graphs;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Predicate;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode createList(int... values) {
        ListNode head = new ListNode(values[0]);
        ListNode prev = head;
        for (int i = 1; i < values.length; i++) {
            prev.next = new ListNode(values[i]);
            prev = prev.next;
        }
        return head;
    }

    public ListNode filter(Predicate<ListNode> f) {

        ListNode node = this;
        while (node != null && !f.test(node)) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {

        return val + "->" + next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
public class Graph {
    private ArrayList<Integer> vertices;
    private ListNode [] edges;
    private int vertexCount=0;

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        vertices= new ArrayList<>();
        edges=new ListNode[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            vertices.add(i);
            edges[i]=new ListNode(0);
        }
    }
}
