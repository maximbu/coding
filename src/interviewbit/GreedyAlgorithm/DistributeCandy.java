package interviewbit.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 *
 *  You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 *
 * Sample Input :
 *
 * Ratings : [1 2]
 * Sample Output :
 *
 * 3
 * The candidate with 1 rating gets 1 candy and candidate with rating cannot get 1 candy as 1 is its neighbor. So rating 2 candidate gets 2 candies. In total, 2+1 = 3 candies need to be given out.
 */
public class DistributeCandy {
    public int candy(ArrayList<Integer> A) {
        int[] candy = new int[A.size()];
        candy[0]=1;
        for(int i=1;i<A.size();i++){
            if(A.get(i) > A.get(i-1)){
                candy[i]=candy[i-1]+1;
            }else {
                candy[i] = 1;
            }
        }

        for(int i=A.size()-2;i>=0;i--){
            if(A.get(i) > A.get(i+1)){
                candy[i]=Math.max(candy[i], candy[i+1]+1);
            }
        }

        return Arrays.stream(candy).sum();
    }

    public static void main(String[] st) {
        DistributeCandy q = new DistributeCandy();
        System.out.println(q.candy(new ArrayList<>(Arrays.asList(1, 2, 2, 2, 1))));
    }
}
