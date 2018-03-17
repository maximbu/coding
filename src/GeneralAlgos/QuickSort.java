package GeneralAlgos;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by max on 1/1/2017.
 */
public class QuickSort {
    public static void sort(int[] a) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(a.length - 1);

        while (!stack.isEmpty()) {
            int h = stack.pop();
            int l = stack.pop();
            int p = partition(a, l, h);
            if (p - 1 > l) {
                stack.push(l);
                stack.push(p - 1);
            }
            if (p < h) {
                stack.push(p);
                stack.push(h);
            }
        }
    }


    public static void sortRec(int[] a){
        if(a.length < 2) return;
        sortRec(a,0,a.length-1);
    }

    private static void sortRec(int[] a, int start, int end) {
        int ind = partition(a, start, end);
        if (ind - 1 > start) {
            sortRec(a, start, ind - 1);
        }
        if (ind < end) {
            sortRec(a, ind, end);
        }
    }

    private static int partition(int[] a, int start, int end) {
        int p = a[(start + end) / 2];
        while (start <= end) {
            while (a[start] < p) start++;
            while (a[end] > p) end--;
            if (start <= end) {
                int t = a[start];
                a[start] = a[end];
                a[end] = t;
                start++;
                end--;
            }
        }
        return start;
    }

    public static void main (String[] st){
        int size = 1000;
        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = (int)(Math.random()*size);
        }
        int[] list2 = Arrays.copyOf(list,size);
        String orig = "list:"+ Arrays.toString(list);
        String orig2 = "list2:"+ Arrays.toString(list2);
        sortRec(list);
        sort(list2);
        System.out.println(orig);
        System.out.println("sorted:"+ Arrays.toString(list));
        System.out.println(orig2);
        System.out.println("sorted2:"+ Arrays.toString(list2));
    }
}
