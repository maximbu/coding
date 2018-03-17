package ProjectAuler;


import java.math.BigInteger;

/**
 * Created by max on 1/27/2017.
 */
public class p97 {
    /*
The first known prime found to exceed one million digits was discovered in 1999, and is a Mersenne prime of the form 26972593−1; it contains exactly 2,098,960 digits. Subsequently other Mersenne primes, of the form 2p−1, have been found which contain more digits.
However, in 2004 there was found a massive non-Mersenne prime which contains 2,357,207 digits: 28433×27830457+1.
Find the last ten digits of this prime number.
*/


    public String questionNaive() {
        BigInteger two = new BigInteger("2");
        BigInteger pow = new BigInteger(String.valueOf(7830457));
        BigInteger mod = new BigInteger(String.valueOf(10000000000L));
        BigInteger mul = new BigInteger(String.valueOf(28433));
        return two.modPow(pow,mod).multiply(mul).add(BigInteger.ONE).mod(mod).toString();
    }




    public static void main(String[] st) {
        p97 q = new p97();
        long startTime = System.currentTimeMillis();
        String ans = q.questionNaive();
        long stopTime = System.currentTimeMillis();
        System.out.println(ans);
        long elapsedTime = stopTime - startTime;
        System.out.println("Solution took:" + elapsedTime + " milisec");
    }
}
