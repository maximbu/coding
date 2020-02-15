package CodingInterviews2018.P17;

public class q17_6 {

    // TODO : continue this
    private static long twoDigits(long num) {
        long ans = 0;
        long tenPow = 10;
        while (tenPow<num){
            ans+=(tenPow/10)+10*ans;
            tenPow*=10;
        }

        return ans;
    }

    private static long twosInTenPow(long tenPow) {
        return 0;
    }


    public static void main(String[] args) {
        long num = 120;
        System.out.printf("Until number %d there are %d 2 digits%n", num , twoDigits(num));
    }


}
