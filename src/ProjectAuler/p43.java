package ProjectAuler;


import java.util.*;

/**
 * Created by max on 1/27/2017.
 */
public class p43 {
    /*
The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.
Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:

d2d3d4=406 is divisible by 2
d3d4d5=063 is divisible by 3
d4d5d6=635 is divisible by 5
d5d6d7=357 is divisible by 7
d6d7d8=572 is divisible by 11
d7d8d9=728 is divisible by 13
d8d9d10=289 is divisible by 17
Find the sum of all 0 to 9 pandigital numbers with this property.
*/


    public long questionNaive() {
        String st = "0123456789";
        Set<String> pandigital = getPermutations(st);
        int[] primes = {2, 3, 5, 7, 11, 13, 17};
        long sum = 0;
        for (String p : pandigital) {
            if (p.charAt(0) == '0') continue;
            char[] digits = p.toCharArray();
            for (int i = 2; i < 9; i++) {
                if (createNumber(digits, i, i + 2) % primes[i - 2] != 0) break;
                if (i == 8) {
                    sum += Long.parseLong(p);
                }
            }
        }
        return sum;
    }

    public static Set<String> getPermutations(String st) {
        return permutations(st, st.length() - 1);
    }

    private static Set<String> permutations(String st, int i) {
        if (i == 0) {
            HashSet<String> h = new HashSet<>();
            h.add(st.substring(0, 1));
            return h;
        }
        Set<String> withoutI = permutations(st, i - 1);
        char c = st.charAt(i);
        HashSet<String> ans = new HashSet<>();
        for (String s : withoutI) {
            for (int j = 0; j <= i; j++) {
                ans.add(s.substring(0, j) + c + s.substring(j, i));

            }
        }
        return ans;
    }

    private int createNumber(char[] digits, int i, int j) {
        int ans = 0;
        for (int k = i - 1; k < j; k++) {
            ans = ans * 10 + digits[k] - '0';
        }
        return ans;
    }


    public static void main(String[] st) {
        p43 q = new p43();
        System.out.println(q.questionNaive());
    }
}
