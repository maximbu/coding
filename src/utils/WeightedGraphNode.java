package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 1/1/2017.
 */
public class WeightedGraphNode{
    String name;
    List<WeightedGraphNodeNeighbor> neighbors;


    public WeightedGraphNode(String name) {
        this.name = name;
        neighbors = new ArrayList<>();
    }

    public WeightedGraphNode(List<WeightedGraphNodeNeighbor> neighbors, String name) {
        this.neighbors = neighbors;
        this.name = name;
    }

    public List<WeightedGraphNodeNeighbor> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<WeightedGraphNodeNeighbor> neighbors) {
        this.neighbors = neighbors;
    }

    public void addNeighbor(WeightedGraphNodeNeighbor neighbor) {
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
}
