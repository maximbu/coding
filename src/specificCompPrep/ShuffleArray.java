package specificCompPrep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class ShuffleArray {

    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void shuffleArray(int[] a) {
        Random r = new Random();
        for (int i = a.length - 1; i >= 0; i--) {
            int ind = r.nextInt(i + 1);
            swap(a, i, ind);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[100];
        Arrays.setAll(nums, i -> i);
        HashMap<Integer,Double> ind = new HashMap<>();
        for (int i = 1; i < 100000; i++) {
            shuffleArray(nums);
            updateAvgInd(nums, ind, i);
        }
        System.out.println(ind);
    }

    private static void updateAvgInd(int[] nums, HashMap<Integer, Double> ind, int i) {
        for (int j = 0; j < nums.length; j++) {
            Double numAvgInd = ind.getOrDefault(nums[j], 0.0);
            double newAvgInd = (numAvgInd*(i-1)+j)/i;
            ind.put(nums[j],newAvgInd);
        }
    }
}
