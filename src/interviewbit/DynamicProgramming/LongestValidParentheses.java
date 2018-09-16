package interviewbit.DynamicProgramming;

import Algo.Stack;

/***
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 *
 * WAnother example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String A) {
        if (A == null || A.length() == 0)
            return 0;
        int maxLen = 0;
        int lastClosingBracket = -1;
        Stack<Integer> open = new Stack<>();

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '(') {
                open.push(i);
            } else {
                if (open.isEmpty()) {
                    lastClosingBracket = i;
                } else {
                    open.pop();
                    maxLen = Math.max(maxLen, i - (open.isEmpty() ? lastClosingBracket : open.peek()));
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] st) {
        LongestValidParentheses q = new LongestValidParentheses();
        System.out.println(q.longestValidParentheses("(()"));
        System.out.println(q.longestValidParentheses(")()())"));
        System.out.println(q.longestValidParentheses(")())()"));
        System.out.println(q.longestValidParentheses("((()())(())"));
        System.out.println(q.longestValidParentheses("((()())((())"));
        System.out.println(q.longestValidParentheses(")()))(())((())))))())()(((((())())((()())(())((((())))())((()()))(()(((()()(()((()()))(())()))((("));
    }
}
