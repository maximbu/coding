package interviewbit.GraphDataStructure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * There are a total of N courses you have to take, labeled from 1 to N. Some courses may have prerequisites, for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2].
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses. return 1/0 if it is possible/not possible.
 * The list of prerequisite pair are given in two integer arrays B and C where B[i] is a prerequisite for C[i].
 *
 *  Example: If N = 3 and the prerequisite pairs are [1,2] and [2,3], then you can finish courses in the following order: 1, 2 and 3. But if N = 2 and the prerequisite pairs are [1,2] and [2,1], then it is not possible for you to finish all the courses.
 */
public class PossibilityOfFinishingAllCoursesGivenPreRequisites {

    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < B.size(); i++) {
            if (set.add(B.get(i))) {
                HashSet<Integer> tmp = new HashSet<>();
                if (!fillDep(B, C, tmp, B.get(i))) {
                    return 0;
                }
                set.addAll(tmp);
            }
        }
        return 1;
    }

    private boolean fillDep(ArrayList<Integer> B, ArrayList<Integer> C, HashSet<Integer> set, int start) {
        LinkedList<Integer> dep = new LinkedList<>();
        dep.add(start);
        while (!dep.isEmpty()) {
            int x = dep.removeFirst();
            for (int k = 0; k < B.size(); k++) {
                if (B.get(k) == x) {
                    dep.addLast(C.get(k));
                    if (!set.add(C.get(k))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
