package GeneralAlgos;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by max on 1/5/2017.
 */
public class Queries {
    int[] nextBiggerNum;
    int[] numbers;
    int n;

    public Queries(int n) {
        this.n = n;
        Random r = new Random();
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = r.nextInt(100);
        }
        init();
    }


    public void init() {
        nextBiggerNum = new int[n];
        for (int i = 0; i < n; i++) {
            nextBiggerNum[i] = findNextBigger(i);
        }
    }

    private int findNextBigger(int ind) {
        for (int i = ind; i < n; i++) {
            if (numbers[i] > numbers[ind]) {
                return i;
            }
        }
        return -1;
    }

    public int naiveMaxInRange(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex < 0 || fromIndex > numbers.length || toIndex > numbers.length || fromIndex > toIndex) {
            throw new RuntimeException();
        }
        int max = numbers[fromIndex];
        for (int i = fromIndex; i < toIndex; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public int maxInRange(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex < 0 || fromIndex > numbers.length || toIndex > numbers.length || fromIndex > toIndex) {
            throw new RuntimeException();
        }
        int start = nextBiggerNum[fromIndex];
        int highestInd = fromIndex;
        while (start < toIndex) {
            if (start == -1) {
                break;
            }
            highestInd = start;
            start = nextBiggerNum[start];
        }
        return numbers[highestInd];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("numbers=" + Arrays.toString(numbers));
        sb.append("\n");
        sb.append("nextBiggerNum=" + Arrays.toString(nextBiggerNum));
        return sb.toString();
    }

    public static void main(String[] st) {
        int n = 3000;
        Queries q = new Queries(n);
        System.out.println(q);
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int max = q.maxInRange(i, j);
                int realMax = q.naiveMaxInRange(i, j);
                if (max != realMax) {
                    System.out.println("error");
                    max = q.maxInRange(i, j);
                    realMax = q.naiveMaxInRange(i, j);
                }
            }
        }
    }


}

