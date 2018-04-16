package CodingInterviews.P5;


/**
 * Created by max on 12/26/2016.
 */
public class q5_6 {
    public static int conversion(int a,int b) {
        int x = a^b;
        int ones = 0;
        while (x!=0){
            ones++;
            x = x & (x-1);
        }
        return ones;
    }


    public static void main(String[] st) {
        int c = conversion(29,15);
    }
}
