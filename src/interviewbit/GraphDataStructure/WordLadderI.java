package interviewbit.GraphDataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordLadderI {
    private class UndirectedGraphNode {
        String label;
        List<UndirectedGraphNode> neighbors;
        public void addNeighbor(UndirectedGraphNode n){
            neighbors.add(n);
            n.neighbors.add(this);
        }
        UndirectedGraphNode(String x) { label = x; neighbors = new ArrayList<>(); }
    }

    private class NodeDiff{
        UndirectedGraphNode node;
        int diff;

        NodeDiff(UndirectedGraphNode node , int diff){
            this.diff = diff;
            this.node = node;
        }
    }

    public int ladderLength(String start, String end, ArrayList<String> dictV) {
        HashMap<String,UndirectedGraphNode> map = new HashMap<>();
        for(String s:dictV){
            addToGraph(s, map);
        }
        UndirectedGraphNode startNode = addToGraph(start,map);
        UndirectedGraphNode endNode = addToGraph(end,map);
        return bfs(startNode,endNode);
    }

    private int bfs(UndirectedGraphNode startNode, UndirectedGraphNode endNode) {
        ArrayList<NodeDiff> q = new ArrayList<>();
        HashSet<UndirectedGraphNode> seen = new HashSet<>();
        q.add(new NodeDiff(startNode,0));
        while (!q.isEmpty()){
            NodeDiff nodeDiff = q.remove(0);
            int dist = nodeDiff.diff+1;
            if(nodeDiff.node == endNode){
                return dist;
            }
            for (UndirectedGraphNode neig :nodeDiff.node.neighbors){
                if (!seen.contains(neig)){
                    q.add(new NodeDiff(neig,dist));
                }
            }
            seen.add(nodeDiff.node);
        }
        return 0;
    }

    private UndirectedGraphNode addToGraph(String s, HashMap<String, UndirectedGraphNode> map) {
        if(map.containsKey(s)){
            return map.get(s);
        }
        UndirectedGraphNode node = new UndirectedGraphNode(s);
        for(String w:map.keySet()){
            if(isOneCharAway(w,s)){
                node.addNeighbor(map.get(w));
            }
        }
        map.put(s,node);
        return node;
    }

    private boolean isOneCharAway(String w, String s) {
        boolean diff = false;
        for (int i = 0; i < w.length(); i++) {
            if(w.charAt(i) != s.charAt(i)){
                if(diff) return false;
                diff = true;
            }
        }
        return true;
    }

    public static void main(String[] st){
        WordLadderI q = new WordLadderI();
        System.out.println(q.ladderLength("bb","ab",new ArrayList<>()));
    }
}
