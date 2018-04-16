package CodingInterviews.P16;

/**
 * Created by max on 1/21/2017.
 */
public class q16_5 {
    public int numOfZeroesInFact(int n){
        int ans = 0;
        if(n<5) return 0;
        for (int i = 5; n >= i; i*=5) {
            ans+=n/i;
        }
        return ans;
    }

    public static void main(String[] s){
        q16_5 q = new q16_5();
        System.out.println(q.numOfZeroesInFact(25));
    }
}
