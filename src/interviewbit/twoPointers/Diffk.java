package interviewbit.twoPointers;

import java.util.ArrayList;

public class Diffk {
    public int diffPossible(ArrayList<Integer> A, int B) {
        int i = 0;
        int j = 1;
        while (i < A.size() && j < A.size()) {
            if (i == j) {
                j++;
                continue;
            }
            int diff = A.get(j) - A.get(i);
            if (diff == B) {
                return 1;
            }
            if (diff < B) {
                j++;
            } else {
                i++;
            }
        }
        return 0;
    }

    public static void main(String[] st) {
        Diffk q = new Diffk();
        var a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(2);
        a.add(3);
        a.add(4);
        int b = 0;
        System.out.println(q.diffPossible(a, b));
    }
}
