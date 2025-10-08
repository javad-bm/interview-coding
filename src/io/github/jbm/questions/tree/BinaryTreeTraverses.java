package io.github.jbm.questions.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class BinaryTreeTraverses {

    // --- Recursive Traversals ---
    public static <T> void preorderRecursive(BinaryTreeNode<T> node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        preorderRecursive(node.left);
        preorderRecursive(node.right);
    }

    public static <T> void inorderRecursive(BinaryTreeNode<T> node) {
        if (node == null) return;
        inorderRecursive(node.left);
        System.out.print(node.value + " ");
        inorderRecursive(node.right);
    }

    public static <T> void postorderRecursive(BinaryTreeNode<T> node) {
        if (node == null) return;
        postorderRecursive(node.left);
        postorderRecursive(node.right);
        System.out.print(node.value + " ");
    }

    // --- Iterative Traversals ---
    public static <T> void preorderIterative(BinaryTreeNode<T> root) {
        if (root == null) return;
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode<T> current = stack.pop();
            System.out.print(current.value + " ");
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
    }

    public static <T> void inorderIterative(BinaryTreeNode<T> root) {
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        BinaryTreeNode<T> current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.value + " ");
            current = current.right;
        }
    }

    public static <T> void postorderIterative(BinaryTreeNode<T> root) {
        if (root == null) return;
        Stack<BinaryTreeNode<T>> stack1 = new Stack<>();
        Stack<BinaryTreeNode<T>> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            BinaryTreeNode<T> current = stack1.pop();
            stack2.push(current);
            if (current.left != null) stack1.push(current.left);
            if (current.right != null) stack1.push(current.right);
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().value + " ");
        }
    }

    public static <T> void levelOrder(BinaryTreeNode<T> root) {
        if (root == null) return;
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.poll();
            System.out.print(current.value + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    public static void main(String[] args) {

        // Create tree
        BinaryTreeNode<String> root = new BinaryTreeNode<>("A");
        root.left = new BinaryTreeNode<>("B");
        root.right = new BinaryTreeNode<>("C");
        root.left.left = new BinaryTreeNode<>("D");
        root.left.right = new BinaryTreeNode<>("E");
        root.right.right = new BinaryTreeNode<>("F");

        /*
              A
             / \
            B   C
           / \   \
          D   E   F
        */

        System.out.println("Preorder Recursive:");
        preorderRecursive(root);
        System.out.println("\nPreorder Iterative:");
        preorderIterative(root);

        System.out.println("\n\nInorder Recursive:");
        inorderRecursive(root);
        System.out.println("\nInorder Iterative:");
        inorderIterative(root);

        System.out.println("\n\nPostorder Recursive:");
        postorderRecursive(root);
        System.out.println("\nPostorder Iterative:");
        postorderIterative(root);

        System.out.println("\n\nLevel Order (BFS):");
        levelOrder(root);

    }
}
