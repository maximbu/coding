package interviewbit.stacksAndQueues;

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * Examples:
 *
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * Note that absolute path always begin with ‘/’ ( root directory )
 * Path will not have whitespace characters.
 */
public class SimplifyDirectoryPath {
    public String simplifyPath(String A) {
        Stack<String> st = new Stack<>();
        String[] dirs = A.split("/");
        for (String d : dirs) {
            if (d.equals(".") || d.length() == 0) {
                continue;
            }
            if (d.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
                continue;
            }
            st.push(d);
        }
        if (st.isEmpty()) {
            return "/";
        }

        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.insert(0, "/" + st.pop());
        }
        return ans.toString();
    }

    public static void main(String[] st) {
        SimplifyDirectoryPath q = new SimplifyDirectoryPath();
        System.out.println(q.simplifyPath("/../"));
        System.out.println(q.simplifyPath("/a/b/c"));
        System.out.println(q.simplifyPath("/a/./b/../../c/"));
    }
}
