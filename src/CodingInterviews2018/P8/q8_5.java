package CodingInterviews2018.P8;

public class q8_5 {
    private static int recMult(int x, int y) {
        if (x <= 0 || y <= 0)
            throw new IllegalArgumentException();
        if (x == 1)
            return y;
        int ans = recMult(x >> 1, y);
        ans += ans;
        if ((x & 1) == 1) {
            ans += y;
        }
        return ans;
    }

    public static void main(String[] st) {
        int x = recMult(13, 7);
        if (x != 13 * 7) {
            throw new RuntimeException("Wrong !!!!");
        }

        x = recMult(8, 9);
        if (x != 72) {
            throw new RuntimeException("Wrong !!!!");
        }
    }

}
