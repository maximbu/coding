package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by max on 6/24/2017.
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class l1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer missingIndex = valueToIndex.getOrDefault(target - nums[i], null);
            if (missingIndex != null) {
                return new int[]{missingIndex, i};
            }
            valueToIndex.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution");
    }

    public static void main(String[] st) {
        l1 q = new l1();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(q.twoSum(nums, target)));

    }

}