package ProjectAuler;


import java.util.HashSet;

/**
 * Created by max on 1/27/2017.
 */
public class p32 {
    /*
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.
The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.
Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
*/


    public long questionNaive() {
        HashSet<Integer> pandigital = new HashSet<>();
        for (int i = 0; i < 9876 ; i++) {
            for (int j = i+1; j < 9876 ; j++) {
                if(isPandigal(i*j, i, j)){
                    pandigital.add(i*j);
                }
            }
        }
        long sum = 0;
        for (int p:pandigital) {
            sum+=p;
        }
        return sum;
    }

    private boolean isPandigal(int mul, int a, int b) {
        boolean[] digits = new boolean[10];
        boolean p = true;
        while (a > 0){
            int digit = a%10;
            a/=10;
            if(digits[digit]) p = false;
            digits[digit] = true;
        }

        while (b > 0){
            int digit = b%10;
            b/=10;
            if(digits[digit]) p = false;
            digits[digit] = true;
        }

        while (mul > 0){
            int digit = mul%10;
            mul/=10;
            if(digits[digit]) p = false;
            digits[digit] = true;
        }

        if(digits[0]) return false;

        for (int i = 1; i < digits.length; i++) {
            boolean digit = digits[i];
            p &= digit;
        }
        return p;
    }


    public static void main(String[] st) {
        p32 q = new p32();
        System.out.println(q.questionNaive());
    }
}
