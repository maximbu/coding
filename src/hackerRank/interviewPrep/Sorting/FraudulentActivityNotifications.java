package hackerRank.interviewPrep.Sorting;

public class FraudulentActivityNotifications {
    static int activityNotifications(int[] expenditure, int d) {
        int[] freq = new int[201];
        for (int i = 0; i < d; i++) {
            freq[expenditure[i]]++;
        }
        int max = getMaxAllowence(freq, d);
        int cnt = 0;
        for (int i = d; i < expenditure.length; i++) {
            freq[expenditure[i - d]]--;
            freq[expenditure[i]]++;
            if (expenditure[i] >= max) {
                cnt++;
            }
            max = getMaxAllowence(freq, d);
        }
        return cnt;
    }

    private static int getMaxAllowence(int[] nums, int d) {
        int count = 0;
        if (d % 2 == 0) {
            int leftMid = -1;
            for (int j = 0; j < nums.length; j++) {
                count += nums[j];
                if (leftMid == -1 && count >= d / 2) {
                    leftMid = j;
                }
                if (count >= d / 2 + 1) {
                    return leftMid + j;
                }
            }
        }
        for (int j = 0; j < nums.length; j++) {
            count += nums[j];
            if (count > d / 2) {
                return j * 2;
            }
        }
        throw new IllegalStateException();
    }

    private static int getMaxAllowence2(int[] nums, int d) {
        int i = getMedianInd(nums, d);
        if (d % 2 != 0 || nums[i] > 1) return 2 * i;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] > 0) {
                return i + j;
            }
        }
        throw new IllegalStateException();
    }

    private static int getMedianInd(int[] nums, int d) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= (d + 1) / 2) {
                return i;
            }
        }
        throw new IllegalStateException();
    }

    public static void main(String[] st) {
        activityNotifications(new int[]{10, 20, 30, 40, 50}, 3);
    }
}
