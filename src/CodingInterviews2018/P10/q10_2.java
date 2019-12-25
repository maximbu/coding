package CodingInterviews2018.P10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class q10_2 {
    public static void main(String[] st) {
        String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
        String[] array2 = sortAnagrams(array);
        System.out.println(Arrays.toString(array2));
    }

    private static String[] sortAnagrams(String[] st) {
        var map = new HashMap<String, List<String>>();
        for (String s : st) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            var list = map.getOrDefault(sorted, new ArrayList<>());
            list.add(s);
            map.putIfAbsent(sorted, list);
        }
        var ans = new ArrayList<String>();
        map.values().forEach(ans::addAll);
        return ans.toArray(new String[0]);
    }

}
