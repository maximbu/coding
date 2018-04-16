package CodingInterviews.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by max on 12/22/2016.
 */
public class WeightedGraph {
    private HashMap<Integer,Node> nodes;
    private HashMap<Integer,Edge> edges;
    private HashMap<Integer,List<Edge>> neighbors;


    public WeightedGraph() {
        this.nodes = new HashMap<>();
        this.edges = new HashMap<>();
        this.neighbors = new HashMap<>();
    }

    public WeightedGraph(List<Node> nodes, List<Edge> edges) {
        this.nodes = new HashMap<>();
        this.edges = new HashMap<>();
        for (Edge e : edges) addEdge(e);
        for (Node n : nodes) addNode(n);
    }

    public HashMap<Integer, Node> getNodes() {
        return nodes;
    }

    public HashMap<Integer, Edge> getEdges() {
        return edges;
    }

    public Edge getEdge(Integer e) {
        return edges.get(e);
    }

    public Node getNode(Integer n) {
        return nodes.get(n);
    }

    public void addEdge(Edge e) {
        this.edges.put(e.getKey(), e);
        if(!this.neighbors.containsKey(e.getFrom())){
            this.neighbors.put(e.getFrom().getKey(),new ArrayList<>());
        }
        this.neighbors.get(e.getFrom().getKey()).add(e);
    }

    public void addNode(Node n) {
        this.nodes.put(n.getKey(), n);
    }

    public class Node {
        private Integer key;
        private String name;

        public Node(Integer key, String name) {
            this.key = key;
            this.name = name;
        }

        public Integer getKey() {
            return key;
        }

        public String getName() {
            return name;
        }

        public Map<Integer,Double> getNeighbors(){
            Map<Integer,Double> map = new HashMap<>();
            for (Edge e:neighbors.get(key)) {
                map.put(e.getTo().getKey(),e.getWeight());
            }
            return map;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public class Edge {
        private Integer key;
        private Node from;
        private Node to;
        private double weight;

        public Edge(Integer key, Node from, Node to, double weight) {
            this.key = key;
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public Integer getKey() {
            return key;
        }

        public Node getFrom() {
            return from;
        }

        public Node getTo() {
            return to;
        }

        public double getWeight() {
            return weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Edge edge = (Edge) o;

            return key != null ? key.equals(edge.key) : edge.key == null;
        }

        @Override
        public int hashCode() {
            return key != null ? key.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "key=" + key +
                    ", from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }
}

