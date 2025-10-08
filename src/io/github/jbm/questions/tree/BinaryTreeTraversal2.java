import java.util.*;

public class BinaryTreeTraversal2 {
    
    public static <T> List<T> dfs(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<>();       
        dfsRecursive(root, result);
        return result;
    }
    
    private static <T> void dfsRecursive(BinaryTreeNode<T> node, List<T> result) {
        if (node == null) {
            return;
        }       
        result.add(node.value);
        dfsRecursive(node.leftChild, result);       
        dfsRecursive(node.rightChild, result);
    }

    public static <T> List<T> dfsStack(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (root == null) return result;

        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        stack.push(root);
        while (! stack.isEmpty()) {
            BinaryTreeNode<T> node = stack.pop();
            result.add(node.value);
        
            if (node.rightChild != null) stack.push(node.rightChild);
            if (node.leftChild  != null) stack.push(node.leftChild);            
        }
        return result;
    }

    public static <T> int findLongestPath(BinaryTreeNode<T> root) {
        return findLongestPathRecursive(root);
    }
    
    private static <T> int findLongestPathRecursive(BinaryTreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        int rightLenght = findLongestPathRecursive(node.rightChild);
        int leftLength = findLongestPathRecursive(node.leftChild);

        return 1 + Math.max(rightLenght, leftLength);    
    }

    public static <T> List<T> findLongestPathNodes(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<T> rightList = findLongestPathNodes(root.rightChild);
        List<T> lefList = findLongestPathNodes(root.leftChild);

        result.add(root.value);
        if (rightList.size() > lefList.size()) {
            result.addAll(rightList);
        } else {
            result.addAll(lefList);
        }       
        return result;
    }
    

    // BFS
    public static <T> List<T> bfs(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);

        while(! queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                BinaryTreeNode<T> node = queue.poll();
                result.add(node.value);
                
                if (node.leftChild != null) queue.offer(node.leftChild);
                if (node.rightChild != null) queue.offer(node.rightChild);
            }            
        }
        return result;
    }
    
    
    // BFS
    public static <T> List<List<T>> getNodePerLevel(BinaryTreeNode<T> root) {
        List<List<T>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);

        while(! queue.isEmpty()) {
            List<T> levelNodes = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                BinaryTreeNode<T> node = queue.poll();
                levelNodes.add(node.value);
                
                if (node.leftChild != null) queue.offer(node.leftChild);
                if (node.rightChild != null) queue.offer(node.rightChild);
            }
            result.add(levelNodes);
        }
        
        return result;
    }


    public static void main(String[] args) {
        
        Integer[] arr = {
                10,
                5, 15,
                2, 7, null, 20,
                1, 3, 6, 8, null, null, 18, 25,
                30,45, null, null, null, null, null, null,
                40,42
            };        

        System.out.println("\n\n");
        
        BinaryTreeNode<Integer> tree1 = BinaryTreeUtil.BuildTree(arr);
        BinaryTreeUtil.printTree(tree1);

        System.out.println(dfs(tree1));
        System.out.println(dfsStack(tree1));
        
        
        // System.out.println(bfs(tree1));

        // System.out.println(getNodePerLevel(tree1));

        // System.out.println(findLongestPath(tree1));

        // System.out.println("\n\n");

        // System.out.println(findLongestPathNodes(tree1));



    }    
}
