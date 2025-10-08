package io.github.jbm.questions.tree;

import java.util.*;

public class TreeWidthPerLevel {

    public static <T> List<Integer> getWidthPerLevel(TreeNode<T> root) {
        List<Integer> width = new ArrayList<>();

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while (! queue.isEmpty()) {
            int levelWidth = queue.size();
            width.add(levelWidth);
            for (int i = 0; i < levelWidth; i++) {
                TreeNode<T> node = queue.poll();
                queue.addAll(node.children);
            }
        }

        return width;
    }

    // Implementing using BFS
    public static <T> List<List<TreeNode<T>>> getNodePerLevel(TreeNode<T> root) {
        List<List<TreeNode<T>>> nodePerLevel = new ArrayList<>();
        if (root == null) {
            return nodePerLevel;
        }

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        while(! queue.isEmpty()) {
            List<TreeNode<T>> nodeThisLevel = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode<T> node = queue.poll();
                nodeThisLevel.add(node);
                queue.addAll(node.children);
            }
            nodePerLevel.add(nodeThisLevel);
        }

        return nodePerLevel;
    }

    // Implementing using DFS
    public static <T> int findLongestPathLength(TreeNode<T> root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null || root.children.isEmpty()) {
            return 0;
        }

        int maxDepth = 0;
        for (TreeNode<T> child : root.children) {
            int childDepth = findLongestPathLength(child);
            maxDepth = Math.max(maxDepth, childDepth);
        }

        return maxDepth + 1;
    }

    // Implementing using DFS
    public static <T> List<TreeNode<T>> findLongestPath(TreeNode<T> root) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.children == null || root.children.isEmpty()) {
            List<TreeNode<T>> list = new ArrayList<>();
            list.add(root);
            return list;
        }

        List<TreeNode<T>> longestPath = null;
        int maxLength = 0;
        for (TreeNode<T> child : root.children) {
            List<TreeNode<T>> childPath = findLongestPath(child);
            if (childPath.size() > maxLength) {
                maxLength = childPath.size();
                longestPath = childPath;
            }
        }

        List<TreeNode<T>> result = new ArrayList<>();
        result.add(root);
        result.addAll(longestPath);
        return result;
    }


    public static void main(String[] args) {

        // Example Tree
        /*
             A
            / \
           B   C
          / \   \
         D   E   F
        */

        TreeNode<String> root = new TreeNode<>("A");
        TreeNode<String> b = new TreeNode<>("B");
        TreeNode<String> c = new TreeNode<>("C");
        TreeNode<String> d = new TreeNode<>("D");
        TreeNode<String> e = new TreeNode<>("E");
        TreeNode<String> f = new TreeNode<>("F");

        root.children.add(b);
        root.children.add(c);
        b.children.add(d);
        b.children.add(e);
        c.children.add(f);


        System.out.println(getWidthPerLevel(root)); // Output: [1, 2, 3]
        System.out.println(getNodePerLevel(root));
        System.out.println(findLongestPathLength(root));
        System.out.println(findLongestPath(root));

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

         root = new TreeNode<>("A");
         b = new TreeNode<>("B");
         c = new TreeNode<>("C");
         d = new TreeNode<>("D");
         e = new TreeNode<>("E");
         f = new TreeNode<>("F");
        TreeNode<String> g = new TreeNode<>("G");
        TreeNode<String> h = new TreeNode<>("H");

        root.children.add(b);
        root.children.add(c);
        b.children.add(d);
        b.children.add(e);
        b.children.add(f);
        f.children.add(g);
        g.children.add(h);


        System.out.println(getWidthPerLevel(root));
        System.out.println(getNodePerLevel(root));
        System.out.println(findLongestPathLength(root));
        System.out.println(findLongestPath(root));
    }
}
