package GeneralAlgos;

import CodingInterviews.utils.BinaryHeap;

import java.util.Arrays;

/**
 * Created by max on 1/1/2017.
 */
public class HeapSort {
    public static void sort(int[] a){
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        for (int x : a) {
            heap.add(x);
        }
        for (int i = 0; i < a.length; i++) {
            a[i]=heap.remove();
        }
    }


    public static void main (String[] st){
        int size = 100;
        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = (int)(Math.random()*size);
        }
        String orig = "list:"+ Arrays.toString(list);
        sort(list);
        System.out.println(orig);
        System.out.println("sorted:"+ Arrays.toString(list));
    }
}
