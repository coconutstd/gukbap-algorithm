package tree;

import java.util.Stack;

class Node {
    int value;
    Node left, right;

    public Node(int value){
        this.value = value;
    }
}

public class Tree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Tree tree = new Tree();
        tree.ldr3(root);
    }

    private void ldr1(Node root) {
        if (root != null) {
            ldr1(root.left);
            ldr1(root.right);
            System.out.println(root.value);
        }
    }

    private void ldr2(Node root) {
        Stack<Node> stack = new Stack<>();
        while (true) {
           while(root != null) {
               stack.push(root);
               System.out.println(root.value);
               root = root.left;
           }
           if(stack.isEmpty()) break;
           root = stack.pop();
           root = root.right;
        }
    }

    private void ldr3(Node root) {
        Stack<Node> stack = new Stack<>();
        while (true) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            if(stack.isEmpty()) break;
            root = stack.pop();
            root = root.right;
        }
    }
}