package CodingInterviews2018.P5;

import java.util.stream.IntStream;

public class q5_6 {
    private static long conversion(int a, int b) {
        return IntStream.
                iterate(a ^ b, d -> d > 0, d -> d & (d - 1))
                .count();
    }

    public static void main(String[] st) {
        long c = conversion(29, 15);
    }
}
