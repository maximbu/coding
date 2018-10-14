package interviewbit.Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers % 1003.
 *
 * Example :
 *
 *     1
 *    / \
 *   2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 *
 * Return the sum = (12 + 13) % 1003 = 25 % 1003 = 25.
 */
public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode A) {
        return sumNumbersBfs(A,0);
    }

    private int sumNumbersBfs(TreeNode a, int sum) {
        if (a == null) return 0;
        sum = (sum*10 + a.val) % 1003;

        if(a.left == null && a.right == null){
            return sum;
        }
        return (sumNumbersBfs(a.left,sum) + sumNumbersBfs(a.right,sum)) % 1003;
    }
/*
    public int sumNumbers2(TreeNode A) {
        if (A == null)
            return 0;
        int sum = 0;
        for (String s:getPath(A)){
            sum = (sum+ toInt(s))%1003;
        }
        return sum;
    }

    private int toInt(String s) {
        int x = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            x = (x*10 + s.charAt(i)-'0')%1003;
        }
        return x;
    }

    private List<String> getPath(TreeNode A) {
        List<String> ans = new ArrayList<>();
        if (A == null) {
            ans.add("");
            return ans;
        }
        if(A.left == null && A.right == null){
            ans.add(""+A.val);
            return ans;
        }

        if(A.left != null){
            List<String> left = getPath(A.left);
            ans.addAll(left);
        }
        if(A.right != null){
            List<String> right = getPath(A.right);
            ans.addAll(right);
        }

        List<String> fAns = new ArrayList<>();
        for (String x:ans) {
            fAns.add(x+A.val);
        }
        return fAns;
    }
*/

    public static void main(String[] st){
        SumRootToLeafNumbers q = new SumRootToLeafNumbers();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(q.sumNumbers(root));
        root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        System.out.println(q.sumNumbers(root));
        root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        System.out.println(q.sumNumbers(root));

    }
}
