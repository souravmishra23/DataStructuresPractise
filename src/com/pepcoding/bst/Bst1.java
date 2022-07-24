package com.pepcoding.bst;

import java.util.Stack;

public class Bst1 {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }
        String str = "";
        str += node.left == null ? "." : node.left.data + " ";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + " ";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }

    public static Node construct(int[] arr, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = (lo + hi) / 2;
        int data = arr[mid];
        Node lc = construct(arr, lo, mid - 1);
        Node rc = construct(arr, mid + 1, hi);
        Node root = new Node(data, lc, rc);
        return root;
    }

    public static int size(Node node) {
        if (node == null) {
            return 0;
        }
        int ls = size(node.left);
        int rs = size(node.right);
        int ts = ls + rs + 1;
        return ts;
    }

    public static int sum(Node node) {
        if (node == null) {
            return 0;
        }
        int ls = size(node.left);
        int rs = size(node.right);
        int ts = ls + rs + node.data;
        return ts;
    }

    public static int max(Node node) {
        if (node.right != null) {
            return max(node.right);
        }
        else {
            return node.data;
        }
    }

    public static int min(Node node) {
        if (node.left != null) {
            return min(node.left);
        }
        else {
            return node.data;
        }
    }

    public static boolean find(Node node,int data) {
        if (node == null) {
            return false;
        }
        if (data > node.data) {
            return find(node.right,data);
        }
        else if (data < node.data) {
            return find(node.left,data);
        }
        else {
            return true;
        }
    }
    public static Node add(Node node,int data) {
        if (node == null) {
            return new Node(data,null,null);
        }
        if (data > node.data) {
            node.right = add(node.right,data);
        }
        else if (data < node.data) {
            node.left = add(node.left,data);
        }else {
            // do nothing
        }
        return node;
    }
    public static Node remove(Node node,int data) {
        if (node == null) {
            return null;
        }
        if (data > node.data) {
            node.right = remove(node.right,data);
        }
        else if (data < node.data) {
            node.left = remove(node.left,data);
        }else {
            if (node.left != null && node.right != null) {
                int lmax = max(node.left);
                node.data = lmax;
                node.left = remove(node.left,lmax);
                return node;
            }else if (node.left != null) {
                return node.left;
            }else if (node.right != null) {
                return node.right;
            }else {
                return null;
            }
        }
        return node;
    }

    static int sum = 0;
    // here we used reverse inorder
    public static void ReplaceSumOfLarger(Node node) {
        if (node == null) {
            return ;
        }
        ReplaceSumOfLarger(node.right);
        int originalData = node.data;
        node.data = sum;
        sum += originalData;
        ReplaceSumOfLarger(node.left);
    }
    public static int lca(Node node,int d1,int d2) {
        if (d1 < node.data && d2 < node.data) {
            return lca(node.left,d1,d2);
        }else if (d1 > node.data && d2 > node.data) {
            return lca(node.right,d1,d2);
        }else {
            return node.data;
        }
    }

    public static void travelAndPrint(Node root,Node node,int target) {
        if (root == null) {
            return;
        }
        travelAndPrint(root,node.left,target);
        int comp = node.data - target;
        if (node.data < comp) {
            if (find(root,comp)) {
                System.out.println(node.data + " " + comp);
            }
        }
        travelAndPrint(root,node.left,target);
    }
    public static class ITPair
    {
        Node node;
        int state = 0;

        ITPair() {};

        ITPair(Node node, int state)
        {
            this.node = node;
            this.state = state;
        }
    }

    public static void bestApproach(Node node, int tar)
    {
        Stack< ITPair> ls = new Stack< >();
        Stack< ITPair> rs = new Stack< >();

        ls.push(new ITPair(node, 0));
        rs.push(new ITPair(node, 0));

        Node left = getNextFromNormalInorder(ls);
        Node right = getNextFromReverseInorder(rs);
        while (left.data < right.data)
        {
            if (left.data + right.data < tar)
            {
                left = getNextFromNormalInorder(ls);

            }
            else if (left.data + right.data > tar)
            {
                right = getNextFromReverseInorder(rs);
            }
            else
            {
                System.out.println(left.data + " " + right.data);
                left = getNextFromNormalInorder(ls);
                right = getNextFromReverseInorder(rs);
            }
        }
    }

    public static Node getNextFromNormalInorder(Stack< ITPair> st)
    {
        while (st.size() > 0)
        {
            ITPair top = st.peek();
            if (top.state == 0)
            {
                if (top.node.left != null)
                {
                    st.push(new ITPair(top.node.left, 0));

                }
                top.state++;
            }
            else if (top.state == 1)
            {
                if (top.node.right != null)
                {
                    st.push(new ITPair(top.node.right, 0));
                }
                top.state++;
                return top.node;
            }
            else
            {
                st.pop();
            }
        }
        return null;
    }


    public static Node getNextFromReverseInorder(Stack< ITPair> st)
    {
        while (st.size() > 0)
        {
            ITPair top = st.peek();
            if (top.state == 0)
            {
                if (top.node.right != null)
                {
                    st.push(new ITPair(top.node.right, 0));

                }
                top.state++;
            }
            else if (top.state == 1)
            {
                if (top.node.left != null)
                {
                    st.push(new ITPair(top.node.left, 0));
                }
                top.state++;
                return top.node;
            }
            else
            {
                st.pop();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {12, 25, 37, 50, 62, 75, 87};
        Node root = construct(arr, 0, arr.length - 1);
        display(root);
    }
}
