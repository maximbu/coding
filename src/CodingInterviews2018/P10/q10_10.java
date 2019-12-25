package CodingInterviews2018.P10;

import java.util.Arrays;

public class q10_10 {
    private static class StreamRank {
        private static class RankTreeNode {
            int val;
            int rank;
            RankTreeNode left;
            RankTreeNode right;

            public RankTreeNode(int val) {
                this.val = val;
            }

            public void add(int x) {
                if (val < x) {
                    if (right == null) {
                        right = new RankTreeNode(x);
                    } else {
                        right.add(x);
                    }
                } else {
                    rank++;
                    if (left == null) {
                        left = new RankTreeNode(x);
                    } else {
                        left.add(x);
                    }
                }
            }

            public int getTotalRank(int x) {
                return getTotalRank(this, x, 0);
            }

            private int getTotalRank(RankTreeNode node, int x, int total) {
                if (node == null)
                    return -1;
                if (x == node.val)
                    return total + node.rank;
                if (node.val > x)
                    return getTotalRank(node.left, x, total);
                else
                    return getTotalRank(node.right, x, total + node.rank);
            }

            public int getRank() {
                return rank;
            }
        }

        private RankTreeNode tree;

        public int getRankOfNumber(int x) {
            return tree.getTotalRank(x);
        }

        public void track(int x) {
            if (tree == null) {
                tree = new RankTreeNode(x);
            } else {
                tree.add(x);
            }
        }

    }


    public static void main(String[] args) {
        StreamRank st = new StreamRank();
        int size = 100;
        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = (int) (Math.random() * size);
            st.track(list[i]);
        }

        int[] tracker = new int[size];
        for (int v : list) {
            int rank = st.getRankOfNumber(v);
            tracker[rank] = v;
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
