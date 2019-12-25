package CodingInterviews2018.P8;

import java.util.HashSet;
import java.util.Set;

public class q8_4 {
    private static HashSet<HashSet<Integer>> addElemToPowerSet(Set<Integer> set) {
        if (set == null) {
            return null;
        }
        var ans = new HashSet<HashSet<Integer>>();
        ans.add(new HashSet<>());
        for (int x : set) {
            ans = addElemToPowerSet(x, ans);
        }
        return ans;
    }

    private static HashSet<HashSet<Integer>> addElemToPowerSet(int elemToAdd, HashSet<HashSet<Integer>> set) {
        var ans = new HashSet<HashSet<Integer>>();
        for (var x : set) {
            var copy = new HashSet<>(x);
            copy.add(elemToAdd);
            ans.add(x);
            ans.add(copy);
        }
        return ans;
    }


    public static void main(String[] st) {
        var a = new HashSet<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        var b = addElemToPowerSet(a);
    }
}
