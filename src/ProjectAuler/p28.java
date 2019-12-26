package ProjectAuler;

/**
 * Created by max on 1/27/2017.
 */
public class p28 {
    /*
Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
21 22 23 24 25
20  7  8  9 10
19  6  1  2 11
18  5  4  3 12
17 16 15 14 13
It can be verified that the sum of the numbers on the diagonals is 101.
What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
*/


    public int questionNaive(int n) {
        if (n == 1) return 1;
        int topRight = n * n;
        int bottomRight = (n - 2) * (n - 2) + (n - 1);
        int bottomLeft = (n - 2) * (n - 2) + 2 * (n - 1);
        int topLeft = topRight - (n - 1);
        return questionNaive(n - 2) + topRight + bottomLeft + bottomRight + topLeft;
    }


    public static void main(String[] st) {
        p28 q = new p28();
        System.out.println(q.questionNaive(1001));
    }
}
