public class BinarySearchTree1 {
    class Node {
        int key;
        Node left;
        Node right;

        public Node(int item) {
            this.key = item;
            left = right = null;
        }
    }

    Node root;

    public BinarySearchTree1() {
        root = null;
    }

    void insert(int key) {
        root = insert_record(root, key);
    }
    void printTreeInorder(){
        printTree(root);
    }
    private Node insert_record(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key) {
            root.left = insert_record(root.left, key);
        } else if (key > root.key) {
            root.right = insert_record(root.right, key);
        }
        return root;
    }

    private void printTree(Node root) {
        if (root == null)
            return;
        printTree(root.left);
        System.out.println(root.key);
        printTree(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree1 tree = new BinarySearchTree1();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.printTreeInorder();
    }
}
