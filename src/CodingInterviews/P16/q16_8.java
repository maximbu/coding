package CodingInterviews.P16;

/**
 * Created by max on 1/22/2017.
 */
public class q16_8 {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder st = new StringBuilder();
        if (num < 0) {
            st.append("Negative ");
            num *= -1;
        }
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                st.insert(0, toWords(num % 1000).trim() + " " + THOUSANDS[i] + " ");
            }
            i++;
            num /= 1000;
        }
        return st.toString().trim();
    }


    private String toWords(int n) {
        if (n < 20) return LESS_THAN_20[n] + " ";
        if (n < 100) return TENS[n / 10] + " " + LESS_THAN_20[n % 10] + " ";
        return LESS_THAN_20[n / 100] + " Hundred " + toWords(n % 100);
    }

    public static void main(String[] st) {
        q16_8 q = new q16_8();
        System.out.println(q.numberToWords(1000000));
    }
}
