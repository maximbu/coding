package hackerRank.interviewPrep.StacksAndQueues;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMaxRiddle {

    static long[] riddle(long[] arr) {
        // complete this function
        long[] ans = new long[arr.length];
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 1; i <= ans.length; i++) {
            pq.add(arr[i - 1]);
            ans[i - 1] = minMaxOfWindow(arr, i, pq);
        }
        return ans;
    }

    static long minMaxOfWindow(long[] arr, int size, PriorityQueue<Long> initPq) {
        PriorityQueue<Long> pq = new PriorityQueue<>(initPq);
        long max = pq.peek();
        for (int i = size; i < arr.length; i++) {
            pq.remove(arr[i - size]);
            pq.add(arr[i]);
            max = Math.max(max, pq.peek());
        }
        return max;
    }

    public static void main(String[] st) {
        System.out.println(Arrays.toString(riddle(new long[]{3, 5, 4, 7, 6, 2})));
    }
}
