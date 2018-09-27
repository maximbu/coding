package interviewbit.GraphDataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Given two words (start and end), and a dictionary, find the shortest transformation sequence from start to end, such that:
 *
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * If there are multiple such sequence of shortest length, return all of them. Refer to the example for more details.
 *
 * Example :
 *
 * Given:
 *
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return
 *
 *   [
 *     ["hit","hot","dot","dog","cog"],
 *     ["hit","hot","lot","log","cog"]
 *   ]
 *  Note:
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
public class WordLadderII {
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
        ArrayList<String> path;

        NodeDiff(UndirectedGraphNode node , int diff , ArrayList<String> prevPath){
            this.diff = diff;
            this.node = node;
            this.path = new ArrayList<>(prevPath);
            path.add(node.label);
        }
    }

    public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dict) {
        HashMap<String,UndirectedGraphNode> map = new HashMap<>();
        for(String s:dict){
            addToGraph(s, map);
        }
        UndirectedGraphNode startNode = addToGraph(start,map);
        UndirectedGraphNode endNode = addToGraph(end,map);
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        bfs(startNode,endNode,ans);
        return ans;
    }

    private void bfs(UndirectedGraphNode startNode, UndirectedGraphNode endNode , ArrayList<ArrayList<String>> ans) {
        ArrayList<NodeDiff> q = new ArrayList<>();
        HashSet<UndirectedGraphNode> seen = new HashSet<>();
        q.add(new NodeDiff(startNode,0,new ArrayList<>()));
        int minDiff = Integer.MAX_VALUE;
        while (!q.isEmpty()){
            NodeDiff nodeDiff = q.remove(0);
            int dist = nodeDiff.diff+1;
            if(dist > minDiff){
                return;
            }
            if(nodeDiff.node == endNode){
                ans.add(nodeDiff.path);
                minDiff = dist;
            }
            else{
                for (UndirectedGraphNode neig :nodeDiff.node.neighbors){
                    if (!seen.contains(neig)){
                        q.add(new NodeDiff(neig,dist,nodeDiff.path));
                    }
                }
                seen.add(nodeDiff.node);
            }
        }
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
        int diff = 0;
        for (int i = 0; i < w.length(); i++) {
            if(w.charAt(i) != s.charAt(i)){
                diff++;
                if(diff > 1){
                    return false;
                }
            }
        }
        return true;
    }
}
