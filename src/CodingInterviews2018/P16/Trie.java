package CodingInterviews2018.P16;

import java.util.HashMap;
import java.util.Optional;

public class Trie {
    HashMap<Character,Trie> nodes = new HashMap<>();
    char c;
    boolean ending;

    public Trie() {
    }

    public Trie(char c) {
        this.c= c;
    }

    public void addWord(String w) {
        if(w.length()==0){
            ending = true;
            return;
        }
        if(!nodes.containsKey(w.charAt(0))){
            nodes.put(w.charAt(0),new Trie(w.charAt(0)));
        }
        nodes.get(w.charAt(0)).addWord(w.substring(1));
    }

    public Optional<Trie> getNode(char c) {
        return Optional.ofNullable(nodes.get(c));
    }

    public boolean isEnding() {
        return ending;
    }
}
