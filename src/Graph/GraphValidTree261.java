package Graph;

import java.util.*;

/**
 * @author Vincent
 * @Date 2019-07-16
 */
public class GraphValidTree261 {
    public static void main(String[] args) {
        int[][] edges = new int[][] {{0,1},{0,2},{0,3},{1,4}};
        GraphValidTree261 gt = new GraphValidTree261();
        System.out.println(gt.validTree(5, edges));
    }

    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int vertex = q.poll();
            if (visited.contains(vertex)) return false;
            visited.add(vertex);
            for (int next : map.get(vertex)) {
                if (!visited.contains(next)) {
                    q.offer(next);
                }
            }
        }
        return visited.size() == n;

    }
}
