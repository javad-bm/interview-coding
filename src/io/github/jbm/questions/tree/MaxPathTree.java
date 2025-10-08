package io.github.jbm.questions.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class MaxPathTree {
    
    private static int maxPathSum(BinaryTreeNode<Integer> root) {
        AtomicInteger maxSum = new AtomicInteger(Integer.MIN_VALUE);
        maxGain(root, maxSum);
        return maxSum.get();
    }
    
    private static int maxGain(BinaryTreeNode<Integer> node, AtomicInteger maxSum) {
        if (node == null) {
            return 0;
        }
        
        // If a child contributes negatively, drop it (use 0 instead)
        int leftGain = Math.max(0, maxGain(node.left, maxSum));
        int rightGain = Math.max(0, maxGain(node.right, maxSum));

        // Path sum that passes THROUGH this node (could use both sides)
        int throughGain = leftGain + node.value + rightGain;
        maxSum.set(Math.max(maxSum.get(), throughGain));

        return node.value + Math.max(leftGain, rightGain);
    }
    
    
    // Build tree from array (level order)
    public static BinaryTreeNode<Integer> buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(arr[0]);
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            BinaryTreeNode<Integer> current = queue.poll();
            
            // left child
            if (i < arr.length && arr[i] != null) {
                current.left = new BinaryTreeNode<Integer>(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // right child
            if (i < arr.length && arr[i] != null) {
                current.right = new BinaryTreeNode<Integer>(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    // Pretty print binary tree (rotated)
    public static void printTree(BinaryTreeNode<Integer> node, String prefix, boolean isLeft) {
        if (node == null) return;

        System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.value);
        printTree(node.left, prefix + (isLeft ? "│   " : "    "), true);
        printTree(node.right, prefix + (isLeft ? "│   " : "    "), false);
    }
    
    public static void main(String[] args) {
        // Example input like LeetCode: [10,2,10,20,1,null,-25,null,null,null,null,3,4]
        Integer[] arr = {10, 2, 10, 20, 1, null, -25, null, null, null, null, 3, 4};
        
        BinaryTreeNode<Integer> root = buildTree(arr);
        printTree(root, "", true);

        System.out.println(maxPathSum(root));
    }


}

