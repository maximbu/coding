package ProjectAuler;


import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by max on 1/27/2017.
 */
public class p39 {
    /*
If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.
{20,48,52}, {24,45,51}, {30,40,50}
For which value of p ≤ 1000, is the number of solutions maximised?
*/


    public int questionNaive(int n) {
        int max = 0;
        int maxP = 0;
        HashSet<Integer> sq = squares(n);
        for (int p = 1; p < n+1; p++) {
            int l = getPLen(p,sq);
            if(l>max){
                System.out.println("NewMax :"+l+" for P:"+p);
                max = l;
                maxP = p;
            }
        }

        return maxP;
    }

    private int getPLen(int p,HashSet<Integer> sq) {
        int cnt = 0;
        for (int a = 1; a < p; a++) {
            for (int b = a+1; b < p; b++) {
                int c = p-(a+b);
                if(a*a+b*b==c*c && sq.contains(c*c)) cnt++;
            }
        }
        return cnt;
    }


    private HashSet<Integer> squares(int n){
        HashSet<Integer> sq = new HashSet<Integer>();
        for (int i = 1; i < n + 1; i++) {
            sq.add(i*i);
        }
        return sq;
    }

    public static void main(String[] st) {
        p39 q = new p39();
        System.out.println(q.getPLen(840,q.squares(840)));
        System.out.println(q.questionNaive(1000));
}
}
