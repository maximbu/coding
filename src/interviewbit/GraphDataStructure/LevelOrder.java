package interviewbit.GraphDataStructure;

import interviewbit.Trees.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by level).
 *
 * Example :
 * Given binary tree
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * Also think about a version of the question where you are asked to do a level order traversal of the tree when depth of the tree is much greater than number of nodes on a level.
 */

public class LevelOrder {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<TreeNode> currLevel = new ArrayList<>();
        currLevel.add(A);
        ArrayList<TreeNode> prevLevel = currLevel;

        while(true){
            ans.add(new ArrayList<>(currLevel.stream().map(t -> t.val).collect(Collectors.toList())));
            currLevel = new ArrayList<>();
            for(TreeNode p : prevLevel){
                if(p.left != null){
                    currLevel.add(p.left) ;
                }
                if(p.right != null){
                    currLevel.add(p.right) ;
                }
            }
            prevLevel = currLevel;
            if(currLevel.isEmpty()){
                return ans;
            }
        }
    }
}
