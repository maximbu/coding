package CodingInterviews2018.P10;

import java.util.Arrays;

public class q10_11 {
    private static void valleyPeak(int[] arr){
        Arrays.sort(arr);
        for(int i=1;i<arr.length;i+=2){
            int tmp = arr[i-1];
            arr[i-1] = arr[i];
            arr[i]=tmp;
        }
    }

    public static void main (String[] st){
        int[] a = new int[100];
        Arrays.setAll(a, i -> i);
        valleyPeak(a);
        System.out.println(Arrays.toString(a));
    }

}
