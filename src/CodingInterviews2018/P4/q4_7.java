package CodingInterviews2018.P4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class q4_7 {

    private static class ProjectDep {

        String proj;
        String depProj;

        public ProjectDep(String a, String b) {
            proj = a;
            depProj = b;
        }
    }

    private static List<String> projOrder(List<String> proj, List<ProjectDep> dep) {
        ArrayList<String> ans = new ArrayList<>();
        var edgesFrom = createEdgesFromMap(proj, dep);
        var edgesTo = createEdgesToMap(proj, dep);
        HashSet<String> startingNodes = getStartingNodes(edgesTo);
        while (!startingNodes.isEmpty()) {
            String p = startingNodes.iterator().next();
            startingNodes.remove(p);
            ans.add(p);
            for (String pDep : edgesFrom.get(p)) {
                var edgesToDep = edgesTo.get(pDep);
                edgesToDep.remove(p);
                if (edgesTo.get(pDep).isEmpty()) {
                    startingNodes.add(pDep);
                }
            }
            edgesFrom.remove(p);
        }
        if (edgesFrom.isEmpty())
            return ans;
        return null;
    }

    private static HashSet<String> getStartingNodes(Map<String, ArrayList<String>> edgesTo) {
        var ans = edgesTo.entrySet().stream().filter(edges -> edges.getValue().isEmpty())
                .map(Entry::getKey).collect(Collectors.toCollection(HashSet::new));
        return ans;
    }

    private static Map<String, ArrayList<String>> createEdgesToMap(List<String> proj, List<ProjectDep> dep) {
        var ans = proj.stream().collect(Collectors.toMap(t -> t, t -> new ArrayList<String>()));
        dep.forEach(p -> ans.get(p.depProj).add(p.proj));
        return ans;
    }

    private static Map<String, ArrayList<String>> createEdgesFromMap(List<String> proj, List<ProjectDep> dep) {
        var ans = proj.stream().collect(Collectors.toMap(t -> t, t -> new ArrayList<String>()));
        dep.forEach(p -> ans.get(p.proj).add(p.depProj));
        return ans;
    }

    public static void main(String[] st) {
        var proj = Arrays.asList("a", "b", "c", "d", "e", "f");
        var deps = Arrays.asList(new ProjectDep("a", "d"), new ProjectDep("f", "b"),
                new ProjectDep("b", "d"), new ProjectDep("f", "a"), new ProjectDep("d", "c"));
        List<String> l = projOrder(proj, deps);
        deps = Arrays.asList(new ProjectDep("a", "d"), new ProjectDep("f", "b"),
                new ProjectDep("b", "d"), new ProjectDep("f", "a"), new ProjectDep("d", "c") ,new ProjectDep("c", "f"));
        List<String> l2 = projOrder(proj, deps);
    }

}
