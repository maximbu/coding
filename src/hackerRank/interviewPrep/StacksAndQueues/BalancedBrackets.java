package hackerRank.interviewPrep.StacksAndQueues;

import java.util.Stack;

public class BalancedBrackets {
    static String isBalanced(String s) {
        Stack<Character> opening = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    opening.push(c);
                    break;
                case ')':
                    if (opening.isEmpty() || opening.pop() != '(')
                        return "NO";
                    break;
                case ']':
                    if (opening.isEmpty() || opening.pop() != '[')
                        return "NO";
                    break;
                case '}':
                    if (opening.isEmpty() || opening.pop() != '{')
                        return "NO";
                    break;
                default:
                    break;
            }
        }
        return opening.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] st){
        System.out.println(isBalanced("{[()]}"));
    }

}
