package GeneralAlgos;

import java.util.Arrays;

/**
 * Created by max on 12/31/2016.
 */
public class MergeSort {
    public static int[] sort(int[] a){
        int[] aux = new int[a.length];
            for (int blockSize=1; blockSize<a.length; blockSize*=2)
                for (int start=0; start<a.length; start+=2*blockSize)
                    merge(a,aux, start, start+blockSize, Math.min(start+2*blockSize,a.length));
        return a;
    }

    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        if (mid >= a.length) return;
        int i = lo, j = mid;
        for (int k = lo; k < hi; k++) {
            if      (i == mid)     aux[k] = a[j++];
            else if (j == hi)      aux[k] = a[i++];
            else aux[k] = a[j] < a[i] ? a[j++] : a[i++];
        }
        // copy back
        for (int k = lo; k < hi; k++)
            a[k] = aux[k];
    }


    public static int[] sortRec(int[] a){
        if(a.length < 2) return a;
        return sortRec(a,0,a.length-1);
    }

    private static int[] sortRec(int[] a, int start, int end) {
        if(start == end){
            return new int[]{a[start]};
        }
        int mid = (start+end)/2;
        int[] left = sortRec(a,start,mid);
        int[] right = sortRec(a,mid+1,end);
        return merge(left,right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] ans = new int[left.length+right.length];
        int i = 0;
        int j = 0;
        for (int k = 0; k < ans.length; k++) {
            if(i<left.length && j<right.length) {
                ans[k] = left[i] < right[j] ? left[i++] : right[j++];
            }else if(i<left.length){
                ans[k] = left[i++];
            }else{
                ans[k] = right[j++];
            }

        }
        return ans;
    }

    public static void main (String[] st){
        int size = 1000;
        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = (int)(Math.random()*size);
        }
        int[] sorted = sortRec(list);
        int[] sorted2 = sort(list);
        System.out.println("list:"+ Arrays.toString(list));
        System.out.println("sorted:"+ Arrays.toString(sorted));
        System.out.println("sorted2:"+ Arrays.toString(sorted2));
    }
}
