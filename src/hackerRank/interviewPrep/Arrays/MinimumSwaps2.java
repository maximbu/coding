package hackerRank.interviewPrep.Arrays;

import java.util.stream.IntStream;

public class MinimumSwaps2 {

    // [7, 1, 3, 2, 4, 5, 6]
    // [1, 7, 3, 2, 4, 5, 6] [1,7]
    // [1, 2, 3, 7, 4, 5, 6] [2,7]
    // [1, 2, 3, 4, 7, 5, 6] [4,7]
    // [1, 2, 3, 4, 5, 7, 6] [5,7]
    // [1, 2, 3, 4, 5, 6, 7] [6,7]

    static int minimumSwaps(int[] arr) {
        int n;
        int[] ind = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            ind[arr[i]] = i;
        }
        return (int) IntStream.range(0, arr.length).filter(i -> wasSwapped(arr, ind, i)).count();
    }

    private static boolean wasSwapped(int[] arr, int[] ind, int i) {
        if (arr[i] != i + 1) {
            int tmp = arr[i];
            arr[i] = i + 1;
            arr[ind[i + 1]] = tmp;
            ind[tmp] = ind[i + 1];
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        //int[] arr = {7, 1, 3, 2, 4, 5, 6};
        //int[] arr = {4,3,1,2};
        int[] arr = {2 ,3 ,4 ,1 ,5};
        System.out.println(minimumSwaps(arr));
    }
}
