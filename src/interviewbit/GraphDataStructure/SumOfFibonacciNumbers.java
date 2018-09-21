package interviewbit.GraphDataStructure;

import java.util.ArrayList;

/**
 * How many minimum numbers from fibonacci series are required such that sum of numbers should be equal to a given Number N?
 * Note : repetition of number is allowed.
 *
 * Example:
 *
 * N = 4
 * Fibonacci numbers : 1 1 2 3 5 .... so on
 * here 2 + 2 = 4
 * so minimum numbers will be 2
 */
public class SumOfFibonacciNumbers {
    public int fibsum(int A) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(1);
        while(arr.get(arr.size()-1) <= A){
            arr.add(arr.get(arr.size()-1)+arr.get(arr.size()-2));
        }
        int cnt = 0;
        int ind = arr.size()-1;
        while(A > 0){
            if(arr.get(ind) > A){
                ind--;
                continue;
            }
            cnt++;
            A -= arr.get(ind);
        }
        return cnt;
    }
}
