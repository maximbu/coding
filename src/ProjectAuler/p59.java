package ProjectAuler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by max on 3/18/2017.
 */
public class p59 {
    public static void main(String[] st) {
        p59 q = new p59();
        try {
            List<String> strings = Files.readAllLines(Paths.get("C:\\Users\\max\\IdeaProjects\\CodingInterviews\\out\\production\\CodingInterviews\\ProjectAuler\\p059_cipher.txt"));
            int[] chars = Arrays.stream(strings.get(0).split(",")).mapToInt(Integer::parseInt).toArray();
            System.out.println(q.questionNaive(chars));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private long questionNaive(int[] chars) {
        for (int i = 'a'; i <= 'z'; i++) {
            for (int j = 'a'; j <= 'z'; j++) {
                for (int k = 'a'; k <= 'z'; k++) {
                    StringBuilder sb = new StringBuilder();
                    int[] pass = new int[]{i, j, k};
                    int l = 0;
                    int pass_i = 0;
                    while (l < chars.length) {
                        sb.append((char) (pass[pass_i++ % pass.length] ^ chars[l++]));
                    }
                    if (sb.toString().contains(" the ")) {
                        System.out.println(sb.toString());
                        long sum = 0;
                        char[] charArray = sb.toString().toCharArray();
                        for (char c : charArray) {
                            sum += c;
                        }
                        return sum;
                    }
                }
            }
        }
        return 0;
    }
}
