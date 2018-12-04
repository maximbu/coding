package hackerRank.interviewPrep.Sorting;

public class CountingInversions {

    static long countInversions2(int[] a) {
        int swaps = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swaps++;
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
        return swaps;
    }

    static long countInversions(int[] a) {
        int[] helper = a.clone();
        return countInversions(a,0,a.length-1,helper);
    }



    private static long countInversions(int[] a, int from, int to, int[] helper) {
        int mid = (to+from)/2;
        if(from>=to) return 0;
        long inversions = 0;
        inversions +=countInversions(helper,from,mid, a);
        inversions +=countInversions(helper,mid+1,to, a);
        inversions+=countSplitInversions(a,from,mid,to,helper);
        return inversions;
    }

    private static long countSplitInversions(int[] a, int from, int mid, int to, int[] helper) {
        long count = 0;
        int i = from, j = mid + 1, k = from;
        while (i <= mid && j <= to) {
            if (helper[i] <= helper[j]) {
                a[k++] = helper[i++];
            } else {
                a[k++] = helper[j++];
                count += mid + 1 - i;
            }
        }
        while (j <= to){
            a[k++] = helper[j++];
        }
        while (i <= mid){
            a[k++] = helper[i++];
        }
        return count;
    }

    public static void main(String[] st){
        countInversions(new int[]{2, 1, 3, 1, 2});
    }
}
