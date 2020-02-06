package CodingInterviews2018.P16;

public class q16_8 {

    static String[] till19 = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    static String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    static String[] commaSep = {"", "Thousand", "Million", "Billion"};
    static String hundred = "Hundred";
    static String negative = "Negative";

    private static String englishInt(int a) {
        String ans = englishInt(a, new StringBuilder()).toString();
        return ans.length() == 0 ? till19[0] : ans;
    }

    private static StringBuilder englishInt(int a, StringBuilder sb) {
        if (a < 0) {
            sb.append(negative).append(" ");
            return englishInt(-a, sb);
        }
        if(a==0) return sb;
        int b = a;
        int bigPart = 0;
        while (a > 1000) {
            a /= 1000;
            bigPart++;
        }

        int hund = a / 100;
        if (hund > 0) {
            sb.append(till19[hund]).append(" ").append(hundred).append(" ");
        }
        int ten = (a % 100)/10;
        sb.append(tens[ten]);
        if (ten > 0) {
            sb.append(" ");
        }
        int small = ten==1?a % 20:a%10;
        sb.append(till19[small]);
        if (small > 0) {
            sb.append(" ");
        }
        if (bigPart > 0) {
            sb.append(commaSep[bigPart]).append(", ");
        }
        return englishInt(b % (int) Math.pow(1000, bigPart), sb);
    }

    public static void main(String[] args) {
        int a = -123456078;
        System.out.println(a + " is " + englishInt(a));
    }
}
