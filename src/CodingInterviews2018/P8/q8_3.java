package CodingInterviews2018.P8;

public class q8_3 {

    private static int magicIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        return magicIndex(arr, 0, arr.length - 1);
    }

    private static int magicIndex(int[] arr, int from, int to) {
        if (from > to)
            return -1;
        int mid = (from + to) / 2;
        if (arr[mid] == mid)
            return mid;
        int right = magicIndex(arr, Math.max(arr[mid], mid + 1), to);
        if (right != -1)
            return right;
        return magicIndex(arr, from, Math.min(arr[mid], mid - 1));
    }

    public static void main(String[] st) {
        int[] data = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        int index = magicIndex(data);
    }

}
