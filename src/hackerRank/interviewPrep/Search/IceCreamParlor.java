package hackerRank.interviewPrep.Search;

import java.util.HashMap;

public class IceCreamParlor {
    static void whatFlavors(int[] cost,int money) {
        HashMap<Integer, Integer> flavours = new HashMap<>();
        for (int i = 0; i < cost.length; i++) {
            if (flavours.containsKey(money - cost[i])) {
                System.out.println(flavours.get(money - cost[i]) + " " + (i+1));
                return;
            }
            flavours.put(cost[i], i+1);
        }
    }

    public static void main(String[] st){
        whatFlavors(new int[]{1,4,5,3,2},4);
        whatFlavors(new int[]{2,2,4,3},4);
    }
}
