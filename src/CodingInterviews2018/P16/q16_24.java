package CodingInterviews2018.P16;

import java.util.*;

public class q16_24 {

    private static List<Pair<Integer, Integer>> pairsWithSumExtraMem(int[] a, int sum) {
        List<Pair<Integer, Integer>> ans = new LinkedList<>();
        HashMap<Integer, Integer> seen = new HashMap<>();  // count dups
        for (int x : a) {
            int diff = sum - x;
            for (int i = 0; i < seen.getOrDefault(diff, 0); i++) {
                ans.add(new Pair<>(x, diff));
            }
            seen.put(x, seen.getOrDefault(x, 0) + 1);
        }

        return ans;
    }

    private static List<Pair<Integer, Integer>> pairsWithSumSlower(int[] a, int sum) {
        List<Pair<Integer, Integer>> ans = new LinkedList<>();
        int[] b = a.clone();
        Arrays.sort(b);
        int from = 0;
        int to = b.length - 1;
        while (from < to) {
            if (b[from] + b[to] == sum) {
                int sameAsFrom = 1;
                int sameAsTo = 1;
                while (from < to && b[from] == b[from + 1]) {
                    from++;
                    sameAsFrom++;
                }
                while (from < to && b[to] == b[to - 1]) {
                    to--;
                    sameAsTo++;
                }
                int totalOcc = sameAsFrom * sameAsTo;
                for (int i = 0; i < totalOcc; i++) {
                    ans.add(new Pair<>(b[from], b[to]));
                }
                from++;
                to--;
            } else if (b[from] + b[to] < sum) {
                from++;
            } else {
                to--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] a = {4, 1, 2, 1, 1, 2, 2, 8, -4, -5, 7};
        int sum = 3;
        List<Pair<Integer, Integer>> pairs = pairsWithSumExtraMem(a, sum);
        System.out.printf("[Using extra memory] For array %s and sum %s pairs that can create this sum are %s%n", Arrays.toString(a), sum, pairs);
        List<Pair<Integer, Integer>> pairs2 = pairsWithSumSlower(a, sum);
        System.out.printf("[With sort] For array %s and sum %s pairs that can create this sum are %s%n", Arrays.toString(a), sum, pairs2);

        sum = 4;
        pairs = pairsWithSumExtraMem(a, sum);
        System.out.printf("[Using extra memory] For array %s and sum %s pairs that can create this sum are %s%n", Arrays.toString(a), sum, pairs);
        pairs2 = pairsWithSumSlower(a, sum);
        System.out.printf("[With sort] For array %s and sum %s pairs that can create this sum are %s%n", Arrays.toString(a), sum, pairs2);
    }
}
