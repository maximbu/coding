package P4;

import utils.BinTreeNode;

import static P4.q4_2.createMinimalBST;

/**
 * Created by max on 12/24/2016.
 */
public class q4_8 {
    public static <T> boolean contains (BinTreeNode<T> root , BinTreeNode<T> node){
        if(node == null)
            return true;
        if(root == null)
            return false;
        if(root.getVal() == node.getVal())
            return true;
        return contains(root.getLeft(),node) || contains(root.getRight(),node);
    }


    public static <T> BinTreeNode<T> commonAncessor(BinTreeNode<T> root , BinTreeNode<T> n1 , BinTreeNode<T> n2 ) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;

        if(!contains(root,n1) || !contains(root,n2)){
            return null;
        }

        if(n1 == n2) return n1;


        while (root != null) {
            boolean isN1OnLeft = contains(root.getLeft(), n1);
            boolean isN2OnLeft = contains(root.getLeft(), n2);

            if (isN1OnLeft != isN2OnLeft){
                return root;
            }
            root = isN1OnLeft ? root.getLeft() : root.getRight();
        }

        return null;
    }

    public static void main(String[] st){
        int[] array = new int[27];
        for (int i = 0; i < 27; i++) {
            array[i] = i;
        }
        BinTreeNode<Integer> tree = createMinimalBST(array);
        BinTreeNode<Integer> t = commonAncessor(tree,new BinTreeNode<>(8),new BinTreeNode<>(1));


        BinTreeNode<Integer> n20 = new BinTreeNode<>(20);
        BinTreeNode<Integer> n10 = new BinTreeNode<>(10);
        BinTreeNode<Integer> n30 = new BinTreeNode<>(30);
        BinTreeNode<Integer> n25 = new BinTreeNode<>(25);

        n20.setLeft(n10);
        n20.setRight(n30);
        n10.setRight(n25);
        BinTreeNode<Integer> t2 = commonAncessor(n20,n10,n25);

    }
}
