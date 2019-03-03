package interviewbit.math;

/**
 * Created by max on 7/16/2017.
 * Given a number N, find all prime numbers upto N ( N included ).
 */
public class VerifyPrime {
    public static void main(String[] st) {
        VerifyPrime q = new VerifyPrime();

        int N = 7;
        System.out.println(q.isPrime(N));
    }

    public int isPrime(int a) {
        if (a < 2 || a % 2 == 0)
            return 0;
        for (int i = 3; i * i <= a; i += 2) {
            if (a % i == 0)
                return 0;
        }
        return 1;
    }

}
