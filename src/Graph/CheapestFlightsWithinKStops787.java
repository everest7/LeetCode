package Graph;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-08-20
 */
public class CheapestFlightsWithinKStops787 {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(findCheapestPrice(3, edges, 0,2,0));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i <= K; i++) { // Relax all edges for K times
            // temp array is needed here since in (i)th iteration, we only want to relax nodes that are reachable from previous (i-1) iteration
            // This differs from original Bellman-Ford code since now we have within K stops requirement
            int[] temp = Arrays.copyOf(dist, dist.length);
            for (int[] edge: flights) { // Go over all edges
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if (dist[u] == Integer.MAX_VALUE) continue;
                if (dist[u] + w < temp[v]) { // relax function
                    temp[v] = dist[u] + w;
                }
            }
            dist = temp;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
