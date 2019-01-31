package hackerRank.interviewPrep.Search;

import java.util.HashSet;

public class Pairs {
    static int pairs(int k, int[] arr) {
        HashSet<Integer> nums = new HashSet<>();
        int count=0;
        for (int num : arr) {
            if (nums.contains(k + num)) {
                count++;
            }
            if (nums.contains(num - k)) {
                count++;
            }
            nums.add(num);
        }
        return count;
    }

    public static void main(String[] st){
        System.out.println(pairs(2,new int[]{1,5,3,4,2}));
        System.out.println(pairs(1,new int[]{1,2,3,4}));
        System.out.println(pairs(1,new int[]{4,3,2,1}));
    }
}
