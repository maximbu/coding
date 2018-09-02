package CodingInterviews2018.P8;

import java.util.stream.IntStream;

public class q8_1 {
    private static int tripleStep(int x) {
        if (x < 3)
            return x;
        int[] a = new int[x + 1];
        IntStream.range(0, 3).forEach(i -> a[i] = i);
        IntStream.range(3, x + 1).forEach(i -> a[i] = a[i - 3] + a[i - 2] + a[i - 1]);
        return a[x];
    }

    public static void main(String[] st){
        for (int i = 0; i < 30; i++) {
            System.out.println(i + ": " + tripleStep(i));
        }
    }

}
