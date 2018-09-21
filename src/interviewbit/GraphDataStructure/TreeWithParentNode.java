package interviewbit.GraphDataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its children.
 */

  public class TreeWithParentNode {

    int label;
    TreeWithParentNode parent;
    List<TreeWithParentNode> children;

    TreeWithParentNode(int x) {
        label = x;
        children = new ArrayList<>();
    }

    @Override
    public String toString() {
        return label + "";
    }
}
