package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by max on 6/30/2017.
 * Given an integer array, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p
 If such an integer is found return 1 else return -1.
 */
public class NobleInteger {
    public static void main(String[] st){
        NobleInteger q = new NobleInteger();
        ArrayList<Integer> X = new ArrayList<>();
        X.add(3);
        X.add(1);
        X.add(2);
        X.add(5);
        X.add(3);
        System.out.println(q.solve(X));

        X = new ArrayList<>();
        X.add(-3);
        X.add(-1);
        X.add(-2);
        X.add(1);
        X.add(3);
        System.out.println(q.solve(X));

        X = new ArrayList<>();
        X.add(5);
        X.add(6);
        X.add(2);
        System.out.println(q.solve(X));
    }

    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int prev = A.get(A.size()-1);
        if (prev ==0) return 1;
        for (int i = A.size()-2; i >= 0 ; i--) {
            int val =A.get(i);
            if(val == prev) continue;
            if(val == A.size()-i-1) return 1;
            prev = val;
        }
        return -1;
    }
}
