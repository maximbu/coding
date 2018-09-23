package interviewbit.DynamicProgramming;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * Example,
 * Given:
 *
 * s1 = "aabcc",
 * s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class InterleavingStrings {
    public int isInterleave(String A, String B, String C) {
        if(C.length()!=A.length()+B.length()) {
            return 0;
        }
        int Ai = 0;
        int Bi = 0;
        for(int i=0;i<C.length();i++){
            if(Ai>=A.length() || C.charAt(i) != A.charAt(Ai)){
                if(Bi>=B.length() || C.charAt(i) != B.charAt(Bi)){
                    return 0;
                }
                Bi++;
                continue;
            }
            if(Bi>=B.length() || C.charAt(i) != B.charAt(Bi)){
                Ai++;
                continue;
            }
            if(isInterleave(A.substring(Ai+1),B.substring(Bi),C.substring(i+1)) == 1)
                return 1;
            return isInterleave(A.substring(Ai),B.substring(Bi+1),C.substring(i+1));
        }
        return 1;
    }

    public static void main(String[] st) {
        InterleavingStrings q = new InterleavingStrings();
        String A ="LgR8D8k7t8KIprKDTQ7aoo7ed6mhKQwWlFxXpyjPkh";
        String B ="Q7wQk8rqjaH971SqSQJAMgqYyETo4KmlF4ybf";
        String C ="Q7wLgR8D8Qkk7t88KIrpqjarHKD971SqSQJTQ7aoAMgoq7eYd6yETmhoK4KmlQwWFlF4xybXfpyjPkh";
        System.out.println(q.isInterleave(A,B,C));
    }
}
