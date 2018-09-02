package CodingInterviews2018.P5;

public class q5_3 {
    private static int flipToWin(int x) {
        int max = 0;
        int currSum = 0;
        int prevSum = 0;
        boolean prevZero = false;
        while (x > 0) {
            boolean one = (x & 1) == 1;
            if (one) {
                currSum++;
                max = Math.max(currSum, max);
                prevZero = false;
            } else {
                if (prevZero) {
                    prevSum = 0;
                } else {
                    max = Math.max(currSum + prevSum + 1, max);
                    prevSum = currSum;
                    currSum = 0;
                }
                prevZero = true;
            }
            x /= 2;
        }
        return max;
    }

    public static void main(String[] st) {
        int ans = flipToWin(1775);
    }

}
