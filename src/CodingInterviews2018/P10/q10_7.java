package CodingInterviews2018.P10;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.BitSet;

public class q10_7 {
    public static void main(String[] st) {
        try {
            Integer[] arr = Files.lines(Paths.get(System.getProperty("user.dir"), "src",
                    "CodingInterviews2018/P10", "input.txt")).map(Integer::parseInt).toArray(Integer[]::new);

            System.out.println(missingNumberA(arr));
            System.out.println(missingNumberA(new Integer[]{0, 1, 5, 2, 4, 3}));

            System.out.println(missingNumberB(arr));
            System.out.println(missingNumberB(new Integer[]{0, 1, 5, 2, 4, 3}));
        } catch (Exception ex) {
            throw new IllegalStateException("File not found");
        }
    }

    private static int missingNumberA(Integer[] arr) {
        BitSet bits = new BitSet();
        for (int x : arr) {
            bits.set(x);
        }
        for (int i = 0; i < bits.length(); i++) {
            if (!bits.get(i)) {
                return i;
            }
        }
        return bits.length();
    }

    private static int missingNumberB(Integer[] arr) {
        BitSet b = new BitSet();
        int bucketSize = 1 << 20;
        int[] buckets = new int[1 << 12];
        for (int x : arr) {
            buckets[x / bucketSize]++;
        }
        int from = 0;
        int to = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] < bucketSize) {
                from = bucketSize * i;
                to = from + bucketSize;
                break;
            }
        }
        for (int x : arr) {
            if (x <= to && x >= from)
                b.set(x % bucketSize);
        }
        for (int i = 0; i < b.length(); i++) {
            if (!b.get(i)) {
                return from + i;
            }
        }
        return b.length();
    }


}
