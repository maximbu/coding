package hackerRank.interviewPrep.warmup;

public class RepeatedString {

    static long repeatedString(String s, long n) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        long aOccInS = countA(s);
        long ans = aOccInS * (n / s.length());
        int leftovers = (int) (n - s.length() * (n / s.length()));
        ans += countA(s.substring(0, leftovers));
        return ans;
    }

    private static long countA(String s) {
        long cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                cnt++;
            }
        }
        return cnt;
    }
}
