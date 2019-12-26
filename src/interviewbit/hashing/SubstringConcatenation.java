package interviewbit.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * You are given a string, S, and a list of words, L, that are all of the same length.
 *
 * Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
 *
 * Example :
 *
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 */
public class SubstringConcatenation {
    public ArrayList<Integer> findSubstring(String A, final List<String> B) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : B) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int wLen = B.get(0).length();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= A.length() - B.size() * wLen; i++) {
            if (isValid(A.substring(i), B.size(), (HashMap<String, Integer>) map.clone(), wLen)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean isValid(String A, int words, HashMap<String, Integer> map, int wLen) {
        for (int i = 0; i < words * wLen; i += wLen) {
            String w = A.substring(i, i + wLen);
            if (!map.containsKey(w)) {
                return false;
            }
            int occ = map.get(w);
            if (occ == 1) {
                map.remove(w);
            } else {
                map.put(w, occ - 1);
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] st) {
        SubstringConcatenation q = new SubstringConcatenation();
        String A = "abbaccaaabcabbbccbabbccabbacabcacbbaabbbbbaaabaccaacbccabcbababbbabccabacbbcabbaacaccccbaabcabaabaaaabcaabcacabaa";
        List<String> B = Arrays.asList("cac", "aaa", "aba", "aab", "abc");
        System.out.println(q.findSubstring(A, B));
    }
}
