package interviewbit.Backtracking;

import java.util.ArrayList;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.
 *
 * For example, given n = 3, a solution set is:
 *
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * Make sure the returned list of strings are sorted.
 */
public class GenerateAllParenthesesII {
    public ArrayList<String> generateParenthesis(int A) {
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        generateParenthesis(A,A,curr,ans);
        ans.sort(String::compareTo);
        return ans;
    }

    private void generateParenthesis(int left , int right , StringBuilder curr , ArrayList<String> ans) {
        if(left == 0 && right == 0)  {
            ans.add(curr.toString());
            return;
        }
        if(left == 0){
            StringBuilder st = new StringBuilder(curr.toString());
            while(right-- > 0){
                st.append(')');
            }
            ans.add(st.toString());
            return;
        }
        if(left < right){
            curr.append(')');
            generateParenthesis(left,right-1,curr,ans);
            curr.deleteCharAt(curr.length()-1);
        }
        curr.append('(');
        generateParenthesis(left-1,right,curr,ans);
        curr.deleteCharAt(curr.length()-1);
    }

    public static void main(String[] st) {
        GenerateAllParenthesesII q = new GenerateAllParenthesesII();
        System.out.println(q.generateParenthesis(3));
    }
}
