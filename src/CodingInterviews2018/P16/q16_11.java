package CodingInterviews2018.P16;

import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class q16_11 {

    private static HashSet<Integer> divingBoard(int shorter , int longer , int k) {
        if(k==0) return new HashSet<>(Collections.singletonList(0));
        HashSet<Integer> prev = divingBoard(shorter, longer, k-1);
        return prev.stream().flatMap(t-> Stream.of(t+shorter,t+longer)).collect(Collectors.toCollection(HashSet::new));
    }


    private static HashSet<Integer> divingBoardNonRec(int shorter , int longer , int k) {
        HashSet<Integer> ans = new HashSet<>();
        for (int i = 0; i <= k; i++) {
            int other = k - i;
            ans.add(i * shorter + other * longer);
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(divingBoard(4,6,6));
        System.out.println(divingBoardNonRec(4,6,6));
        System.out.println(divingBoard(1,3,12));
        System.out.println(divingBoardNonRec(1,3,12));
    }
}
