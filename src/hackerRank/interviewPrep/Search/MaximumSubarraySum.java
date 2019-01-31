package hackerRank.interviewPrep.Search;

import java.util.TreeSet;

public class MaximumSubarraySum {

    static long maximumSum2(long[] a, long m) {
        long curr = 0;
        long[] prefix = new long[a.length];
        for(int i = 0; i < a.length; i++) {
            curr = (a[i] + curr) % m;
            prefix[i] = curr;
        }
        long ret = 0;
        for(int i = 0; i < a.length; i++) {
            long calc = prefix[i]+m;
            for(int j = i-1; j >= 0; j--) {
                if(prefix[j] > prefix[i]) {
                    ret = Math.max(ret, (calc - prefix[j]) % m);
                }
            }
            ret = Math.max(ret, prefix[i]);
        }
        return ret;
    }

    static long maximumSum(long[] a, long m) {
        long maxSum = 0;
        TreeSet<Long> prefix = new TreeSet<>();
        long currentSum = 0;
        for (long x : a) {
            currentSum = (currentSum + x) % m;
            Long next = prefix.higher(currentSum);
            if(next != null){
                maxSum = Math.max(maxSum, (currentSum - next + m) % m);
            }

            maxSum = Math.max(maxSum, currentSum);
            prefix.add(currentSum);
        }
        return maxSum;
    }

}
