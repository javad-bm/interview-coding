package io.github.jbm.questions.tree;

import java.util.*;


public class BinaryTree {

    // DFS - Recursively
    public static int findMaxDepthDFSRecursive(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        return Math.max(findMaxDepthDFSRecursive(root.left), findMaxDepthDFSRecursive(root.right)) + 1;
    }

    // BFS - Using Queue
    public static int findMaxDepthBFS(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        int maxDepth = 0;
        while (! queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                BinaryTreeNode<Integer> node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            maxDepth++;
        }
        return maxDepth;
    }


    public static void main(String[] args) {

    //               1
    //              / \
    //             2   3
    //            / \   \
    //           4  5    6
    //                 /   \
    //                7     8

        BinaryTreeNode<Integer> n7 = new BinaryTreeNode<>(7);
        BinaryTreeNode<Integer> n8 = new BinaryTreeNode<>(8);
        BinaryTreeNode<Integer> n6 = new BinaryTreeNode<>(6, n7, n8);
        BinaryTreeNode<Integer> n4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> n5 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> n2 = new BinaryTreeNode<>(2, n4, n5);
        BinaryTreeNode<Integer> n3 = new BinaryTreeNode<>(3, null, n6);
        BinaryTreeNode<Integer> n1 = new BinaryTreeNode<>(1, n2, n3);

        System.out.println(findMaxDepthDFSRecursive(n1));
        System.out.println(findMaxDepthBFS(n1));
        
    }
}
