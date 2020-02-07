package CodingInterviews2018.P16;

public class MasterMindResult {
    int hits;
    int pseudoHits;

    public MasterMindResult(int hits, int pseudoHits) {
        this.hits = hits;
        this.pseudoHits = pseudoHits;
    }

    public int getHits() {
        return hits;
    }

    public int getPseudoHits() {
        return pseudoHits;
    }

    @Override
    public String toString() {
        return "MasterMindResult{" +
                "hits=" + hits +
                ", pseudoHits=" + pseudoHits +
                '}';
    }
}
