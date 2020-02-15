package CodingInterviews2018.P17;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class q17_7 {

    static class NodeData {
        private String name;
        private int freq;
        private boolean used;

        public NodeData(String name, int freq) {
            this.name = name;
            this.freq = freq;
        }

        public String getName() {
            return name;
        }

        public int getFreq() {
            return freq;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed() {
            used = true;
        }
    }

    private static Map<String, Integer> calcFreq(HashMap<String, Integer> names, String[][] synonyms) {
        HashMap<String, Node<NodeData>> namesMap = new HashMap<>();
        names.forEach((key, value) -> namesMap.put(key, new Node<>(new NodeData(key, value))));
        for (String[] synonym : synonyms) {
            namesMap.get(synonym[0]).addNeighbour(namesMap.get(synonym[1]));
        }
        return namesMap.entrySet().stream()
                .filter(nameEntry -> !nameEntry.getValue().getData().isUsed())
                .collect(Collectors.toMap(nameEntry -> nameEntry.getValue().getData().getName(),
                        nameEntry -> calcDfsFreq(nameEntry.getValue())));
    }

    private static int calcDfsFreq(Node<NodeData> node) {
        if (node == null || node.getData().isUsed()) return 0;
        int val = node.getData().getFreq();
        node.getData().setUsed();
        return val + node.getNeighbours().stream().map(t -> calcDfsFreq(t)).mapToInt(t -> t).sum();
    }


    public static void main(String[] args) {
        HashMap<String, Integer> names = new HashMap<String, Integer>();

        names.put("John", 3);
        names.put("Jonathan", 4);
        names.put("Johnny", 5);
        names.put("Chris", 1);
        names.put("Kris", 3);
        names.put("Brian", 2);
        names.put("Bryan", 4);
        names.put("Carleton", 4);

        String[][] synonyms =
                {{"John", "Jonathan"},
                        {"Jonathan", "Johnny"},
                        {"Chris", "Kris"},
                        {"Brian", "Bryan"}};

        System.out.printf("Frequencies for names: %s%n and synonyms %s%n are: %s%n", names, Arrays.deepToString(synonyms), calcFreq(names, synonyms));
    }
}
