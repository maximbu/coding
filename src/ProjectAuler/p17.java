package ProjectAuler;

import java.math.BigInteger;

/**
 * Created by max on 1/27/2017.
 */
public class p17 {
    /*
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
     */
    private static final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};


    public static int questionNaive(int n) {
       int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum+=numOfLetters(i);
        }

       return sum;
    }

    private static int numOfLetters(int n) {
        if (n<20) return LESS_THAN_20[n].length();
        if(n<100) return TENS[n/10].length()+LESS_THAN_20[n%10].length();
        if(n<1000) {
            if(n%100 != 0) {
                return LESS_THAN_20[n / 100].length() + "hundred".length() + "and".length() + numOfLetters(n % 100);
            }
            else{
                return LESS_THAN_20[n / 100].length() + "hundred".length();
            }
        }
        return LESS_THAN_20[n/1000].length()+"thousand".length()+numOfLetters(n%1000);
    }


    public static void main(String[] st) {
        p17 q = new p17();
        System.out.println(numOfLetters(342));
        System.out.println(numOfLetters(115));
        System.out.println(questionNaive(1000));
    }
}
