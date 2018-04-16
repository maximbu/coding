package CodingInterviews.P10;

import java.util.Arrays;

/**
 * Created by max on 12/31/2016.
 */
public class q10_10 {
    public static class RankTreeNode{
        RankTreeNode left;
        RankTreeNode right;
        int val;
        int rank;

        public RankTreeNode(int val) {
            this.val = val;
        }

        public RankTreeNode getLeft() {
            return left;
        }

        public void setLeft(RankTreeNode left) {
            this.left = left;
        }

        public RankTreeNode getRight() {
            return right;
        }

        public void setRight(RankTreeNode right) {
            this.right = right;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        @Override
        public String toString() {
            return "RankTreeNode{" +
                    "left=" + left +
                    ", right=" + right +
                    ", val=" + val +
                    ", rank=" + rank +
                    '}';
        }

        public void addTreeNode(RankTreeNode t) {
            if (t.val <= val) {
                rank++;
                if (left == null) {
                    left = t;
                } else {
                    left.addTreeNode(t);
                }
            } else {
                if (right == null) {
                    right = t;
                } else {
                    right.addTreeNode(t);
                }
            }
        }

        public int getTotalRank(int t){
            int r = 0;
            RankTreeNode curr = this;
            while (curr != null){
                if(t == curr.val){return r+curr.rank;}
                if(t < curr.val){
                    curr = curr.left;
                }
                else {
                    r+=curr.rank;
                    curr = curr.right;
                }
            }
            return -1;
        }
    }


    private static RankTreeNode root = null;

    public static void track(int number) {
        if (root == null) {
            root = new RankTreeNode(number);
        } else {
            root.addTreeNode(new RankTreeNode(number));
        }
    }

    public static int getRankOfNumber(int number) {
        return root.getTotalRank(number);
    }


    public static void main(String[] args) {
        int size = 100;
        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = (int)(Math.random()*size);
            track(list[i]);
        }

        int[] tracker = new int[size];
        for (int v : list) {
            tracker[getRankOfNumber(v)] = v;
        }

        for (int i = 0; i < tracker.length - 1; i++) {
            if (tracker[i] != 0 && tracker[i + 1] != 0 && tracker[i] > tracker[i + 1]) {
                System.out.println("ERROR at " + i);
            }
        }

        System.out.println("Array: " + Arrays.toString(list));
        System.out.println("Ranks: " + Arrays.toString(tracker));
    }
}
