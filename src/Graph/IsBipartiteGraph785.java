package Graph;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-05-12
 */
public class IsBipartiteGraph785 {
    public static void main(String[] args) {
//        int[][] graph = {{1,3}, {0,2}, {1,3}, {0,2}};
        int[][] graph = {{4}, {}, {4}, {4},{0,2,3}};
        IsBipartiteGraph785 ib = new IsBipartiteGraph785();
        System.out.println(ib.isBipartite(graph));

    }

    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int u = 0; u < graph.length; u++) {
            map.putIfAbsent(u, new ArrayList<>());
            for (int v : graph[u]) {
                map.putIfAbsent(v, new ArrayList<>());
                map.get(u).add(v);
                map.get(v).add(u);
            }
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < graph.length; i++) {
            if (color[i] != 0) continue;
            color[i] = 1;
            Queue<Integer> q = new LinkedList<>();
            visited.add(i);
            q.offer(i);
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int next : map.get(cur)) {
                    if (color[next] == color[cur]) return false;
                    if (!visited.contains(next)) {
                        color[next] = -1 * color[cur];
                        q.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        return true;
    }

//    public boolean isBipartite(int[][] graph) {
//        int[] color = new int[graph.length];
//        for (int i = 0; i < graph.length; i++) {
//            if (color[i] == 0 && !dfs(graph, color, 1, i)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public boolean dfs(int[][] graph, int[] color, int c, int node) {
//        if (color[node] != 0) return color[node] == c;
//        color[node] = c;
//        for (int n : graph[node]) {
//            if (!dfs(graph, color, -1 * c, n)) {
//                return false;
//            }
//        }
//        return true;
//    }
}
