package TopCoder;

import java.util.*;


public class Lexer {
    public String[] tokenize(String[] tokens, String input) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(tokens, Comparator.comparing(String::length).reversed());
        int currIn = 0;
        while (currIn < input.length()) {
            String match = null;
            for (String s : tokens) {
                if (s.length() + currIn <= input.length() && input.substring(currIn, s.length() + currIn).equals(s)) {
                    match = s;
                    ans.add(s);
                    break;
                }
            }
            if (match != null) {
                currIn = currIn + match.length();
            } else {
                currIn++;
            }
        }
        return ans.toArray(new String[0]);
    }
}