package interviewbit.DynamicProgramming;

/**
 * Given A, how many structurally unique BST’s (binary search trees) that store values 1...A?
 *
 * Example :
 *
 * Given A = 3, there are a total of 5 unique BST’s.
 *
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class UniqueBinarySearchTreesII {
    public int numTrees(int A) {
        int [] ops = new int[A+1];
        ops[0]=1;
        ops[1]=1;
        for(int i=2;i<=A;i++){
            int ans = 0;
            for(int j=1;j<=i;j++){
                int sizeWithRootJ = ops[i-j] * ops[j-1];
                ans+= sizeWithRootJ;
            }
            ops[i] = ans;
        }
        return ops[A];
    }

    public static void main(String[] st) {
        UniqueBinarySearchTreesII q = new UniqueBinarySearchTreesII();
        System.out.println(q.numTrees(2));
        System.out.println(q.numTrees(3));
        System.out.println(q.numTrees(4));
    }
}
