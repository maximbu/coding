package interviewbit.Trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes’ values.
 *
 * Example :
 *
 * Given binary tree
 *
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [3,2,1].
 *
 * Using recursion is not allowed.
 */
public class PostorderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> path = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        HashSet<TreeNode> seen = new HashSet<>();
        st.add(A);
        while(!st.isEmpty()){
            TreeNode n = st.peek();
            if(seen.add(n)) {
                if (n.right != null) {
                    st.push(n.right);
                }
                if (n.left != null) {
                    st.push(n.left);
                }
            }
            if((n.left == null || seen.contains(n.left)) && (n.right==null || seen.contains(n.right))){
                path.add(st.pop().val);
            }
        }

        return path;
    }

    public static void main(String[] st){
        PostorderTraversal q = new PostorderTraversal();
        TreeNode t7 = new TreeNode(7);
        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2);
        TreeNode t1 = new TreeNode(1);
        t1.right = t3;
        t1.left = t2;
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        t3.right=t7;
        System.out.println(q.postorderTraversal(t1));
    }
}
