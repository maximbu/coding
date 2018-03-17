package utils;

/**
 * Created by max on 12/23/2016.
 */
public class BinTreeNode<T>{
    private BinTreeNode<T> left;
    private BinTreeNode<T> right;
    private T val;

    public BinTreeNode(T val) {
        this.val = val;
    }

    public BinTreeNode(BinTreeNode<T> left, BinTreeNode<T> right, T val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    public BinTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinTreeNode<T> left) {
        this.left = left;
    }

    public BinTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinTreeNode<T> right) {
        this.right = right;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "BinTreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

