package ProjectAuler;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by max on 1/27/2017.
 */
public class p44 {
    /*
Pentagonal numbers are generated by the formula, Pn=n(3n−1)/2. The first ten pentagonal numbers are:
1, 5, 12, 22, 35, 51, 70, 92, 117, 145, ...
It can be seen that CodingInterviews.P4 + P7 = 22 + 70 = 92 = CodingInterviews.P8. However, their difference, 70 − 22 = 48, is not pentagonal.
Find the pair of pentagonal numbers, Pj and Pk, for which their sum and difference are pentagonal and D = |Pk − Pj| is minimised; what is the value of D?
*/


    public long questionNaive() {
        List<Long> pentagons = getPentagons(10000000);
        Set<Long> set = new HashSet<>(pentagons);
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < pentagons.size(); i++) {
            long p1 = pentagons.get(i);
            for (int j = i + 1; j < pentagons.size(); j++) {
                long p2 = pentagons.get(j);
                if (set.contains(p1 + p2) && set.contains(p2 - p1)) {
                    min = Math.min(min, p2 - p1);
                }
            }
        }
        return min;
    }


    private List<Long> getPentagons(int n) {
        List<Long> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            long num = i * (3 * i - 1) / 2;
            if (num > n) return list;
            list.add(num);
        }
        return list;
    }


    public static void main(String[] st) {
        p44 q = new p44();
        System.out.println(q.questionNaive());
    }
}
