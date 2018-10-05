package interviewbit.GraphDataStructure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

/**
 * There are n islands and there are many bridges connecting them. Each bridge has some cost attached to it.
 *
 * We need to find bridges with minimal cost such that all islands are connected.
 *
 * It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.
 *
 * Example :
 * Input
 *
 *          Number of islands ( n ) = 4
 *          1 2 1
 *          2 3 4
 *          1 4 3
 *          4 3 2
 *          1 3 10
 * In this example, we have number of islands(n) = 4 . Each row then represents a bridge configuration. In each row first two numbers represent the islands number which are connected by this bridge and the third integer is the cost associated with this bridge.
 *
 * In the above example, we can select bridges 1(connecting islands 1 and 2 with cost 1), 3(connecting islands 1 and 4 with cost 3), 4(connecting islands 4 and 3 with cost 2). Thus we will have all islands connected with the minimum possible cost(1+3+2 = 6).
 * In any other case, cost incurred will be more.
 */
public class CommutableIslands {

    private class UnionFind {
        int[] parent;
        int[] rank;

        int find(int i) {
            int p = parent[i];
            if (i == p) {
                return p;
            }
            parent[i] = find(p);
            return parent[i];
        }

        void union(int i, int j) {
            int root1 = find(i);
            int root2 = find(j);

            if (root2 == root1)
                return;

            if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else if (rank[root2] > rank[root1]) {
                parent[root1] = root2;
            } else {
                parent[root2] = root1;
                rank[root1]++;
            }
        }

        UnionFind(int max) {
            parent = new int[max];
            rank = new int[max];
            for (int i = 0; i < max; i++) {
                parent[i] = i;
            }
        }
    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        B.sort(Comparator.comparing(o -> o.get(2)));
        UnionFind connected = new UnionFind(A);
        int sum = 0;
        int bridges = 0;
        HashSet<Integer> found = new HashSet<>();
        for (ArrayList<Integer> b : B) {
            if (found.contains(b.get(0))
                    && found.contains(b.get(1))
                    && connected.find(b.get(0) - 1) == connected.find(b.get(1) - 1)) {
                continue;
            }
            bridges++;
            sum += b.get(2);
            found.add(b.get(0));
            found.add(b.get(1));
            connected.union(b.get(0) - 1, b.get(1) - 1);
            if (bridges == A - 1) {
                return sum;
            }
        }
        return -1;
    }
}
