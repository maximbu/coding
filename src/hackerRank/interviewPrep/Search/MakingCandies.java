package hackerRank.interviewPrep.Search;

// TODO : wrong !
public class MakingCandies {

    static long minimumPasses(long m, long w, long p, long n) {
        long days = 1;
        long candies = m * w;
        long newCandies;
        long newM;
        long newW;
        while (candies < n) {
            if (candies + 2 * m * w >= n) {
                return days + 1;
            }
            newCandies = candies;
            newM = m;
            newW = w;
            while (newCandies >= p && newM < newW) {
                newM++;
                newCandies -= p;
            }
            while (newCandies >= p && newW < newM) {
                newW++;
                newCandies -= p;
            }
            long res = newCandies / p;
            newW += res / 2;
            newM += res - res / 2;
            newCandies = newCandies % p;
            if ((n - candies) / (m * w) < (n - newCandies) / (newM * newW)) {
                return days + (n - candies) / (m * w);
            }
            candies = newCandies;
            m = newM;
            w = newW;
            long minJump = Math.max(1, p / (m * w));
            if (candies + m * w * minJump >= n) {
                minJump = (n - candies) / (m * w);
                if (candies + m * w * minJump < n) {
                    minJump++;
                }
            }

            candies += m * w * minJump;
            days += minJump;
        }
        return days;
    }

    public static void main(String[] st) {
        System.out.println(minimumPasses(1, 1, 6, 45));
        System.out.println(minimumPasses(1, 100, 10000000000L, 1000000000000L));
    }
}
