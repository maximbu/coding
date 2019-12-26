package ProjectAuler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by max on 1/27/2017.
 */
public class p22 {
    /*
Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
What is the total of all the name scores in the file?
     */

    public long questionNaive(String[] names) {
        long sum = 0;
        Arrays.sort(names);
        for (int i = 0; i < names.length; i++) {
            sum += lettersVal(names[i]) * (i + 1);
        }
        return sum;
    }

    private int lettersVal(String name) {
        int sum = 0;
        for (char c : name.toCharArray()) {
            sum += c - 'A' + 1;
        }
        return sum;
    }


    private String[] readNames() {
        try {
            List<String> names = Files.readAllLines(Paths.get("C:\\Users\\max\\IdeaProjects\\CodingInterviews\\out\\production\\CodingInterviews\\ProjectAuler\\p022_names.txt"));
            return names.get(0).replace("\"", "").split(",");
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] st) {
        p22 q = new p22();
        System.out.println(q.questionNaive(q.readNames()));
    }
}
