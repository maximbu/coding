package GeneralAlgos;

import java.util.Arrays;

import static GeneralAlgos.QuickSort.sortRec;

/**
 * Created by max on 1/1/2017.
 */
public class BinSearch {
    public static int search(int[] a, int x) {
        int start = 0;
        int end = a.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (a[mid] == x) {
                return mid;
            }
            if (a[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int searchRec(int[] a, int x) {
        return searchRec(a, x, 0, a.length - 1);
    }

    private static int searchRec(int[] a, int x, int start, int end) {
        if (end < start) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (a[mid] == x) {
            return mid;
        }

        return a[mid] > x ? searchRec(a, x, start, mid - 1) : searchRec(a, x, mid + 1, end);
    }

    public static void main(String[] st) {
        int size = 100;
        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = (int) (Math.random() * size);
        }

        sortRec(list);
        System.out.println(Arrays.toString(list));
        for (int i : list) {
            System.out.println("i:" + i + " findInd:" + search(list, i));
            System.out.println("i:" + i + " findInd:" + searchRec(list, i));
        }

        System.out.println("i:-1" + " findInd:" + search(list, -1));
        System.out.println("i:-1" + " findInd:" + searchRec(list, -1));
        System.out.println("i:101" + " findInd:" + search(list, 101));
        System.out.println("i:101" + " findInd:" + searchRec(list, 101));
    }
}
