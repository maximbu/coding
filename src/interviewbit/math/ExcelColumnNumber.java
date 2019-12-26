package interviewbit.math;

/**
 * Created by max on 7/18/2017.
 * Given a column title as appears in an Excel sheet, return its corresponding column number.
 */
public class ExcelColumnNumber {
    public static void main(String[] st) {
        ExcelColumnNumber q = new ExcelColumnNumber();

        String title = "AB";
        System.out.println(q.titleToNumber(title));

        title = "AAA";
        System.out.println(q.titleToNumber(title));
    }

    public int titleToNumber(String a) {
        int cnt = 0;
        char[] ch = a.toCharArray();
        int maxCh = ('Z' - 'A' + 1);
        for (char aCh : ch) {
            cnt = cnt * maxCh + (aCh - 'A' + 1);
        }

        return cnt;
    }
}
