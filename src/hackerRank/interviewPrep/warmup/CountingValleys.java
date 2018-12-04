package hackerRank.interviewPrep.warmup;

public class CountingValleys {

    static int countingValleys(int n, String s) {
        int ans = 0;
        boolean isValley = false;
        int level = 0;
        for (char c : s.toCharArray()) {
            level += c == 'D' ? -1 : 1;
            if (level == 0 && isValley) {
                ans++;
            }
            isValley = (level < 0);
        }
        return ans;
    }
}
