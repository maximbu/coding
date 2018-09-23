package interviewbit.DynamicProgramming;

/**
 * Given two words A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 * Example :
 * edit distance between
 * "Anshuman" and "Antihuman" is 2.
 *
 * Operation 1: Replace s with t.
 * Operation 2: Insert i.
 */
public class EditDistance {
    public int minDistance(String A, String B) {
        int[][] dist = new int[A.length()+1][B.length()+1];
        for(int i=0;i<=A.length();i++){
            for(int j=0;j<=B.length();j++){
                if(i == 0){
                    dist[i][j] = j;
                    continue;
                }
                if(j == 0){
                    dist[i][j] = i;
                    continue;
                }
                dist[i][j] = Math.min(dist[i-1][j-1],Math.min(dist[i][j-1],dist[i-1][j]))+1;
                if(A.charAt(i-1) == B.charAt(j-1)){
                    dist[i][j] = dist[i-1][j-1];
                }
            }
        }
        return dist[A.length()][B.length()];
    }

    public static void main(String[] st){
        EditDistance q = new EditDistance();
        System.out.println(q.minDistance("aa","aaa"));
    }
}
