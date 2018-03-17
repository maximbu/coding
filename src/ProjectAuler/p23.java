package ProjectAuler;

import java.util.HashSet;


/**
 * Created by max on 1/27/2017.
 */
public class p23 {
    /*
A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24.
By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.
Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
     */
    private static HashSet<Integer> abundant = new HashSet<>();

    public long questionNaive(int n) {
        long sum = 0;
        for (int i = 1; i < n; i++) {
            if(i<divisorsSum(i)){
                abundant.add(i);
            }
        }
        boolean nums[] = new boolean[n+1];
        for (Integer n2:abundant) {
            for (Integer n3:abundant) {
                if(n2+n3 < n+1) { // nums[24] = true
                    nums[n2+n3]=true;
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            if(!nums[i]) sum+=i;
        }
        return sum;
    }

    private static long divisorsSum(int n) {
        long sum = 1;
        for (int j = 2; j*j <= n; j++) {
            if(n%j == 0) {
                sum+=j;
                if(j != n/j) sum+=n/j;
            }
        }
        return sum;
    }



    public static void main(String[] st) {
        p23 q = new p23();
        int num = 20162;
        System.out.println(q.questionNaive( num ));
    }
}
