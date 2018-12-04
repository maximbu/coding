package hackerRank.interviewPrep.DictsAndMaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountTriplets {
    static long countTriplets(List<Long> arr, long r) {
        HashMap<Long, Long> secPart = new HashMap<>();
        HashMap<Long, Long> thirdPart = new HashMap<>();
        long ans = 0;

        for(Long a : arr) {
            ans += thirdPart.getOrDefault(a, 0L);
            updateKeyBy(thirdPart,r*a,secPart.getOrDefault(a,0L));
            updateKeyBy(secPart,r*a,1);
        }
        return ans;
    }

    private static void updateKeyBy(HashMap<Long, Long> dict, Long key , long diff) {
        dict.put(key, dict.getOrDefault(key, 0L) + diff);
    }

    public static void main(String[] st){
        ArrayList<Long> a = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            a.add(1L);
        }
        System.out.println(countTriplets(a,1));
    }
}
