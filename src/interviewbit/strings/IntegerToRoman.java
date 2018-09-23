package interviewbit.strings;

/**
 * Given an integer, convert it to a roman numeral, and return a string corresponding to its roman numeral version
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example :
 *
 * Input : 5
 * Return : "V"
 *
 * Input : 14
 * Return : "XIV"
 *  Note : This question has a lot of scope of clarification from the interviewer. Please take a moment to think of all the needed clarifications and see the expected response using “See Expected Output” For the purpose of this question, https://projecteuler.net/about=roman_numerals has very detailed explanations.
 */
public class IntegerToRoman {
    private int[] val = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    private String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intToRoman(int A) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<val.length;i++){
            while(A >= val[i]){
                sb.append(roman[i]);
                A -= val[i];
            }
        }
        return sb.toString();
    }
}
