package io.github.jbm.questions.tree;

public class BinaryTreeNode<T> {
    T value;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;
    BinaryTreeNode (T value) { this.value = value; }
    BinaryTreeNode (T value, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
