package CodingInterviews2018.P10;

public class q10_3 {

    private static int searchInRotatedArray(int[] arr, int x) {
        int rotInd = findRotationIndex(arr, 0, arr.length - 1);
        int left = search(arr, x, 0, rotInd);
        if (left != -1)
            return left;
        return search(arr, x, rotInd + 1, arr.length - 1);
    }

    private static int search(int[] arr, int x, int from, int to) {
        if (from > to)
            return -1;
        int mid = (from + to) / 2;
        if (arr[mid] == x)
            return mid;
        return arr[mid] < x ? search(arr, x, mid + 1, to) : search(arr, x, from, mid - 1);
    }

    private static int findRotationIndex(int[] arr, int from, int to) {
        if (from > to)
            return 0;
        int mid = (from + to) / 2;
        if (mid == arr.length || arr[mid] > arr[mid + 1])
            return mid;
        return arr[mid] > arr[0] ? findRotationIndex(arr, mid + 1, to) : findRotationIndex(arr, from, mid - 1);
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 2, 2, 2, 2, 2, 2, 2};
        int[] b = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};

        System.out.println(searchInRotatedArray(a, 2));
        System.out.println(searchInRotatedArray(a, 3));
        System.out.println(searchInRotatedArray(a, 4));
        System.out.println(searchInRotatedArray(a, 1));
        System.out.println(searchInRotatedArray(a, 8));
        System.out.println(searchInRotatedArray(b, 15));
        System.out.println(searchInRotatedArray(b, 5));
    }
}

