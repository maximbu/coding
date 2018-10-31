package interviewbit.stacksAndQueues;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class GenerateAllParentheses {

  public int isValid(String A) {
    Stack<Character> s = new Stack<>();
    for (char c : A.toCharArray()) {
      if (c == '(' || c == '[' || c == '{') {
        s.push(c);
      }
      if (c == ')' || c == ']' || c == '}') {
        if (s.isEmpty())
          return 0;
        char c2 = s.pop();
        if (c == ')' && c2 != '(' ||
                c == ']' && c2 != '[' ||
                c == '}' && c2 != '{') {
          return 0;
        }
      }
    }
    return s.isEmpty() ? 1 : 0;
  }
}
