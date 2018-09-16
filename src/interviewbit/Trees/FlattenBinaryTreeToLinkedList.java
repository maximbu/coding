package interviewbit.Trees;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * Example :
 * Given
 *
 *
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * The flattened tree should look like:
 *
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 * Note that the left child of all nodes should be NULL.
 */
public class FlattenBinaryTreeToLinkedList {
    public class Solution {
        public TreeNode flatten(TreeNode a) {
            if(a == null){
                return null;
            }
            TreeNode left = flatten(a.left);
            TreeNode right = flatten(a.right);
            a.left = null;
            a.right = left;
            if(left != null){
                getLastChild(left).right = right;
            }
            else{
                a.right = right;
            }
            return a;
        }

        private TreeNode getLastChild(TreeNode a) {
            while(a.right != null){
                a = a.right;
            }
            return a;
        }
    }

}
