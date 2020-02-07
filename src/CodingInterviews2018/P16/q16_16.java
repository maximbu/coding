package CodingInterviews2018.P16;

import java.util.Arrays;

public class q16_16 {

    private static SubSortResult subSortNaive(int[] arr) {
        int from = 0;
        int to = arr.length - 1;
        int[] tmp = arr.clone();
        Arrays.sort(tmp);
        while (arr[from] == tmp[from]) {
            from++;
        }
        while (arr[to] == tmp[to]) {
            to--;
        }
        return new SubSortResult(from, to);
    }

    private static SubSortResult subSort(int[] arr) {
        int from = 0;
        int to = arr.length - 1;
        int maxLeft = arr[from];
        int minRight = arr[to];

        // find last non increasing element
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < maxLeft) {
                from = i;
            } else {
                maxLeft = arr[i];
            }
        }

        // find first non decreasing element
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > minRight) {
                to = i;
            } else {
                minRight = arr[i];
            }
        }

        if (to < from) {
            int tmp = from;
            from = to;
            to = tmp;
        }

        return new SubSortResult(from, to);
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        System.out.println("SubSortResult for:" + Arrays.toString(arr) + " is:" + subSortNaive(arr));
        System.out.println("SubSortResult for:" + Arrays.toString(arr) + " is:" + subSort(arr));
    }
}
