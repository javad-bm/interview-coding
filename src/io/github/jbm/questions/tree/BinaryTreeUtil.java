import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeUtil {

    public static <T> BinaryTreeNode<T> BuildTree(T[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }

        BinaryTreeNode<T> root = new BinaryTreeNode<>(arr[0]);
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < arr.length) {
            BinaryTreeNode<T> current = queue.poll();
            if (current == null) continue;

            // Left child
            if (i < arr.length && arr[i] != null) {
                current.leftChild = new BinaryTreeNode<>(arr[i]);
                queue.offer(current.leftChild);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != null) {
                current.rightChild = new BinaryTreeNode<>(arr[i]);
                queue.offer(current.rightChild);
            }
            i++;
        }
        return root;
    }

    
    private static <T> void printTree(BinaryTreeNode<T> node, String prefix, boolean isTail) {
        if (node == null) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + "null");
            return;
        }
        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.value);
        
        // if both children are null, stop
        if (node.leftChild == null && node.rightChild == null) return;

        // children printing: left first, then right (right is the "tail")
        String childPrefix = prefix + (isTail ? "    " : "│   ");
        printTree(node.leftChild, childPrefix, false);
        printTree(node.rightChild, childPrefix, true);
    }

    public static <T> void printTree(BinaryTreeNode<T> root) {
        printTree(root, "", true);
    }

}
