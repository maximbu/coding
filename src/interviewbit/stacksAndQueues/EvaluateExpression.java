package interviewbit.stacksAndQueues;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Examples:
 *
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

public class EvaluateExpression {
    public int evalRPN(ArrayList<String> A) {
        Stack<Integer> stack = new Stack<>();
        for(String c:A){
            switch (c) {
                case "+": {
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y + x);
                    break;
                }
                case "-": {
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y - x);
                    break;
                }
                case "*": {
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y * x);
                    break;
                }
                case "/": {
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y / x);
                    break;
                }
                default:
                    stack.push(Integer.valueOf(c));
                    break;
            }
        }
        return stack.pop();
    }
}
