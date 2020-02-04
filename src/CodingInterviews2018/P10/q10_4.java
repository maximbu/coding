package CodingInterviews2018.P10;

public class q10_4 {

    private static class Listy {

        private int[] a;

        Listy(int... arr) {
            a = arr;
        }

        public int get(int ind) {
            if (ind >= a.length) {
                return -1;
            }
            return a[ind];
        }

    }

    private static int listySearch(Listy l, int x) {
        int maxSize = getMaxSize(l,x);
        return listySearch(l, x, 0, maxSize);
    }

    private static int listySearch(Listy l, int x, int from, int to) {
        if (from > to)
            return -1;
        int mid = (from + to) / 2;
        int val = l.get(mid);
        if (val == x)
            return mid;
        if (val != -1 && val < x) {
            return listySearch(l, x, mid + 1, to);
        }
        return listySearch(l, x, from, mid - 1);
    }

    private static int getMaxSize(Listy l,int x) {
        int max = 1;
        while (l.get(max) != -1 && l.get(max) < x) {
            max *= 2;
        }
        return max;
    }


    public static void main(String[] st) {
        Listy a = new Listy(1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 10, 12, 15);
        System.out.println("i:" + 1 + " exp:" + 0 + " actual:" + listySearch(a, 1));
        System.out.println("i:" + 2 + " exp:" + 1 + " actual:" + listySearch(a, 2));
        System.out.println("i:" + 3 + " exp:" + 2 + " actual:" + listySearch(a, 3));
        System.out.println("i:" + 4 + " exp:" + 3 + " actual:" + listySearch(a, 4));
        System.out.println("i:" + 5 + " exp:" + 4 + " actual:" + listySearch(a, 5));
        System.out.println("i:" + 6 + " exp:" + 5 + " actual:" + listySearch(a, 6));
        System.out.println("i:" + 7 + " exp:" + 6 + " actual:" + listySearch(a, 7));
        System.out.println("i:" + 8 + " exp:" + 7 + " actual:" + listySearch(a, 8));
        System.out.println("i:" + 9 + " exp:" + "8-10" + " actual:" + listySearch(a, 9));
        System.out.println("i:" + 10 + " exp:" + 11 + " actual:" + listySearch(a, 10));
        System.out.println("i:" + 11 + " exp:" + "-1" + " actual:" + listySearch(a, 11));
        System.out.println("i:" + 12 + " exp:" + 12 + " actual:" + listySearch(a, 12));
        System.out.println("i:" + 13 + " exp:" + "-1" + " actual:" + listySearch(a, 13));
        System.out.println("i:" + 14 + " exp:" + "-1" + " actual:" + listySearch(a, 14));
        System.out.println("i:" + 15 + " exp:" + 13 + " actual:" + listySearch(a, 15));
        System.out.println("i:" + 16 + " exp:" + "-1" + " actual:" + listySearch(a, 16));
    }
}
