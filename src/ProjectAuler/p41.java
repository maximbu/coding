package ProjectAuler;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by max on 1/27/2017.
 */
public class p41 {
    /*
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.
What is the largest n-digit pandigital prime that exists?
*/


    public int questionNaive() {
        List<Integer> primes = getPrimesTill(7654321); // cant have 8 or 9 since will be divisible by 3
        for (int i = primes.size() - 1; i > 0; i--) {
            int p = primes.get(i);
            if (isPandigital(p)) return p;
        }
        return 0;
    }

    private boolean isPandigital(int p) {
        boolean[] digits = new boolean[10];
        while(p>0){
            int d = p%10;
            if(d == 0) return false;
            if(digits[d]) return false;
            digits[d]=true;
            p/=10;
        }
        int i = 9;
        while (!digits[i]) i--;
        while (i >0) {
            if(!digits[i--]) return false;
        }
        return true;
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
        p41 q = new p41();
        System.out.println(q.questionNaive());
}
}
