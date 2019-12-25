package CodingInterviews.P8;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by max on 12/27/2016.
 */
public class q8_7 {
    public static Set<String> permutations(String st) {
        return permutations(st, st.length() - 1);
    }

    private static Set<String> permutations(String st, int i) {
        if (i == 0) {
            HashSet<String> h = new HashSet<>();
            h.add(st.substring(0, 1));
            return h;
        }
        Set<String> withoutI = permutations(st, i - 1);
        char c = st.charAt(i);
        HashSet<String> ans = new HashSet<>();
        for (String s : withoutI) {
            for (int j = 0; j <= i; j++) {
                ans.add(s.substring(0, j) + c + s.substring(j, i));
            }
        }
        return ans;
    }

    public static void main(String[] st) {
        Set<String> ans = permutations("abcde");
    }
}
