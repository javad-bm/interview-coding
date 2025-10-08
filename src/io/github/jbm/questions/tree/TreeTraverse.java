package io.github.jbm.questions.tree;

import java.util.*;

public class TreeTraverse {
    
    // Tree Traverse DFS - Recursive
    public static <T> void traverseDFSRecursive(TreeNode<T> root) {
        if (root == null) {
            return;
        }        
        
        System.out.println(root);
        for (TreeNode<T> child : root.children) {
            traverseDFSRecursive(child);
        }
    }

    // Tree Traverse DFS - Stack
    public static <T> void traverseDFSStack(TreeNode<T> root) {
        if (root == null) {
            return;
        }        
               
        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        stack.push(root);

        while (! stack.isEmpty()) {
            TreeNode<T> node = stack.poll();
            System.out.println(node);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }            
        }       
    }

    // Tree Traverse BFS
    public static <T> void traverseBFS(TreeNode<T> root) {
        if (root == null) {
            return;
        }        
               
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while (! queue.isEmpty()) {
            TreeNode<T> node = queue.poll();
            System.out.println(node);
            queue.addAll(node.children);
        }       
        
    }

    public static void main(String[] args) {
        
        // Example Tree
        TreeNode<String> root = new TreeNode<>("A");
        TreeNode<String> b = new TreeNode<>("B");
        TreeNode<String> c = new TreeNode<>("C");
        TreeNode<String> d = new TreeNode<>("D");
        TreeNode<String> e = new TreeNode<>("E");
        TreeNode<String> f = new TreeNode<>("F");
        TreeNode<String> g = new TreeNode<>("G");
        TreeNode<String> h = new TreeNode<>("H");

        root.children.add(b);
        root.children.add(c);

        b.children.add(d);
        b.children.add(e);
        b.children.add(f);

        f.children.add(g);
        g.children.add(h);

        /*
             A
            / \
           B   C
          /|\   
         D E F
              \
               G
                \
                 H
        */

        traverseDFSRecursive(root);
        // System.out.println("");
        // traverseDFSStack(root);
        // System.out.println("");
        // traverseBFS(root);
    }
}
