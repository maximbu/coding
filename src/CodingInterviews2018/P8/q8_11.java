package CodingInterviews2018.P8;

import static CodingInterviews.P8.q8_11.makeChanges;

public class q8_11 {
    private static int coins(int cents){
        int[] coinsToUse = {1,5,10,25};
        int[][] options = new int [coinsToUse.length][cents+1];
        return coins(cents,coinsToUse,coinsToUse.length-1,options);
    }

    private static int coins(int cents, int[] coinsToUse, int i, int[][] options) {
        if (i == 0)
            return 1;
        if (options[i][cents] > 0) {
            return options[i][cents];
        }
        int ans = 0;
        for (int j = 0, x = 0; x <= cents; j++, x = j * coinsToUse[i]) {
            ans += coins(cents - x, coinsToUse, i - 1, options);
        }
        options[i][cents] = ans;
        return ans;
    }

    public static void main(String[] st){
        for (int i = 1; i < 100; i++) {
            long my = coins(i);
            int their = makeChanges(i);
            if(my != their) {
                System.out.println("i:" + i + " my change:" + my);
                System.out.println("i:" + i + " their change:" + their);
            }
        }
    }

}
