package CodingInterviews2018.P17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class q17_4 {

    private static int missingNum(int[] arr) {
        return missingNum(Arrays.stream(arr).boxed().collect(Collectors.toList()), 0);
    }

    private static int missingNum(List<Integer> arr, int i) {
        if (i == Integer.SIZE) {
            return 0;
        }
        int bit = 1 << i;
        List<Integer> zeroes = new ArrayList<>(arr.size() / 2);
        List<Integer> ones = new ArrayList<>(arr.size() / 2);
        for (int x : arr) {
            if ((x & bit) == 0) {
                zeroes.add(x);
            } else {
                ones.add(x);
            }
        }
        if (zeroes.size() <= ones.size()) {
            int x = missingNum(zeroes, i + 1);
            return (x << 1);
        }
        int x = missingNum(ones, i + 1);
        return (x << 1) | 1;
    }


    public static void main(String[] args) {
        int[] a = new int[1000];
        Random r = ThreadLocalRandom.current();
        int missing = r.nextInt(a.length + 1);

        Arrays.setAll(a, i -> (i < missing) ? i : (i + 1));

        int ans = missingNum(a);
        System.out.printf("In array %s: %nmissing number is %d and function %s %n", Arrays.toString(a), missing, missing == ans ? "found it!" : "failed to find it!!!");
    }
}
