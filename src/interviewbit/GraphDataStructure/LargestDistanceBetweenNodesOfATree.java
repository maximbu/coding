package interviewbit.GraphDataStructure;

import java.util.ArrayList;
import java.util.Arrays;

public class LargestDistanceBetweenNodesOfATree {

    public int solve(ArrayList<Integer> A) {
        int[] maxDist = new int[A.size()];
        int[] maxLen = new int[A.size()];
        int maxDistance = 0;
        for (int i = A.size() - 1; i > 0; --i) {
            int currentLength = maxLen[i] + 1;
            int p = A.get(i);
            maxDist[p] = Math.max(maxDist[p], currentLength + maxLen[p]);
            maxLen[p] = Math.max(maxLen[p], currentLength);
            maxDistance = Math.max(maxDistance, maxDist[p]);
        }
        return maxDistance;
    }

    public static void main(String[] st) {
        LargestDistanceBetweenNodesOfATree q = new LargestDistanceBetweenNodesOfATree();
        Integer[] A = {-1, 0};
        System.out.println(q.solve(new ArrayList<>(Arrays.asList(A))));

        Integer[] C = {-1, 0, 1};
        System.out.println(q.solve(new ArrayList<>(Arrays.asList(C))));

        Integer[] B = {-1, 0, 1, 1, 2, 0, 5, 0, 3, 0, 0, 2, 3, 1, 12, 14, 0, 5, 9, 6, 16, 0, 13, 4, 17, 2, 1, 22, 14, 20, 10, 17, 0, 32, 15, 34, 10, 19, 3, 22, 29, 2, 36, 16, 15, 37, 38, 27, 31, 12, 24, 29, 17, 29, 32, 45, 40, 15, 35, 13, 25, 57, 20, 4, 44, 41, 52, 9, 53, 57, 18, 5, 44, 29, 30, 9,
                29, 30, 8, 57, 8, 59, 59, 64, 37, 6, 54, 32, 40, 26, 15, 87, 49, 90, 6, 81, 73, 10, 8, 16};
        System.out.println(q.solve(new ArrayList<>(Arrays.asList(B))));
    }
}
