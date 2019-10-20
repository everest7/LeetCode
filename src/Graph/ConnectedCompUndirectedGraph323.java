package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vincent
 * @Date 2019-04-18
 */
public class ConnectedCompUndirectedGraph323 {
    public static void main(String[] args) {
        ConnectedCompUndirectedGraph323 cc = new ConnectedCompUndirectedGraph323();
        int[][] edges = {{0,1},{1,2},{3,4}};
        System.out.println(cc.countComponents(5, edges));

    }
    public int countComponents(int n, int[][] edges) {
        int res = 0;
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                res++;
                // visited[i] = true;
                dfs(i, map, visited);
                visited[i] = true;
            }

        }
        return res;
    }
    public void dfs(int node, Map<Integer, List<Integer>> map, boolean[] visited) {
        if (!visited[node]) {
            visited[node] = true;
            for (int i : map.get(node)) {
//                visited[i] = true;
                dfs(i, map, visited);

            }
        }
    }
}
