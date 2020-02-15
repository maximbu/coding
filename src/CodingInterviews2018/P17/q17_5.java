package CodingInterviews2018.P17;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class q17_5 {

    private static int[] lettersAndNumbers(char[] arr) {
        int[] diffSoFar = new int[arr.length + 1];  // 0 location will be 0 for simplicity
        for (int i = 1; i <= arr.length; i++) {
            diffSoFar[i] = diffSoFar[i - 1] + (Character.isLetter(arr[i - 1]) ? 1 : -1);
        }
        return findMaxSubArray(diffSoFar);
    }

    private static int[] findMaxSubArray(int[] diffSoFar) {
        int[] ans = {0, 0};
        HashMap<Integer, Integer> dist = new HashMap<>();
        for (int i = 0; i < diffSoFar.length; i++) {
            int diff = diffSoFar[i];
            if (!dist.containsKey(diff)) {
                dist.put(diff, i);
            } else {
                int prevInd = dist.get(diff);
                int d = i - prevInd;
                if (ans[1] - ans[0] < d) {
                    ans[1] = prevInd + d - 1;
                    ans[0] = prevInd;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        char[] a = new char[10];
        Random r = ThreadLocalRandom.current();
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextBoolean() ? '4' : 'a';
        }
        //System.out.println((0.9+1.1-1.1)==0.9);
        //System.out.println(0.9==0.9+1-1);
        int[] ans = lettersAndNumbers(a);
        System.out.printf("In array %s: longest sequence of equal number of nums and chars is [%d-%d]%n", Arrays.toString(a), ans[0], ans[1]);
    }
}
