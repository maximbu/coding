package utils;

/**
 * Created by max on 12/23/2016.
 */
public class ParentBinTreeNode<T> extends BinTreeNode<T>{
    private ParentBinTreeNode<T> parent;

    public ParentBinTreeNode(T val) {
        super(val);
    }

    public ParentBinTreeNode(ParentBinTreeNode<T> parent,ParentBinTreeNode<T> left, ParentBinTreeNode<T> right, T val) {
        super(left,right,val);
        this.parent = parent;
    }

    public ParentBinTreeNode<T> getParent() {
        return parent;
    }

    public void setParent(ParentBinTreeNode<T> parent) {
        this.parent = parent;
    }

    @Override
    public ParentBinTreeNode<T> getLeft() {
        return (ParentBinTreeNode<T>)super.getLeft();
    }

    public void setLeft(ParentBinTreeNode<T> left) {
        left.setParent(this);
        super.setLeft(left);
    }


    @Override
    public ParentBinTreeNode<T> getRight() {
        return (ParentBinTreeNode<T>)super.getRight();
    }

    public void setRight(ParentBinTreeNode<T> right) {
        right.setParent(this);
        super.setRight(right);
    }

    @Override
    public String toString() {
        String parentRep = "null";
        if (parent != null) {
            parentRep = parent.getVal().toString();
        }
        return "ParentBinTreeNode{" +
                "parent=" + parentRep +
                "} " + super.toString();
    }
}

