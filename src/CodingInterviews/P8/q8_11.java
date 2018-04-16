package CodingInterviews.P8;

/**
 * Created by max on 12/28/2016.
 */
public class q8_11 {
    public static long change(int n){
        if(n==0) return 1;
        long[] arr = new long[n];
        arr[0]=1;
        return changeRec(arr,n,1);
    }

    private static long changeRec(long[] prev , int n,int currInd){
        if(n == currInd) return prev[currInd-1];
        long ans = 1;
        if(currInd>=5) ans+=prev[currInd-5];
        if(currInd>=10) ans+=prev[currInd-10];
        if(currInd>=25) ans+=prev[currInd-25];
        prev[currInd] = ans;
        return changeRec(prev,n,currInd+1);
    }

    public static long change2(int n) {
        if (n == 0) return 1;
        int[] coins = new int[]{1, 5, 10, 25};
        return change2Rec(n, coins, coins.length-1);
    }

    public static int change2Rec(int money, int[] coins,int ind) {
        if (ind == 0) return 1;
        int ways = 0;
        for (int i = 0; money - i * coins[ind] >= 0; i++) {
            ways += change2Rec(money - i * coins[ind], coins, ind - 1);
        }
        return ways;
    }


    public static int makeChanges(int money){
        return makeChanges(money, 25);
    }

    public static int makeChanges(int money, int denom){
        int next_denom = 0;

        switch(denom){
            case 25:
                next_denom = 10;
                break;
            case 10:
                next_denom = 5;
                break;
            case 5:
                next_denom = 1;
                break;
            case 1:
                return 1;
        }

        int ways = 0;

        for(int i = 0; i*denom <= money; i++){
            ways += makeChanges(money-i*denom, next_denom);
        }

        return ways;
    }

    public static void main(String[] st){
        for (int i = 0; i < 100; i++) {
            long my = change2(i);
            int their = makeChanges(i);
            if(my != their) {
                System.out.println("i:" + i + " my change:" + my);
                System.out.println("i:" + i + " their change:" + their);
            }
        }
    }

}
