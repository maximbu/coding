package interviewbit.Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes’ values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * Example :
 * Given binary tree
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return
 *
 * [
 *          [3],
 *          [20, 9],
 *          [15, 7]
 * ]
 */
public class ZigZagLevelOrderTraversalBT {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(A == null) return ans;
        ArrayList<TreeNode> curr;
        ArrayList<TreeNode> prev = new ArrayList<>();
        prev.add(A);
        boolean leftToRight = true;
        while(!prev.isEmpty()){
            Stream<Integer> st = prev.stream().map(t->t.val);
            ArrayList<Integer> tmp = st.collect(Collectors.toCollection(ArrayList::new));
            if(!leftToRight){
                Collections.reverse(tmp);
            }
            ans.add(tmp);
            curr = new ArrayList<>();
            leftToRight = !leftToRight;
            for(TreeNode p:prev){
                if(p.left != null){
                    curr.add(p.left);
                }
                if(p.right != null){
                    curr.add(p.right);
                }
            }
            prev = new ArrayList<>(curr);
        }
        return ans;
    }
}
