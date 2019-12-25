package CodingInterviews2018.P8;

import java.util.ArrayList;
import java.util.HashMap;

public class q8_8 {

    private static ArrayList<String> permWithDups(String s) {
        var map = new HashMap<Character, Integer>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        var ans = new ArrayList<String>();
        permWithDups(map, "", s.length(), ans);
        return ans;
    }

    private static void permWithDups(HashMap<Character, Integer> map, String prefix, int remaining, ArrayList<String> ans) {
        if (remaining == 0) {
            ans.add(prefix);
            return;
        }
        for (char ch : map.keySet()) {
            int cnt = map.get(ch);
            if (cnt > 0) {
                map.put(ch, cnt - 1);
                permWithDups(map, prefix + ch, remaining - 1, ans);
                map.put(ch, cnt);
            }
        }
    }

    public static void main(String[] st) {
        var ans = permWithDups("abab");
    }

}
