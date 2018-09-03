package interviewbit.stacksAndQueues;

import java.util.Stack;

/**
 * Write a program to validate if the input string has redundant braces?
 * Return 0/1
 *
 * 0 -> NO
 * 1 -> YES
 * Input will be always a valid expression
 *
 * and operators allowed are only + , * , - , /
 *
 * Example:
 *
 * ((a + b)) has redundant braces so answer will be 1
 * (a + (a + b)) doesn't have have any redundant braces so answer will be 0
 */
public class RedundantBraces {
    public int braces(String A) {
        char[] chars = A.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c:chars){
            if(c == ')'){
                char bracket = stack.pop();
                if(bracket == '('){
                    return 1;
                }
                while(bracket != '('){
                    bracket = stack.pop();
                }
            }
            else if(c=='(' || c=='+' || c=='-' || c=='*' || c=='/'){
                stack.push(c);
            }
        }
        return 0;
    }
}
