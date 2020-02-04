package CodingInterviews2018.P16;

public class q16_5 {

    private static int factZeroes(int fact) {
        int ans = 0;
        for (int fivePow = 5; fivePow < fact; fivePow *= 5) {
            ans += fact / fivePow;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(factZeroes(100));
    }
}
