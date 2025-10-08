package io.github.jbm.questions.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
    T value;
    List<TreeNode<T>> children;

    public TreeNode(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        return value.toString();
    }    
}

