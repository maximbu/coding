package interviewbit.stacksAndQueues;

import java.util.Stack;

/**
 * Given a string S, reverse the string using stack.
 *
 * Example :
 *
 * Input : "abc"
 * Return "cba"
 */
public class ReverseString {

  public String reverseString(String A) {
    Stack<Character> s = new Stack<>();
    for (char c : A.toCharArray()) {
      s.push(c);
    }
    StringBuilder sb = new StringBuilder();
    while (!s.isEmpty()) {
      sb.append(s.pop());
    }
    return sb.toString();
  }
}
