package tree;

class Node {
    int value;
    Node left, right;

    public Node(int value){
        this.value = value;
    }
}

public class Tree {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(5);
        root.left.left = new Node(6);
        root.left.right = new Node(7);
        root.right.left = new Node(2);
        root.right.right = new Node(4);

        Tree tree = new Tree();
        tree.ldr1(root);
    }

    private void ldr1(Node root) {
        if (root != null) {
            ldr1(root.left);
            ldr1(root.right);
            System.out.println(root.value);
        }
    }
}