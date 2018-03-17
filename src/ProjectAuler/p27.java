package ProjectAuler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Created by max on 1/27/2017.
 */
public class p27 {
    /*
Euler discovered the remarkable quadratic formula:
n^2+n+41
It turns out that the formula will produce 40 primes for the consecutive integer values 0≤n≤390≤n≤39. However, when n=40,402+40+41=40(40+1)+41n=40,402+40+41=40(40+1)+41 is divisible by 41, and certainly when n=41,412+41+41n=41,412+41+41 is clearly divisible by 41.
The incredible formula n^2−79n+1601 was discovered, which produces 80 primes for the consecutive values 0≤n≤790≤n≤79. The product of the coefficients, −79 and 1601, is −126479.
Considering quadratics of the form:
n2+an+bn2+an+b, where |a|<1000 and |b|≤1000
where |n| is the modulus/absolute value of nn
e.g. |11|=11 and |−4|=4
Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes for consecutive values of nn, starting with n=0.     */


    public int questionNaive(int n) {
        int longest = 0;
        int longestProd = 0;
        Set<Integer> primes = getPrimesTill(n).stream().collect(Collectors.toSet());
        for (int b:primes) {
            for (int a = -n; a < n; a++) {
                if(!primes.contains(a+b+1)){
                    continue;
                }
                int seqLen = getSeqLen(a,b,primes);
                if(seqLen > longest){
                    longest = seqLen;
                    longestProd = a*b;
                }
            }
        }

        return longestProd;
    }

    private int getSeqLen(int a, int b, Set<Integer> primes) {
        int i=1;
        while(true){
            int y = i*i+a*i+b;
            if(primes.contains(y)) {
                i++;
            }
            else{
                return i;
            }
        }
    }


    private List<Integer> getPrimesTill(int n){
        boolean[] nonPrimes = new boolean[n+1];
        List<Integer> list = new ArrayList<>();
        list.add(2);
        for (int i = 3; i < n+1; i+=2) {
            if(!nonPrimes[i]){
                list.add(i);
                for (int j = 2*i; j < n+1; j+=i) {
                    nonPrimes[j]=true;
                }
            }
        }
         return list;
    }


    public static void main(String[] st) {
        p27 q = new p27();
        System.out.println(q.questionNaive(1000));
    }
}
