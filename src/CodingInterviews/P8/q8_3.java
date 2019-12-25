package CodingInterviews.P8;

/**
 * Created by max on 12/26/2016.
 */
public class q8_3 {
    public static int magicSequence1(int[] arr) {
        return magicSequence1(arr, 0, arr.length - 1);
    }

    private static int magicSequence1(int[] arr, int i, int j) {
        if (i > j) {
            return -1;
        }
        int mid = (i + j) / 2;
        if (arr[mid] < mid) {
            return magicSequence1(arr, mid + 1, j);
        } else if (arr[mid] > mid) {
            return magicSequence1(arr, i, mid - 1);
        }
        return mid;

    }

    public static void main(String[] st) {
        int[] data = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        int index = magicSequence1(data);
    }
}
