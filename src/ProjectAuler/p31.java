package ProjectAuler;


/**
 * Created by max on 1/27/2017.
 */
public class p31 {
    /*
In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
It is possible to make £2 in the following way:
1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
How many different ways can £2 be made using any number of coins?
*/


    public long questionNaive(int n) {
        int[] coins = new int[]{1, 2, 5, 10, 20, 50, 100, 200};
        long[] options = new long[n + 1];
        options[0] = 1;

        for (int coin : coins) {
            for (int i = 0; i < n + 1; i++) {
                if (i - coin >= 0) options[i] += options[i - coin];
            }
        }
        return options[n];
    }



    public static void main(String[] st) {
        p31 q = new p31();
        System.out.println(q.questionNaive(200));
    }
}
