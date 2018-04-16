package CodingInterviews.P5;



/**
 * Created by max on 12/25/2016.
 */
public class q5_3 {
    public static int flipToWin(int n){

        int best = 1;
        int curr = 0;
        int prev = 0;
        int prevDigit = 0;


        while (n!=0){
            int digit = n&1;
            if(digit == 1){
                curr++;
            }
            else{
                prev = prevDigit == 0 ? 0 : curr;
                curr = 0;
            }
            best = Math.max(prev+curr+1,best);
            n = n>> 1;
            prevDigit = digit;
        }
        return best;
    }

    public static void main(String[] st) {
        int ans = flipToWin(1775);
    }
}
