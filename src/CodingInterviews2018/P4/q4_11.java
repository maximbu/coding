package CodingInterviews2018.P4;

import java.util.Random;

public class q4_11 {

    private static class RandomNode {

        private int size;
        private int val;
        private RandomNode left;
        private RandomNode right;

        public RandomNode(int x) {
            val = x;
            size = 1;
        }

        public void insert(int x) {
            if (x < val) {
                if (left != null) {
                    left.insert(x);
                } else {
                    left = new RandomNode(x);
                }
            } else {
                if (right != null) {
                    right.insert(x);
                } else {
                    right = new RandomNode(x);
                }

            }
            size++;
        }

        public RandomNode find(int x) {
            if (x == val) {
                return this;
            }
            if (x < val) {
                if (left != null) {
                    return left.find(x);
                }
                return null;
            }
            if (right != null)
                return right.find(x);
            return null;
        }


        public RandomNode getRandomNode() {
            int rand = new Random().nextInt(size);
            int leftSize = (left != null) ? left.size : 0;
            if (rand == leftSize)
                return this;
            if (rand < leftSize)
                return left.getRandomNode();
            else
                return right.getRandomNode();
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public RandomNode getLeft() {
            return left;
        }

        public void setLeft(RandomNode left) {
            this.left = left;
        }

        public RandomNode getRight() {
            return right;
        }

        public void setRight(RandomNode right) {
            this.right = right;
        }
    }


    public static void main(String[] args) {
        int[] counts = new int[10];
        for (int i = 0; i < 1000000; i++) {
            RandomNode tree = new RandomNode(1);
            int[] array = {0, 6, 2, 3, 9, 4, 5, 8, 7};
            for (int x : array) {
                tree.insert(x);
            }
            int d = tree.getRandomNode().getVal();
            counts[d]++;
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + ": " + counts[i]);
        }
    }
}

