package Graph;

import java.util.ArrayList;
import java.util.List;

public class ShortestPath {

    public static void main(String[] args) {
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        ShortestPath sp = new ShortestPath();
        sp.djikstra(graph, 0);
    }

    private static final  int V = 9;
    public void djikstra(int[][] graph, int src){
        List<Integer> list = new ArrayList<>();
        int[] dist = new int[V];
        boolean[] stpSet = new boolean[V];
        for (int i = 0; i < V; i++){
            dist[i] = Integer.MAX_VALUE;
            stpSet[i] = false;
        }
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++){
            int u = midDist(dist, stpSet);
            stpSet[u] = true;
            for (int v = 0; v < V; v++){
                if (!stpSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                && dist[u] + graph[u][v] < dist[v]){
                    dist[v] = dist[u] + graph[u][v];
                    list.add(v);
                }
            }
        }
        System.out.println(list);
        printSolution(dist);
    }

    void printSolution(int[] dist){
        System.out.println("Vertex distance from source:");
        for (int i = 0; i < dist.length; i++){
            System.out.println(i + "  " + dist[i]);
        }
    }

    // Util function to find out the vertex with shortest distance
    static int midDist(int[] dist, boolean[] stpSet){
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for (int i = 0; i < V; i++){
            if (stpSet[i] == false && dist[i] < min){
                min = dist[i];
                min_index = i;
            }
        }
        return min_index;
    }


}
