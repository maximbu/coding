package GeneralAlgos;

import utils.Graph;
import utils.GraphNode;

import java.util.*;

/**
 * Created by max on 1/1/2017.
 */
public class BFS {
    public static GraphNode searchUsingBFS(Graph g , String nodeName){
        LinkedList<GraphNode> queue = new LinkedList<>();
        Set<GraphNode> visited = new HashSet<>();

        for (GraphNode n:g.getNodes()){
            if(!visited.contains(n)) {
                GraphNode ans = BFS(n, nodeName, queue, visited);
                if (ans != null) {
                    return ans;
                }
            }
        }
        return null;
    }

    private static GraphNode BFS(GraphNode n, String nodeName, LinkedList<GraphNode> queue, Set<GraphNode> visited) {
        queue.add(n);
        while (!queue.isEmpty()) {
            GraphNode g = queue.remove();
            if(visited.add(g)) {
                if (g.getName().equals(nodeName)) {
                    return g;
                }
                queue.addAll(g.getNeighbors());
            }
        }
        return null;
    }

    public static GraphNode BFS(GraphNode g , String nodeName){
        LinkedList<GraphNode> queue = new LinkedList<>();
        Set<GraphNode> visited = new HashSet<>();
        return BFS(g,nodeName,queue,visited);
    }



    public static void main(String[] st){
        GraphNode a = new GraphNode("a");
        GraphNode b = new GraphNode("b");
        GraphNode c = new GraphNode("c");
        GraphNode d = new GraphNode("d");
        GraphNode e = new GraphNode("e");
        GraphNode f = new GraphNode("f");
        a.addNeighbor(d);
        f.addNeighbor(b);
        b.addNeighbor(d);
        f.addNeighbor(a);
        d.addNeighbor(c);
        a.addNeighbor(e);
        a.addNeighbor(f);

        Graph g = new Graph(Arrays.asList(a,b));

        System.out.println("a:"+searchUsingBFS(g,"a").printName());
        System.out.println("b:"+searchUsingBFS(g,"b").printName());
        System.out.println("c:"+searchUsingBFS(g,"c").printName());
        System.out.println("d:"+searchUsingBFS(g,"d").printName());
        System.out.println("e:"+searchUsingBFS(g,"e").printName());
        System.out.println("f:"+searchUsingBFS(g,"f").printName());
        System.out.println("g:"+searchUsingBFS(g,"g"));
    }
}
