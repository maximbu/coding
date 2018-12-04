package hackerRank.interviewPrep.Sorting;

import java.util.Comparator;

public class SortingComparator {
    class Checker implements Comparator<Player> {
        public int compare(Player a, Player b) {
            int cmp = Integer.compare(b.score,a.score);
            if (cmp != 0) return cmp;
            return a.name.compareTo(b.name);
        }
    }

    private class Player {
        public int score;
        public String name;
    }
}
