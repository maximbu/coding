package ProjectAuler;

/**
 * Created by max on 1/27/2017.
 */
public class p9 {
    /*
   A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
    a^2 + b^2 = c^2
    For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

    There exists exactly one Pythagorean triplet for which a + b + c = 1000.
    Find the product abc.
     */
    public static long questionNaive(int n){
        for (int a = 1; a < n; a++) {
            for (int b = a+1; b < n-a; b++) {
                int c = n - a - b;
                if(a*a+b*b == c*c) return a*b*c;
            }
        }
        return 0;
    }





    public static void main(String[] st){
        p9 q = new p9();
        System.out.println(questionNaive(1000));
    }
}
