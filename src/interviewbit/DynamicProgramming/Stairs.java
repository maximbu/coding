package interviewbit.DynamicProgramming;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example :
 *
 * Input : 3
 * Return : 3
 *
 * Steps : [1 1 1], [1 2], [2 1]
 */
public class Stairs {
    public int climbStairs(int A) {
        int[] ops = new int[A+3];
        ops[0] = 0;
        ops[1] = 1;
        ops[2] = 2;
        for(int i=3;i<=A;i++){
            ops[i] = ops[i-1]+ops[i-2];
        }
        return ops[A];
    }
}
