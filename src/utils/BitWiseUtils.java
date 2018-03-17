package utils;

/**
 * Created by max on 12/25/2016.
 */
public class BitWiseUtils {

    public static int binToInt(String rep) {
        char[] st = rep.toCharArray();
        int n = 0;
        for (int i = 0; i < st.length; i++) {
            n = n * 2 + ((st[i] == '1') ? 1 : 0);
        }
        return n;
    }

    public static String intToBin(int n) {
        char[] st = new char[32];
        int i = 0;
        while (n > 0) {
            st[i++] = (n % 2 == 0) ? '0' : '1';
            n = n / 2;
        }

        String ans = new String(st, 0, i);
        return new StringBuffer(ans).reverse().toString();
    }
}
