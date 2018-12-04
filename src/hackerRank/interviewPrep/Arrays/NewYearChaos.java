package hackerRank.interviewPrep.Arrays;

public class NewYearChaos {

    static void minimumBribes(int[] q) {
        int ans = 0;
        for (int i = q.length - 1; i >= 0; i--) {
            int diff = q[i] - i - 1;
            if (diff > 2) {
                System.out.println("Too chaotic");
                return;
            }
            int from = q[i] == 1 ? 0 : q[i] - 2;
            for (int j = from; j < i; j++) {
                if (q[i] < q[j]) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
