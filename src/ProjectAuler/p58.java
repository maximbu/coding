package ProjectAuler;

import java.math.BigInteger;
import java.util.HashSet;

/**
 * Created by max on 3/18/2017.
 */
public class p58 {
    /*
   Starting with 1 and spiralling anticlockwise in the following way, a square spiral with side length 7 is formed.

37 36 35 34 33 32 31
38 17 16 15 14 13 30
39 18  5  4  3 12 29
40 19  6  1  2 11 28
41 20  7  8  9 10 27
42 21 22 23 24 25 26
43 44 45 46 47 48 49

It is interesting to note that the odd squares lie along the bottom right diagonal, but what is more interesting is that 8 out of the 13 numbers lying along both diagonals are prime; that is, a ratio of 8/13 ≈ 62%.

If one complete new layer is wrapped around the spiral above, a square spiral with side length 9 will be formed. If this process is continued, what is the side length of the square spiral for which the ratio of primes along both diagonals first falls below 10%?
     */

    public static void main(String[] st) {
        p58 q = new p58();
        HashSet<Long> h = q.getPrimesTill(1000000);
        System.out.println(q.questionNaive(h));

    }

    private HashSet<Long> getPrimesTill(int n){
        boolean[] nonPrimes = new boolean[n+1];
        HashSet<Long> list = new HashSet<>();
        list.add(2L);
        for (long i = 3; i < n+1; i+=2) {
            if(!nonPrimes[(int)i]){
                list.add(i);
                for (long j = 2*i; j < n+1; j+=i) {
                    nonPrimes[(int)j]=true;
                }
            }
        }
        return list;
    }

    private int questionNaive( HashSet<Long> primeNums) {
       double percentage = 100;
       int side = 1;
        while (percentage>=10){
            side+=2;
            long i = 3;
            int jump = 2;
            int diag = 1;
            int total = 1;
            int primes = 0;
            while (i<=side*side)
            {
                total++;
                if(primeNums.contains(i) || (i>100000 && isPrime(i))){
                    primes++;
                }
                i+=jump;
                diag++;
                if(diag == 4){
                    diag = 0;
                    jump+=2;
                }

            }
            percentage = 100*primes/(double)(total);
        }
        return side;
    }

    private boolean isPrime(long n) {
        if(n%2 == 0) return n==2;
        if(n%3 == 0) return n==3;
        for (long i = 5; i*i <=n ; i+=2) {
            if(n%i == 0) return false;
        }
        return true;
    }
}
