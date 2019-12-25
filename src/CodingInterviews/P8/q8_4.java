package CodingInterviews.P8;

import java.util.ArrayList;


/**
 * Created by max on 12/27/2016.
 */
public class q8_4 {
    public static <T> ArrayList<ArrayList<T>> powerSet(ArrayList<T> set) {
        return powerSet(set, 0);
    }

    private static <T> ArrayList<ArrayList<T>> powerSet(ArrayList<T> set, int i) {
        if (set.size() == i) {
            ArrayList<ArrayList<T>> allSets = new ArrayList<>();
            allSets.add(new ArrayList<>());
            return allSets;
        }
        ArrayList<ArrayList<T>> allSetsWithoutI = powerSet(set, i + 1);
        ArrayList<ArrayList<T>> subSetsWithI = new ArrayList<>();
        for (ArrayList<T> subset : allSetsWithoutI) {
            ArrayList<T> newSubset = new ArrayList<>(subset);
            newSubset.add(set.get(i));
            subSetsWithI.add(newSubset);
        }
        subSetsWithI.addAll(allSetsWithoutI);
        return subSetsWithI;
    }

    public static <T> ArrayList<ArrayList<T>> powerSet2(ArrayList<T> set) {
        int combinations = 1 << set.size();
        ArrayList<ArrayList<T>> allSets = new ArrayList<>();
        while (combinations > 0) {
            combinations--;
            ArrayList<T> newSet = new ArrayList<T>();
            for (int i = 0; i < set.size(); i++) {
                if ((combinations & (1 << i)) != 0) {
                    newSet.add(set.get(i));
                }
            }
            allSets.add(newSet);
        }
        return allSets;
    }

    public static void main(String[] st) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        ArrayList<ArrayList<Integer>> b = powerSet(a);
        ArrayList<ArrayList<Integer>> b2 = powerSet2(a);
    }
}
