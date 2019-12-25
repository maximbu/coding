package CodingInterviews.P10;

/**
 * Created by max on 12/29/2016.
 */
public class q10_4 {
    public static class Arrayli {
        private int[] a;

        public Arrayli(int... arr) {
            a = arr;
        }

        public int get(int ind) {
            if (ind >= a.length) {
                return -1;
            }
            return a[ind];
        }

    }

    public static int find(Arrayli a, int x) {
        int len = 1;
        while (a.get(len) != -1) {
            len *= 2;
        }
        len = findLength(a, len / 2, len);
        return find(a, x, 0, len);
    }

    private static int findLength(Arrayli a, int left, int right) {
        int mid = (left + right) / 2;
        if (a.get(mid) != -1 && a.get(mid + 1) == -1) return mid;
        if (a.get(mid) == -1) return findLength(a, left, mid);
        return findLength(a, mid + 1, right);
    }

    private static int find(Arrayli a, int x, int left, int right) {
        int mid = (left + right) / 2;
        int midVal = a.get(mid);
        if (midVal == x) return mid;
        if (left >= right) return -1;
        if (midVal > x) return find(a, x, left, mid);
        return find(a, x, mid + 1, right);
    }

    public static void main(String[] st) {
        Arrayli a = new Arrayli(1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 10, 12, 15);
        System.out.println("i:" + 1 + " exp:" + 0 + " actual:" + find(a, 1));
        System.out.println("i:" + 2 + " exp:" + 1 + " actual:" + find(a, 2));
        System.out.println("i:" + 3 + " exp:" + 2 + " actual:" + find(a, 3));
        System.out.println("i:" + 4 + " exp:" + 3 + " actual:" + find(a, 4));
        System.out.println("i:" + 5 + " exp:" + 4 + " actual:" + find(a, 5));
        System.out.println("i:" + 6 + " exp:" + 5 + " actual:" + find(a, 6));
        System.out.println("i:" + 7 + " exp:" + 6 + " actual:" + find(a, 7));
        System.out.println("i:" + 8 + " exp:" + 7 + " actual:" + find(a, 8));
        System.out.println("i:" + 9 + " exp:" + "8-10" + " actual:" + find(a, 9));
        System.out.println("i:" + 10 + " exp:" + 11 + " actual:" + find(a, 10));
        System.out.println("i:" + 11 + " exp:" + "-1" + " actual:" + find(a, 11));
        System.out.println("i:" + 12 + " exp:" + 12 + " actual:" + find(a, 12));
        System.out.println("i:" + 13 + " exp:" + "-1" + " actual:" + find(a, 13));
        System.out.println("i:" + 14 + " exp:" + "-1" + " actual:" + find(a, 14));
        System.out.println("i:" + 15 + " exp:" + 13 + " actual:" + find(a, 15));
        System.out.println("i:" + 16 + " exp:" + "-1" + " actual:" + find(a, 16));
    }

}
