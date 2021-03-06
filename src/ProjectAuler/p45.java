package ProjectAuler;


import java.util.HashSet;

/**
 * Created by max on 1/27/2017.
 */
public class p45 {
    /*
Triangle, pentagonal, and hexagonal numbers are generated by the following formulae:
Triangle	 	Tn=n(n+1)/2	 	1, 3, 6, 10, 15, ...
Pentagonal	 	Pn=n(3n−1)/2	 	1, 5, 12, 22, 35, ...
Hexagonal	 	Hn=n(2n−1)	 	1, 6, 15, 28, 45, ...
It can be verified that T285 = P165 = H143 = 40755.
Find the next triangle number that is also pentagonal and hexagonal.
*/


    public long questionNaive() {
        HashSet<Long> triangle = new HashSet<>();
        HashSet<Long> pentagonal = new HashSet<>();
        HashSet<Long> hexagonal = new HashSet<>();
        long t = 286;
        long p = 160;
        long h = 140;
        while (true) {
            Long nextT = (t * (t + 1)) / 2;
            Long nextP = (p * (3 * p - 1)) / 2;
            Long nextH = h * (2 * h - 1);
            triangle.add(nextT);
            pentagonal.add(nextP);
            hexagonal.add(nextH);
            if (triangle.contains(nextH) && pentagonal.contains(nextH) && hexagonal.contains(nextH)) return nextH;
            if (triangle.contains(nextT) && pentagonal.contains(nextT) && hexagonal.contains(nextT)) return nextT;
            if (triangle.contains(nextP) && pentagonal.contains(nextP) && hexagonal.contains(nextP)) return nextP;
            t++;
            h++;
            p++;
        }
    }


    public static void main(String[] st) {
        p45 q = new p45();
        System.out.println(q.questionNaive());
    }
}
