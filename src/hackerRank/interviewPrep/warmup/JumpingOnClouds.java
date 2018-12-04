package hackerRank.interviewPrep.warmup;

public class JumpingOnClouds {

    static int jumpingOnClouds(int[] c) {
        int ans = 0;
        int currInd = 0;
        while (currInd < c.length - 1) {
            currInd++;
            ans++;
            if (currInd + 1 < c.length && c[currInd + 1] == 0) {
                currInd++;
            }
        }
        return ans;
    }
}
