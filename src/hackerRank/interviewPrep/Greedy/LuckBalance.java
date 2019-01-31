package hackerRank.interviewPrep.Greedy;

import java.util.ArrayList;
import java.util.Comparator;

public class LuckBalance {

    static int luckBalance(int k, int[][] contests) {
        int luck = 0;
        ArrayList<Integer> imp = new ArrayList<>();
        for (int[] c : contests) {
            if (c[1] == 1) {
                imp.add(c[0]);
            } else {
                luck += c[0];
            }
        }
        imp.sort(Comparator.reverseOrder());
        for (int i = 0; i < imp.size(); i++) {
            luck += imp.get(i) * (i < k ? 1 : -1);
        }
        return luck;
    }
}
