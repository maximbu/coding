package hackerRank.interviewPrep.Arrays;

public class MinimumSwaps2 {

    static int minimumSwaps(int[] arr) {
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            int minElemInd = findMinElemInd(arr, i);
            if (minElemInd != i) {
                int tmp =  arr[i];
                arr[i] = arr[minElemInd];
                arr[minElemInd] = tmp;
                n++;
            }
        }
        return n;
    }

    private static int findMinElemInd(int[] arr, int from) {
        int min = Integer.MAX_VALUE;
        int ind = from;
        for (int i = from; i < arr.length; i++) {
            if(min > arr[i]){
                min = arr[i];
                ind = i;
            }
        }
        return ind;
    }

}
