package ProjectAuler;

/**
 * Created by max on 1/27/2017.
 */
public class p5 {
    /*
   2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
    What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
     */
    public static long questionNaive(int max){
        long ans = 1;
        int[] mult = new int[max+1];
        for (int i = 2; i <= max; i++) {
            int n = i;
            while(n>1){
                for (int j = 2; j <= n; j++) {
                    int cnt = 0;
                    while(n%j == 0) {
                        n/=j;
                        cnt++;
                    }
                    if(mult[j] < cnt) {
                        mult[j] = cnt;
                    }
                }
            }
        }
        for (int i = 2; i <= max; i++) {
            while (mult[i]>0){
                ans*=i;
                mult[i]--;
            }
        }
        return ans;
    }

    private static boolean isPrime(long n) {
        if(n%2 == 0) return n==2;
        for (long i = 2; i <=(long)Math.sqrt(n) ; i++) {
            if(n%i == 0) return false;
        }
        return true;
    }

    public static long question(int max) {
        long ans = 1;
        int[] mult = new int[max+1];
        for (int i = 2; i <= max; i++) {
            if(!isPrime(i)) continue;
            mult[i] = (int)(Math.log(max)/Math.log(i));
            ans = ans * (int)Math.pow(i,mult[i]);
        }
        return ans;
    }

    public static void main(String[] st){
        p5 q = new p5();
        System.out.println(questionNaive(20));
        System.out.println(question(20));
    }
}
