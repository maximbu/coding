package interviewbit.strings;

import java.util.ArrayList;

/**
 * Pretty print a json object using proper indentation.
 *
 * Every inner brace should increase one indentation to the following lines.
 * Every close brace should decrease one indentation to the same line and the following lines.
 * The indents can be increased with an additional ‘\t’
 * Example 1:
 *
 * Input : {A:"B",C:{D:"E",F:{G:"H",I:"J"}}}
 * Output :
 * {
 *     A:"B",
 *     C:
 *     {
 *         D:"E",
 *         F:
 *         {
 *             G:"H",
 *             I:"J"
 *         }
 *     }
 * }
 * Example 2:
 *
 * Input : ["foo", {"bar":["baz",null,1.0,2]}]
 * Output :
 * [
 *     "foo",
 *     {
 *         "bar":
 *         [
 *             "baz",
 *             null,
 *             1.0,
 *             2
 *         ]
 *     }
 * ]
 * [] and {} are only acceptable braces in this case.
 *
 * Assume for this problem that space characters can be done away with.
 *
 * Your solution should return a list of strings, where each entry corresponds to a single line. The strings should not have “\n” character in them.
 */
public class PrettyJson {
    public ArrayList<String> prettyJSON(String A) {
        ArrayList<String> ans = new ArrayList<>();
        int tabs = 0;
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            char x = A.charAt(i);
            if (x == ' ') continue;
            if (x == '[' || x == '{') {
                if (word.toString().length() > 0) {
                    ans.add(tabbed(word.toString(), tabs));
                }
                ans.add(tabbed("" + x, tabs++));
                word = new StringBuilder();
                continue;
            }
            if (x == ']' || x == '}') {
                if (word.toString().length() > 0) {
                    ans.add(tabbed(word.toString(), tabs));
                }
                String ending = "" + x;
                if (i + 1 < A.length() && A.charAt(i + 1) == ',') {
                    ending += ",";
                    i++;
                }
                ans.add(tabbed(ending, --tabs));
                word = new StringBuilder();
                continue;
            }
            word = new StringBuilder();
            while (i < A.length() &&
                    A.charAt(i) != '[' && A.charAt(i) != '{'
                    && A.charAt(i) != ']' && A.charAt(i) != '}') {
                if (A.charAt(i) != ' ') {
                    word.append(A.charAt(i));
                    if (A.charAt(i) == ',') {
                        ans.add(tabbed(word.toString(), tabs));
                        word = new StringBuilder();
                    }
                }
                i++;
            }
            i--;
        }
        return ans;
    }

    private String tabbed(String s, int tabs) {
        StringBuilder sb = new StringBuilder();
        while (tabs-- > 0) {
            sb.append('\t');
        }
        sb.append(s);
        return sb.toString();
    }

    public static void main(String[] st) {
        PrettyJson q = new PrettyJson();
        System.out.println(q.prettyJSON("{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}"));
        System.out.println(q.prettyJSON("{\"id\":100,\"firstName\":\"Jack\",\"lastName\":\"Jones\",\"age\":12}"));
    }
}
