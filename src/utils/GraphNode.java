package utils;

import java.util.ArrayList;
import java.util.List;

public class GraphNode{
    String name;
    List<GraphNode> neighbors;


    public GraphNode(String name) {
        this.name = name;
        neighbors = new ArrayList<>();
    }

    public GraphNode(List<GraphNode> neighbors, String name) {
        this.neighbors = neighbors;
        this.name = name;
    }

    public List<GraphNode> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<GraphNode> neighbors) {
        this.neighbors = neighbors;
    }

    public void addNeighbor(GraphNode neighbor) {
        neighbors.add(neighbor);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "name='" + name + '\'' +
                ", neighbors=" + neighbors +
                '}';
    }



    public String printName() {
        return "GraphNode{" +
                "name='" + name + '\'' +
                '}';
    }
}
