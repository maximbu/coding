package ProjectAuler;


/**
 * Created by max on 1/27/2017.
 */
public class p63 {
    /*
The 5-digit number, 16807=75, is also a fifth power. Similarly, the 9-digit number, 134217728=89, is a ninth power.
How many n-digit positive integers exist which are also an nth power?
*/


    public int questionNaive() {
        int[] cnt = new int[10];
        for (int i = 1; i < 10; i++) {
            cnt[i] = (int) (1 / (1 - Math.log10(i)));
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += cnt[i];
        }
        return sum;
    }


    public static void main(String[] st) {
        p63 q = new p63();
        System.out.println(q.questionNaive());
    }
}
