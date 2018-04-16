package CodingInterviews.P4;

import CodingInterviews.utils.BinTreeNode;

/**
 * Created by max on 12/25/2016.
 */
public class q4_12 {
    public static int pathsWithSum(BinTreeNode<Integer> n, int sum){
        if(n == null){
            return 0;
        }
        int curr = findPathsWithSumFromRoot(n,sum,0);
        int left = pathsWithSum(n.getLeft(),sum);
        int right = pathsWithSum(n.getRight(),sum);
        return curr + left + right;
    }

    private static int findPathsWithSumFromRoot(BinTreeNode<Integer> n, int sum, int currSum){
        int cnt =0;
        if(n == null){
            return 0;
        }
        int totalSum = n.getVal() + currSum;
        if(totalSum  == sum){
            cnt++;
        }
        cnt += findPathsWithSumFromRoot(n.getLeft(),sum,totalSum);
        cnt += findPathsWithSumFromRoot(n.getRight(),sum,totalSum);
        return cnt;
    }

    public static void main(String[] st) {

        BinTreeNode<Integer> n10 = new BinTreeNode<>(10);
        BinTreeNode<Integer> n5 = new BinTreeNode<>(5);
        BinTreeNode<Integer> nm3 = new BinTreeNode<>(-3);
        BinTreeNode<Integer> n3 = new BinTreeNode<>(3);
        BinTreeNode<Integer> n2 = new BinTreeNode<>(2);
        BinTreeNode<Integer> n11 = new BinTreeNode<>(11);
        BinTreeNode<Integer> n3b = new BinTreeNode<>(3);
        BinTreeNode<Integer> nm2 = new BinTreeNode<>(-2);
        BinTreeNode<Integer> n1 = new BinTreeNode<>(1);


        n10.setLeft(n5);
        n10.setRight(nm3);
        n5.setLeft(n3);
        n5.setRight(n2);
        nm3.setRight(n11);
        n3.setLeft(n3b);
        n3.setRight(nm2);
        n2.setRight(n1);

        int cnt = pathsWithSum(n10,8);

    }

}
