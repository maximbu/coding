package P4;

import utils.BinTreeNode;

/**
 * Created by max on 12/23/2016.
 */
public class q4_2 {
    public static BinTreeNode<Integer>  createMinimalBST(int[] array) {
        return createMinimalBST(array, 0, array.length - 1);
    }


    public static BinTreeNode<Integer> createMinimalBST(int[] array,int start,int end) {
        int mid = (start + end)/2;
        BinTreeNode<Integer> node = new BinTreeNode<Integer>(array[mid]);
        if(start<mid) {
            node.setLeft(createMinimalBST(array, start, mid - 1));
        }
        if(mid<end) {
            node.setRight(createMinimalBST(array, mid + 1, end));
        }
        return node;
    }


    public static void main(String[] st){
        int [] array = new int[7];
        for(int i=0;i<7;i++){
            array[i]=i;
        }
        BinTreeNode<Integer> tree = createMinimalBST(array);

    }
}
