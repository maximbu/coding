package P4;

import utils.Graph;
import utils.GraphNode;

import java.util.*;

/**
 * Created by max on 12/23/2016.
 */
public class q4_7 {
    public static List<String> buildOrder (Graph g){
        List<String> l = new ArrayList<String>();
        if(g == null) {
            return null;
        }

        Set<GraphNode> visited = new HashSet<GraphNode>();
        Set<GraphNode> circleCheck = new HashSet<GraphNode>();
        for (GraphNode node:g.getNodes()){
            dfs(node, l,visited,circleCheck);
        }
        Collections.reverse(l);
        return l;
    }

    private static void dfs(GraphNode node, List<String> l, Set<GraphNode> visited, Set<GraphNode> circleCheck) {
        if(!visited.add(node)){
            if(!circleCheck.contains(node)){
                throw new IllegalArgumentException("Graph contains a cycle.");
            }
            else{
                return;
            }
        }

        for (GraphNode n : node.getNeighbors()){
            dfs(n, l,visited,circleCheck);
        }
        l.add(node.getName());
        circleCheck.add(node);
    }

    public static void main(String[] st){
        GraphNode a = new GraphNode("a");
        GraphNode b = new GraphNode("b");
        GraphNode c = new GraphNode("c");
        GraphNode d = new GraphNode("d");
        GraphNode e = new GraphNode("e");
        GraphNode f = new GraphNode("f");
        GraphNode g = new GraphNode("g");
        d.addNeighbor(g);
        f.addNeighbor(b);
        f.addNeighbor(c);
        f.addNeighbor(a);
        b.addNeighbor(a);
        b.addNeighbor(e);
        c.addNeighbor(a);
        a.addNeighbor(e);

        Graph gr = new Graph(Collections.singletonList(a));
        gr.addNode(b);
        gr.addNode(c);
        gr.addNode(d);
        gr.addNode(e);
        gr.addNode(f);
        gr.addNode(g);
        List<String> l = buildOrder(gr);
    }


}
