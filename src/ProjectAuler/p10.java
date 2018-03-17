package ProjectAuler;

/**
 * Created by max on 1/27/2017.
 */
public class p10 {
    /*
   The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
    Find the sum of all the primes below two million.
     */
    public static long questionNaive(int n){
        long sum = 2;
        for (int i = 3; i < n; i+=2) {
            if(isPrime(i)){
                sum+=i;
            }
        }

        return sum;
    }

    private static boolean isPrime(long n) {
        if(n%2 == 0) return n==2;
        if(n%3 == 0) return n==3;
        for (long i = 5; i <=(long)Math.sqrt(n) ; i+=2) {
            if(n%i == 0) return false;
        }
        return true;
    }

    public static long question(int n) {
        boolean[] nums = new boolean[n+1];
        long sum = 2;
        for (int i = 3; i < n+1; i+=2) {
            if(nums[i]){
                continue;
            }
            sum+=i;
            for (int j = i*2; j < n+1; j+=i) {
                nums[j] = true;
            }
        }
        return sum;
    }


    public static void main(String[] st){
        p10 q = new p10();
        System.out.println(questionNaive(2000000));
        System.out.println(question(2000000));
    }
}
