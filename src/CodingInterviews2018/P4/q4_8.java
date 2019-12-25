package CodingInterviews2018.P4;

import CodingInterviews.utils.BinTreeNode;
import CodingInterviews.utils.ParentBinTreeNode;

import java.util.stream.IntStream;

import static CodingInterviews2018.P4.q4_2.minimalTree;

public class q4_8 {
    private static <T> ParentBinTreeNode<T> commonAncessor(ParentBinTreeNode<T> a, ParentBinTreeNode<T> b) {
        int hA = getHeight(a);
        int hB = getHeight(b);
        while (hA > hB) {
            a = a.getParent();
            hA--;
        }
        while (hB > hA) {
            b = b.getParent();
            hB--;
        }
        while (a != b) {
            a = a.getParent();
            b = b.getParent();
        }
        return a;
    }


    private static <T> BinTreeNode<T> commonAncessorNoParent(BinTreeNode<T> root, BinTreeNode<T> a, BinTreeNode<T> b) {
        if (root == null || a == null || b == null || root == a || root == b)
            return root;
        boolean isAOnLeft = reachable(root.getLeft(), a);
        boolean isBOnLeft = reachable(root.getLeft(), b);

        if (isAOnLeft != isBOnLeft)
            return root;

        return commonAncessorNoParent(isAOnLeft ? root.getLeft() : root.getRight(), a, b);
    }

    private static <T> boolean reachable(BinTreeNode<T> root, BinTreeNode<T> a) {
        return a == null || root != null && (root == a || reachable(root.getLeft(), a) || reachable(root.getRight(), a));
    }


    private static <T> int getHeight(ParentBinTreeNode<T> a) {
        int ans = -1;
        while (a != null) {
            a = a.getParent();
            ans++;
        }
        return ans;
    }


    public static void main(String[] st) {
        ParentBinTreeNode<Integer> n20 = new ParentBinTreeNode<>(20);
        ParentBinTreeNode<Integer> n8 = new ParentBinTreeNode<>(8);
        ParentBinTreeNode<Integer> n22 = new ParentBinTreeNode<>(22);
        ParentBinTreeNode<Integer> n4 = new ParentBinTreeNode<>(4);
        ParentBinTreeNode<Integer> n12 = new ParentBinTreeNode<>(12);
        ParentBinTreeNode<Integer> n10 = new ParentBinTreeNode<>(10);
        ParentBinTreeNode<Integer> n14 = new ParentBinTreeNode<>(14);
        n20.setLeft(n8);
        n20.setRight(n22);
        n8.setLeft(n4);
        n8.setRight(n12);
        n12.setLeft(n10);
        n12.setRight(n14);

        ParentBinTreeNode<Integer> e8 = commonAncessor(n4, n12);
        ParentBinTreeNode<Integer> e8_ = commonAncessor(n4, n14);
        ParentBinTreeNode<Integer> e20 = commonAncessor(n22, n14);


        BinTreeNode<Integer> tree = minimalTree(IntStream.range(0, 27).toArray());
        BinTreeNode<Integer> t = commonAncessorNoParent(tree, tree.getLeft().getLeft().getLeft(), tree.getLeft().getRight().getLeft());


        BinTreeNode<Integer> n_20 = new BinTreeNode<>(20);
        BinTreeNode<Integer> n_10 = new BinTreeNode<>(10);
        BinTreeNode<Integer> n_30 = new BinTreeNode<>(30);
        BinTreeNode<Integer> n_25 = new BinTreeNode<>(25);

        n_20.setLeft(n_10);
        n_20.setRight(n_30);
        n_10.setRight(n_25);
        BinTreeNode<Integer> t2 = commonAncessorNoParent(n_20, n_10, n_25);

    }
}
