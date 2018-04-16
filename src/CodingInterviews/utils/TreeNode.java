package CodingInterviews.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 12/23/2016.
 */
public class TreeNode<T>{
    private List<TreeNode<T>> children;
    private T val;

    public TreeNode(T val) {
        this.val = val;
        children = new ArrayList<>();
    }

    public TreeNode(List<TreeNode<T>> children, T val) {

        this.val = val;
        this.children = children;
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode<T>> children) {
        this.children = children;
    }

    public void addChild(TreeNode<T> child) {
        children.add(child);
    }

    public int childrenSize() {
        return children.size();
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public void removeChild(TreeNode<T> child) {
        children.remove(child);
    }

    public T getValue() {
        return val;
    }

    public void setValue(T val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "children=" + children +
                ", val=" + val +
                '}';
    }
}

