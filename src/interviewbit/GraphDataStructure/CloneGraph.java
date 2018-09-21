package interviewbit.GraphDataStructure;

import java.util.HashMap;
import java.util.HashSet;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        HashSet<UndirectedGraphNode> handled = new HashSet<>();
        HashSet<UndirectedGraphNode> q = new HashSet<>();
        q.add(node);
        UndirectedGraphNode cloneRoot = new UndirectedGraphNode(node.label);
        map.put(node, cloneRoot);
        while (!q.isEmpty()) {
            UndirectedGraphNode copied = q.iterator().next();
            q.remove(copied);
            for (UndirectedGraphNode n : copied.neighbors) {
                UndirectedGraphNode clone;
                if (map.containsKey(n)) {
                    clone = map.get(n);
                } else {
                    clone = new UndirectedGraphNode(n.label);
                    map.put(n, clone);
                }
                UndirectedGraphNode parent = map.get(copied);
                parent.neighbors.add(clone);
                if(!handled.contains(n) && copied != n) {
                    q.add(n);
                }
            }
            handled.add(copied);

        }
        return cloneRoot;
    }

    public static void main(String[] st) {
        CloneGraph q = new CloneGraph();
        UndirectedGraphNode n703 = new UndirectedGraphNode(703);
        UndirectedGraphNode n279 = new UndirectedGraphNode(279);
        UndirectedGraphNode n43 = new UndirectedGraphNode(43);
        n43.neighbors.add(n279);
        n43.neighbors.add(n703);

        n279.neighbors.add(n279);
        n279.neighbors.add(n43);
        n279.neighbors.add(n703);

        n703.neighbors.add(n279);
        n703.neighbors.add(n43);
        n703.neighbors.add(n703);

        UndirectedGraphNode cloned = q.cloneGraph(n703);
    }
}
