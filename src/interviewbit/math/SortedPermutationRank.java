package interviewbit.math;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Given a string, find the rank of the string amongst its permutations sorted lexicographically.
 Assume that no characters are repeated.
 The answer might not fit in an integer, so return your answer % 1000003
 */
public class SortedPermutationRank {

    public static void main(String[] st) {
        SortedPermutationRank q = new SortedPermutationRank();

        String input = "acb";
        System.out.println(q.findRank(input));

        input = "3214";
        System.out.println(q.findRank(input));

        input = "ZCSFLVHXRYJQKWABGT";
        System.out.println(q.findRank(input));
    }

    private int letterOrder(ArrayList<Character> chars,char c){
        return chars.indexOf(c);
    }

    public ArrayList<Character> convertStringToArraylist(String str) {
        ArrayList<Character> charList = new ArrayList<>();
        for(int i = 0; i<str.length();i++){
            charList.add(str.charAt(i));
        }
        return charList;
    }

    private long factorial(int x){
        long ans = 1;
        while (x>0){
            ans=(x*ans)% 1000003;
            x--;
        }
        return ans;
    }

    public int findRank(String a) {
        ArrayList<Character> ordered = convertStringToArraylist(a);
        ordered.sort(Comparator.comparingInt(o -> o));
        long rank = 1;
        for (int i = 0; i < a.length(); i++) {
            int order = letterOrder(ordered, a.charAt(i));
            rank = (rank + (order * factorial(ordered.size()-1) % 1000003))% 1000003;
            ordered.remove(order);
        }
        return (int) (rank % 1000003);
    }
}


