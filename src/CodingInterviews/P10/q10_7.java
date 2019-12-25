package CodingInterviews.P10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.BitSet;
import java.util.stream.Stream;

/**
 * Created by max on 12/30/2016.
 */
public class q10_7 {
    public static int getMissingNumA(String fileName) {
        BitSet bits = new BitSet(1 << 32);
        try {
            Stream<String> lines = Files.lines(Paths.get(System.getProperty("user.dir"), "src",
                    "CodingInterviews/P10", fileName));
            lines.forEach(t -> bits.set(Integer.parseInt(t)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < bits.size(); i++) {
            if (!bits.get(i)) return i;
        }
        return -1;
    }

    public static int getMissingNumB(String fileName) {
        int rangeSize = 1 << 20;
        int[] arr = new int[1 << 12];
        BitSet bits = new BitSet(rangeSize);
        try {
            Stream<String> lines = Files.lines(Paths.get(System.getProperty("user.dir"), "src",
                    "CodingInterviews/P10", fileName));
            lines.forEach(t -> arr[Integer.parseInt(t) / rangeSize]++);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int i = 0;
        for (; i < arr.length; i++) {
            if (arr[i] < rangeSize) break;
        }

        int minRange = i * rangeSize;
        int maxRange = (i + 1) * rangeSize;

        try {
            Stream<String> lines = Files.lines(Paths.get(System.getProperty("user.dir"), "src",
                    "CodingInterviews/P10", fileName));
            lines.forEach(t -> {
                int n = Integer.parseInt(t);
                if (n >= minRange && n < maxRange) {
                    bits.set(n - minRange);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (i = 0; i < bits.size(); i++) {
            if (!bits.get(i)) return i + minRange;
        }
        return -1;
    }

    public static void main(String[] st) {
        System.out.println(getMissingNumA("input.txt"));
        System.out.println(getMissingNumB("input.txt"));
    }
}
