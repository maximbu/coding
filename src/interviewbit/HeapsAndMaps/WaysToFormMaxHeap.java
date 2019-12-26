package interviewbit.HeapsAndMaps;

import java.util.ArrayList;

/***
 * Max Heap is a special kind of complete binary tree in which for every node the value present in that node is greater than the value present in it’s children nodes. If you want to know more about Heaps, please visit this link
 *
 * So now the problem statement for this question is:
 *
 * How many distinct Max Heap can be made from n distinct integers
 *
 * In short, you have to ensure the following properties for the max heap :
 *
 * Heap has to be a complete binary tree ( A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible. )
 * Every node is greater than all its children
 * Let us take an example of 4 distinct integers. Without loss of generality let us take 1 2 3 4 as our 4 distinct integers
 *
 * Following are the possible max heaps from these 4 numbers :
 *
 *          4
 *        /  \
 *       3   2
 *      /
 *     1
 *          4
 *        /  \
 *       2   3
 *      /
 *     1
 *         4
 *        /  \
 *       3   1
 *      /
 *     2
 * These are the only possible 3 distinct max heaps possible for 4 distinct elements.
 *
 * Implement the below function to return the number of distinct Max Heaps that is possible from n distinct elements.
 *
 * As the final answer can be very large output your answer modulo 1000000007
 *
 * Input Constraints : n <= 100
 */
public class WaysToFormMaxHeap {
    public int solve(int A) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        ans.add(1);
        int h = 0;
        for (int i = 2; i <= A; i++) {
            if ((2 << h) <= i) {
                h++;
            }
            int m = i - (1 << h) + 1;
            int c = 1 << (h - 1);
            int l = c - 1 + Math.min(m, c);
            int r = c - 1 + Math.min(0, m - c);
            ans.add((comb(l, i - 1) * ans.get(l) * ans.get(r)) % 1000000007);
        }
        return ans.get(A);
    }

    private int comb(int total, int choose) {
        if (total < choose)
            return 0;
        if (choose == 0 || choose == total)
            return 1;
        return comb(total - 1, choose - 1) + comb(total - 1, choose);
    }
}
