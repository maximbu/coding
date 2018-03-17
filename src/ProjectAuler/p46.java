package ProjectAuler;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by max on 1/27/2017.
 */
public class p46 {
    /*
It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.
9 = 7 + 2×12
15 = 7 + 2×22
21 = 3 + 2×32
25 = 7 + 2×32
27 = 19 + 2×22
33 = 31 + 2×12
It turns out that the conjecture was false.
What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
*/


    public long questionNaive() {
        List<Integer> primes = getPrimesTill(10000);
        HashSet<Integer> squares = squares(10000);
        int smallest = Integer.MAX_VALUE;
        for (int i = 3; i < Math.min(smallest,10000); i+=2) {
            for (int j = i; j < 10000/i; j += 2) {
                int n = i * j;
                for (int p : primes) {
                    if (p > n) {
                        if (smallest > n) smallest = n;
                        break;
                    }
                    if (squares.contains(n - p)) break;
                }
            }
        }
        return smallest;
    }

    private HashSet<Integer> squares(int n){
        HashSet<Integer> sq = new HashSet<Integer>();
        for (int i = 1; i < n + 1; i++) {
            sq.add(2*i*i);
        }
        return sq;
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
        p46 q = new p46();
        System.out.println(q.questionNaive());
}
}
