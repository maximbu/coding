package interviewbit.Trees;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 * The first call to next() will return the smallest number in BST. Calling next() again will return the next smallest number in the BST, and so on.
 *
 *  Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * Try to optimize the additional space complexity apart from the amortized time complexity.
 */
public class BstIterator {
    Stack<TreeNode> min ;

    public BstIterator(TreeNode root) {
        min = new Stack<>();
        storeMin(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !min.isEmpty();
    }

    private void storeMin(TreeNode root){
        while(root != null){
            min.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = min.pop();
        storeMin(node.right);
        return node.val;
    }

    public static void main(String[] st){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        BstIterator i = new BstIterator(root);
        while (i.hasNext()) System.out.print(i.next());
    }
}
