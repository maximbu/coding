package GeneralAlgos;

import CodingInterviews.utils.BinaryHeap;
import CodingInterviews.utils.WeightedGraph;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by max on 1/1/2017.
 */
public class Dijkstra_WIP {
    public static class DNode implements Comparable<DNode>{
        Integer id;
        double dist;

        public DNode(Integer id, double dist) {
            this.id = id;
            this.dist = dist;
        }

        @Override
        public int compareTo(DNode o) {
            if(dist < o.dist) return -1;
            if(dist > o.dist) return 1;
            return 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DNode dNode = (DNode) o;

            return id != null ? id.equals(dNode.id) : dNode.id == null;
        }

        @Override
        public int hashCode() {
            return id != null ? id.hashCode() : 0;
        }
    }


    public static Map<Integer,Double> minDist(WeightedGraph g, WeightedGraph.Node from){
        BinaryHeap<DNode> heap = new BinaryHeap<>();
        Map<Integer,DNode> heapNodes = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();

        for (Integer key: g.getNodes().keySet()){
            DNode heapNode = new DNode(key, Double.MAX_VALUE);
            heap.add(heapNode);
            heapNodes.put(key,heapNode);
        }

        heapNodes.get(from).dist = 0;

        while (!heap.isEmpty())
        {
            DNode node = heap.remove();

            Map<Integer, Double> neighbors = g.getNode(node.id).getNeighbors();
            for (Integer i: neighbors.keySet()){
                if(!visited.contains(i)) {
                    double newPath = node.dist + neighbors.get(i);
                    double oldPath = heapNodes.get(i).dist;
                    if(newPath < oldPath){
                        heapNodes.get(i).dist = newPath;
                    }
                }

            }



        }

        return null;

    }

}
