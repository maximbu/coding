package P17;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by max on 1/4/2017.
 */
public class p17_q3 {
    public static Set<Integer> getRandom(int[] a, int n){
        if(n>a.length)
            throw new RuntimeException("please use n that is smaller then the array length");
        Set<Integer> ans = new HashSet<>();
        if(n==0)
            return ans;
        if(n==a.length) {
            for(int x:a){
                ans.add(x);
            }
            return ans;
        }

        int[] h = a.clone();

        int ind = h.length-1;
        Random r = new Random();
        while(n > 0){
            int x=r.nextInt(ind);
            int tmp = h[x];
            h[x] = h[ind];
            h[ind]=tmp;
            ans.add(tmp);
            ind--;
            n--;
        }
        return ans;
    }


    public static void main(String[] st){
        int[] a = new int[]{1,2,3,4,5,6,7};
        int cnt = 1;
        for (int i = 0; i < 9; i++) {
            System.out.println(getRandom(a,i));
        }


    }

}
