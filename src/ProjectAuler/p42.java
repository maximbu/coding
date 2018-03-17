package ProjectAuler;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;

/**
 * Created by max on 1/27/2017.
 */
public class p42 {
    /*
The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:
1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.
Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?
*/


    public int questionNaive(String[] words) {
        int cnt = 0;
        HashSet<Integer> triangleNums = getTriangleNumbers(('Z' - 'A' + 1) * 20);
        for (String s:words) {
            if(triangleNums.contains(wordValue(s))) cnt++;
        }
        return cnt;
    }


    private int wordValue(String word){
        int sum = 0;
        for (char c:word.toCharArray()) {
            sum+=c-'A'+1;
        }
        return sum;
    }

    private HashSet<Integer> getTriangleNumbers(int limit){
        HashSet<Integer> nums = new HashSet<>();
        for (int i = 1; i < limit; i++) {
            nums.add((i*(i+1))/2);
        }
        return nums;
    }

    private  String[] readWords(){
        try {
            List<String> words = Files.readAllLines(Paths.get("C:\\Users\\max\\IdeaProjects\\CodingInterviews\\out\\production\\CodingInterviews\\ProjectAuler\\p042_words.txt"));
            return words.get(0).replace("\"","").split(",");
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }



    public static void main(String[] st) {
        p42 q = new p42();
        System.out.println(q.questionNaive( q.readWords()));
}
}
