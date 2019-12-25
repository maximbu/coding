package CodingInterviews.P8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by max on 12/27/2016.
 */
public class q8_8 {
    public static Set<String> permutationsWithDupes(String st) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < st.length(); i++) {
            char c = st.charAt(i);
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }
        return permutationsWithDupes(map, "", st.length());
    }

    private static HashSet<String> permutationsWithDupes(HashMap<Character, Integer> map, String prefix, int iter) {
        if (iter == 0) {
            HashSet<String> t = new HashSet<>();
            t.add(prefix);
            return t;
        }
        HashSet<String> t = new HashSet<>();
        for (Character c : map.keySet()) {
            int count = map.get(c);
            if (count > 0) {
                map.put(c, count - 1);
                t.addAll(permutationsWithDupes(map, prefix + c, iter - 1));
                map.put(c, count);
            }
        }
        return t;
    }

    public static void main(String[] st) {
        Set<String> ans = permutationsWithDupes("aaaaaaaaaaaaaaaaaaaaab");
    }
}
