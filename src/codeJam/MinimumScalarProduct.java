package codeJam;

import java.util.Arrays;

/**
 * Created by max on 2/21/2017.
 */
public class MinimumScalarProduct implements ISolution {

    public String handleTest(String[] parameters) {
        int n = Integer.valueOf(parameters[0]);
        long ans = 0;
        long[] v1 = Arrays.stream(parameters[1].split(" ")).mapToLong(Long::valueOf).toArray();
        long[] v2 = Arrays.stream(parameters[2].split(" ")).mapToLong(Long::valueOf).toArray();
        Arrays.sort(v1);
        Arrays.sort(v2);
        for (int i = 0; i < v1.length; i++) {
            ans+=(v1[i]*v2[n-i-1]);
        }
        return String.valueOf(ans);
    }

    public static void main(String[] st){
       Utils.solve("A-large-practice (1).in", new MinimumScalarProduct());
    }
}
