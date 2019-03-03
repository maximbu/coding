package interviewbit.math;

/**
 * You are given two positive numbers A and B. You need to find the maximum valued integer X such that:

 X divides A i.e. A % X = 0
 X and B are co-prime i.e. gcd(X, B) = 1
 **/
public class LargestCoprimeDivisor {

    public static void main(String[] st) {
        LargestCoprimeDivisor q = new LargestCoprimeDivisor();

        int N = 30;
        int M = 12;
        System.out.println(q.cpFact(N, M));

        N = 5;
        M = 6;
        System.out.println(q.cpFact(N, M));
    }

    public int gcd(int a, int b) {
        int bigger = a;
        int smaller = b;
        if (a < b) {
            bigger = b;
            smaller = a;
        }
        while (smaller > 0) {
            int tmp = bigger % smaller;
            bigger = smaller;
            smaller = tmp;
        }
        return bigger;
    }

    public int cpFact(int A, int B) {
        int gcdVal = gcd(A, B);
        while (gcdVal != 1) {
            A = A / gcdVal;
            gcdVal = gcd(A, B);
        }
        return A;
    }

    private int naiveSolution(int A, int B) {
        if (gcd(A, B) == 1)
            return A;
        for (int i = 2; i <= A / 2; i++) {
            if (A % i == 0 && gcd(B, A / i) == 1) {
                return A / i;
            }
        }
        return 1;
    }
}
