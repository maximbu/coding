package CodingInterviews2018.P16;

import java.util.HashMap;

public class q16_23 {

    private static int rand7From5() {
        while (true) {
            int num = 5 * rand5() + rand5(); //0-24 range eq. distributed
            if (num < 21) {
                return num % 7;
            }
        }
    }

    public static int rand5() {
        return (int) (Math.random() * 100) % 5;
    }


    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < 7; i++) {
            map.put(i,0);
        }
        for (int i = 0; i < 100000; i++) {
            int res = rand7From5();
            map.put(res,map.get(res)+1);
        }
        for (var e : map.entrySet()){
            System.out.printf("For %d there are %d occurrences %n", e.getKey() , e.getValue());
        }
    }
}
