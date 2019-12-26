package interviewbit.math;


/**
 * Created by max on 7/16/2017.
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 */
public class ExcelColumnTitle {

    public static void main(String[] st) {
        ExcelColumnTitle q = new ExcelColumnTitle();

        int N = 28;
        System.out.println(q.convertToTitle(N));

        N = 943566;
        System.out.println(q.convertToTitle(N));
    }

    public String convertToTitle(int a) {
        StringBuilder sb = new StringBuilder();
        int maxCh = 'Z' - 'A' + 1;
        while (a > 0) {
            char c = (char) ((a - 1) % maxCh + 'A');
            sb.append(c);
            a = (a - 1) / maxCh;
        }
        return sb.reverse().toString();
    }
}
