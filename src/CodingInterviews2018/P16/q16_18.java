package CodingInterviews2018.P16;

public class q16_18 {

    private static boolean patternMatching(String pattern, String text) {
        int len = text.length();
        int aCnt = 0;
        int bCnt = 0;
        for (char c : pattern.toCharArray()) {
            switch (c) {
                case 'a':
                    aCnt++;
                    break;
                case 'b':
                default:
                    bCnt++;
            }
        }


        for (int aLen = 0; aLen * aCnt <= len; aLen++) {
            int bTotalLen = len - aCnt * aLen;
            if ((bCnt == 0 && bTotalLen == 0) || (bCnt > 0 && bTotalLen % bCnt == 0)) {
                int bLen = bCnt == 0 ? 0 : bTotalLen / bCnt;
                int firstA = pattern.indexOf('a');
                int firstB = pattern.indexOf('b');
                String a = "";
                String b = "";
                if (firstA != -1) {
                    int skipChars = firstA * bLen;
                    a = text.substring(skipChars, skipChars + aLen);
                }
                if (firstB != -1) {
                    int skipChars = firstB * aLen;
                    b = text.substring(skipChars, skipChars + bLen);
                }

                if (verifyMatch(pattern, text, a, b)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean verifyMatch(String pattern, String text, String a, String b) {
        StringBuilder sb = new StringBuilder();
        for (char c : pattern.toCharArray()) {
            sb.append(c == 'a' ? a : b);
        }
        return sb.toString().equals(text);
    }


    public static void main(String[] args) {
        String pattern = "aabab";
        String string = "catcatgorrcatgorr";
        System.out.printf("String:%s %s pattern:%s%n", string, patternMatching(pattern, string) ? "matches" : "doesn't match", pattern);
        pattern = "aab";
        System.out.printf("String:%s %s pattern:%s%n", string, patternMatching(pattern, string) ? "matches" : "doesn't match", pattern);
        pattern = "a";
        System.out.printf("String:%s %s pattern:%s%n", string, patternMatching(pattern, string) ? "matches" : "doesn't match", pattern);
        pattern = "b";
        System.out.printf("String:%s %s pattern:%s%n", string, patternMatching(pattern, string) ? "matches" : "doesn't match", pattern);
        pattern = "ab";
        System.out.printf("String:%s %s pattern:%s%n", string, patternMatching(pattern, string) ? "matches" : "doesn't match", pattern);
        pattern = "aabbab";
        System.out.printf("String:%s %s pattern:%s%n", string, patternMatching(pattern, string) ? "matches" : "doesn't match", pattern);
    }
}
