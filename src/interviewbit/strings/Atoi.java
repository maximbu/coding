package interviewbit.strings;

/**
 * Implement atoi to convert a string to an integer.
 *
 * Example :
 *
 * Input : "9 2704"
 * Output : 9
 * Note: There might be multiple corner cases here. Clarify all your doubts using “See Expected Output”.
 *
 *  Questions: Q1. Does string contain whitespace characters before the number?
 * A. Yes Q2. Can the string have garbage characters after the number?
 * A. Yes. Ignore it. Q3. If no numeric character is found before encountering garbage characters, what should I do?
 * A. Return 0. Q4. What if the integer overflows?
 * A. Return INT_MAX if the number is positive, INT_MIN otherwise.
 * Warning : DO NOT USE LIBRARY FUNCTION FOR ATOI.
 * If you do, we will disqualify your submission retroactively and give you penalty points.
 */
public class Atoi {
    public int atoi(final String A) {
        String a = A.trim();
        if(A.length() ==0) return 0;
        boolean negative = (a.charAt(0) == '-');
        long num =0;
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)=='+' || A.charAt(i)=='-') continue;
            if(!Character.isDigit(A.charAt(i))) break;
            int x = A.charAt(i)-'0';
            num = num * 10 + x;
            if(num > Integer.MAX_VALUE)
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        if(negative){
            num*=-1;
        }
        return (int)num;
    }

    public static void main(String[] st) {
        Atoi q = new Atoi();
        String n =  "-88297 248252140B12 37239U4622733246I218 9 1303 44 A83793H3G2 1674443R591 4368 7 97";
        System.out.println(q.atoi(n));
        String n2 =  "-54332872018247709407 4 54";
        System.out.println(q.atoi(n2));
    }
}
