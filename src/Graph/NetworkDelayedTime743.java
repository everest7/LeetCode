package Graph;

import java.util.*;

/**
 * @author Vincent
 * @Date 2019-04-14
 */
public class NetworkDelayedTime743 {
    public static void main(String[] args) {
        NetworkDelayedTime743 nd = new NetworkDelayedTime743();
        int[][] times = {{1,2,1}, {2,1,3}};
//        int[][] times = {{1,2,1},{2,3,2},{1,3,1}};
        System.out.println(nd.networkDelayTime(times, 2, 2));
    }


    /**
     * Dijkstra's Algorithm
     * @param times
     * @param N
     * @param K
     * @return
     */
//    public int networkDelayTime(int[][] times, int N, int K) {
//        Queue<Integer> q = new LinkedList<>();
//        q.add(K);
//        // Using edge to represent graph
//        int[][] graph = new int[101][101];
//        for (int i = 0; i <= 100; i++) {
//            Arrays.fill(graph[i], -1);
//        }
//        for (int[] edge : times) {
//            graph[edge[0]][edge[1]] = edge[2];
//        }
//        // dist[] represent the shortest distance
//        int[] dist = new int[N + 1];
//        Arrays.fill(dist, Integer.MAX_VALUE);
//        dist[K] = 0;
//        while (!q.isEmpty()) {
//            Set<Integer> visited = new HashSet<>();
//            int size = q.size();
//            for (int i = 0; i < size; i++) {
//                int u = q.poll();
//                for (int v = 1; v <= 100; v++) {
//                    if (graph[u][v] != -1 && dist[u] + graph[u][v] < dist[v]) {
//                        if (!visited.contains(v)) {
//                            visited.add(v);
//                            q.add(v);
//                        }
//                        dist[v] = dist[u] + graph[u][v];
//                    }
//                }
//            }
//        }
//        int res = 0;
//        for (int i = 1; i <= N; i++) {
//            if (dist[i] == 0) continue; // ignore starting point
//            if (dist[i] == Integer.MAX_VALUE) return -1; // If some points cannot be reached
//            res = Math.max(res, dist[i]);
//        }
//        return res == Integer.MIN_VALUE ? -1 : res;
//    }

    /**
     * Bellman - Ford
     */
    public int networkDelayTime(int[][] times, int N, int K) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        for (int i = 1; i <= N; i++) {
            for (int[] edge : times) {
                int u = edge[0], v = edge[1], w = edge[2];
                if (dist[u] != Integer.MAX_VALUE) {
                    dist[v] = Math.min(dist[v], dist[u] + w);
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(res, dist[i]);

        }
        return res;
    }
}
