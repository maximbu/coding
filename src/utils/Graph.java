package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by max on 12/22/2016.
 */
public class Graph {
    List<GraphNode> nodes;

    public Graph(List<GraphNode> nodes) {
        this.nodes = new ArrayList<>();
        this.nodes.addAll(nodes);
    }

    public List<GraphNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<GraphNode> nodes) {
        this.nodes = new ArrayList<>();
        this.nodes.addAll(nodes);
    }

    public void addNode(GraphNode node) {
        nodes.add(node);
    }

    @Override
    public String toString() {
        return "Graph{" +
                "nodes=" + nodes +
                '}';
    }
}

