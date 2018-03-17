package codeJam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Utils {
    public static String solve(String inFile, ISolution solution){
        Path path = Paths.get("D:","Users","max","Desktop","codeJam",inFile);
        try {
            List<String> lines = Files.readAllLines(path);
            int line = 0;
            int tests = Integer.valueOf(lines.get(line++));
            int linesPerCase = lines.size()/tests;
            StringBuilder finalAns = new StringBuilder();
            int currCase = 1;
            while (line < lines.size()) {
                finalAns.append("Case #").append(currCase++).append(": ");
                String[] caseParams = new String[linesPerCase];
                for (int i = 0; i < linesPerCase; i++) {
                    caseParams[i] =  lines.get(line++);
                }
                String answer = solution.handleTest(caseParams);
                if(answer == null) continue;
                System.out.println(answer);
                finalAns.append(answer);
                if(line != lines.size()) finalAns.append(System.lineSeparator());
            }
            Path out = Paths.get("D:","Users","max","Desktop","codeJam","out");
            BufferedWriter bw = new BufferedWriter(new FileWriter(out.toString()));
            bw.write(finalAns.toString());
            bw.flush();
            return finalAns.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Failed !";
    }


}
