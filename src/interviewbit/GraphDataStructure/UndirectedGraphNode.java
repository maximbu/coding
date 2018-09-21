package interviewbit.GraphDataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */

  public class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<>(); }

    @Override
    public String toString() {
        return label+"";
    }
}
