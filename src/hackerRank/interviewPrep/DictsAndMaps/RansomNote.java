package hackerRank.interviewPrep.DictsAndMaps;

import java.util.HashMap;

public class RansomNote {
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> wordOccurrence = createMap(magazine);
        System.out.println(canCreateNote(wordOccurrence, note) ? "Yes" : "No");
    }

    private static HashMap<String, Integer> createMap(String[] magazine) {
        HashMap<String, Integer> wordOccurrence = new HashMap<>();
        for (String w : magazine) {
            wordOccurrence.put(w, wordOccurrence.getOrDefault(w, 0) + 1);
        }
        return wordOccurrence;
    }

    private static boolean canCreateNote(HashMap<String, Integer> wordOccurrence, String[] note) {
        for (String w : note) {
            int val = wordOccurrence.getOrDefault(w, 0);
            if (val == 0) return false;
            wordOccurrence.put(w, val - 1);
        }
        return true;
    }
}
