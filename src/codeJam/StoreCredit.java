package codeJam;

import java.util.*;

/**
 * Created by max on 2/21/2017.
 */
public class StoreCredit implements ISolution {

    public String handleTest(String[] parameters) {
        int C = Integer.parseInt(parameters[0]);
        int I = Integer.parseInt(parameters[1]);
        String[] prices = parameters[2].split(" ");
        System.out.println("C =" + C + " I=" + I);
        System.out.println(Arrays.toString(prices));
        HashMap<Integer, Integer> s = new HashMap<>();
        for (int i = 1; i <= prices.length; i++) {
            String p = prices[i - 1];
            int curr = Integer.parseInt(p);
            int other = C - curr;
            if (s.containsKey(other)) {
                if (i < s.get(other)) {
                    return i + " " + s.get(other);
                }
                return s.get(other) + " " + i;
            }
            s.put(curr, i);
        }
        return "Failed !";
    }

    public static void main(String[] st) {
        Utils.solve("A-large-practice.in", new StoreCredit());
    }
}
