package interviewbit.Trees;

import java.util.List;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 *  Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Example :
 *
 *
 * Given A : [1, 2, 3]
 * A height balanced BST  :
 *
 *       2
 *     /   \
 *    1     3
 */
public class SortedArrayToBalancedBst {
    public TreeNode sortedArrayToBST(final List<Integer> a) {
        return sortedArrayToBST(a, 0, a.size() - 1);
    }

    private TreeNode sortedArrayToBST(final List<Integer> a, int from, int to) {
        if (from > to) {
            return null;
        }

        int mid = (from + to) / 2;
        TreeNode root = new TreeNode(a.get(mid));
        root.left = sortedArrayToBST(a, from, mid - 1);
        root.right = sortedArrayToBST(a, mid + 1, to);
        return root;
    }
}
