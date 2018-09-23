package interviewbit.strings;

/**
 * Validate if a given string is numeric.
 *
 * Examples:
 *
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 *
 * Clarify the question using “See Expected Output”
 *
 * Is 1u ( which may be a representation for unsigned integers valid?
 * For this problem, no.
 * Is 0.1e10 valid?
 * Yes
 * -01.1e-10?
 * Yes
 * Hexadecimal numbers like 0xFF?
 * Not for the purpose of this problem
 * 3. (. not followed by a digit)?
 * No
 * Can exponent have decimal numbers? 3e0.1?
 * Not for this problem.
 * Is 1f ( floating point number with f as prefix ) valid?
 * Not for this problem.
 * How about 1000LL or 1000L ( C++ representation for long and long long numbers )?
 * Not for this problem.
 * How about integers preceded by 00 or 0? like 008?
 * Yes for this problem
 */
public class ValidNumber {
    public int isNumber(final String A) {
        boolean hasDot = false;
        boolean hasE = false;
        String a = A.trim();
        int i = 0;
        if(a.length() == 0) return 0;
        if(a.charAt(0)=='-' || a.charAt(0)=='+'){
            i++;
        }
        while(i<a.length()){
            char c = a.charAt(i++);
            if(c == '.'){
                if (hasDot || hasE || i >= a.length()
                        || !Character.isDigit(a.charAt(i))) {
                    return 0;
                }
                hasDot = true;
                continue;
            }
            if(c == 'e' || c == 'E'){
                if(hasE || i>=a.length()) return 0;
                hasE = true;
                if(a.charAt(i)=='-' || a.charAt(i)=='+'){
                    i++;
                }
                continue;
            }
            if(!Character.isDigit(c)){
                return 0;
            }
        }
        return Character.isDigit(a.charAt(a.length()-1))?1:0;
    }

    public static void main(String[] st) {
        ValidNumber q = new ValidNumber();
        System.out.println(q.isNumber("1.e1"));
        System.out.println(q.isNumber("-01.1e-10"));
        System.out.println(q.isNumber("3e1.1"));
        System.out.println(q.isNumber(" 0.1"));
    }
}
