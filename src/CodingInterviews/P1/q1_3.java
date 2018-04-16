package CodingInterviews.P1;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by max on 12/16/2016.
 */
public class q1_3 {
    public static String urlify(char[] st,int realLength) {
        int spaces = 0;
        for (int i=0;i<realLength;i++) {
            if (st[i] == ' ')
                spaces++;
        }
        int index = realLength + spaces * 2;
        for (int i = realLength - 1; i >= 0; i--) {
            if (st[i] == ' ') {
                st[--index] = '0';
                st[--index] = '2';
                st[--index] = '%';
            } else {
                st[--index] = st[i];
            }
        }
        return new String(st);
    }



    public static void main(String[] args) {
        System.out.println("urlify(Mr John Smith    )"+"->"+urlify("Mr John Smith    ".toCharArray(),13));
    }
}
