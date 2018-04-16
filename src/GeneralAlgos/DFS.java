package GeneralAlgos;

import CodingInterviews.utils.Graph;
import CodingInterviews.utils.GraphNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by max on 1/1/2017.
 */
public class DFS {
    public static GraphNode searchUsingDFS(Graph g , String nodeName){
        Set<GraphNode> set = new HashSet<>();
        for (GraphNode n:g.getNodes()) {
            if(set.add(n)){
                GraphNode ans =DFS(n,nodeName,set);
                if(ans != null){
                    return ans;
                }
            }
        }
        return null;
    }

    public static GraphNode DFS(GraphNode g , String nodeName){
        Set<GraphNode> set = new HashSet<>();
        return DFS(g,nodeName,set);
    }

    private static GraphNode DFS(GraphNode g, String nodeName, Set<GraphNode> visited){
        if(g.getName().equals(nodeName)) return g;
        for (GraphNode n:g.getNeighbors()) {
            if(visited.add(n)) {
                GraphNode ans =DFS(n,nodeName,visited);
                if(ans != null){
                    return ans;
                }
            }
        }
        return null;
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

        System.out.println("a:"+searchUsingDFS(g,"a").printName());
        System.out.println("b:"+searchUsingDFS(g,"b").printName());
        System.out.println("c:"+searchUsingDFS(g,"c").printName());
        System.out.println("d:"+searchUsingDFS(g,"d").printName());
        System.out.println("e:"+searchUsingDFS(g,"e").printName());
        System.out.println("f:"+searchUsingDFS(g,"f").printName());
        System.out.println("g:"+searchUsingDFS(g,"g"));
    }
}
