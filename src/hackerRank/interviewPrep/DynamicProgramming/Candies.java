package hackerRank.interviewPrep.DynamicProgramming;

import java.util.Arrays;

public class Candies {
    static long candies(int n, int[] arr) {
        long[] candies = new long[arr.length];
        Arrays.fill(candies, 1);
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                candies[i]=candies[i-1]+1;
            }
        }
        for (int i = arr.length-2; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                candies[i] = Math.max(candies[i],candies[i + 1] + 1);
            }
        }

        long ans = 0;
        for(long a:candies){
            ans+=a;
        }
        return ans;
    }

    public static void main(String[] s) {
        System.out.println(candies(8,new int[]{2
                ,4
                ,3
                ,5
                ,2
                ,6
                ,4
                ,5}));
    }
}
