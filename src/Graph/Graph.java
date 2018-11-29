package Graph;


import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

//    static class GFG{
//
//    }
        int V;
        LinkedList<Integer> adjListArray[];
        Graph(int v){
            this.V = v;
            adjListArray = new LinkedList[v];
            for (int i = 0; i < v; i++){
                adjListArray[i] = new LinkedList<>(); // Create list for each vertex
            }
        }

    public void addEdge(Graph graph, int ori, int dest){
        graph.adjListArray[ori].add(dest);
        graph.adjListArray[dest].add(ori);
    }

    public void printGraph(Graph graph){
        for (int i = 0; i < graph.V; i++){
            System.out.print(i + "->");
            for (int num: graph.adjListArray[i]){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    // Depth First Search
    public void DFS(int start){
            boolean[] visited = new boolean[V];
            DFSUtil(start, visited);

    }
    void DFSUtil(int start, boolean visited[]){
        visited[start] = true;
        System.out.print(start + " ");
        Iterator<Integer> it = adjListArray[start].listIterator();
        while (it.hasNext()){
            int num = it.next();
            if (!visited[num]){
                DFSUtil(num, visited);
            }
        }
    }
    // Breadth First Search
    public void BFS(int start){
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()){
            int ver = queue.poll();
            System.out.print(ver + " ");
            // Set an iterator to get ver's adjacent vertices
            Iterator<Integer> it = adjListArray[ver].listIterator();
            while (it.hasNext()){
                int num = it.next();
                if (!visited[num]){
                    visited[num] = true;
                    queue.add(num);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph gfg = new Graph(5);
        gfg.addEdge(gfg, 1, 2);
        gfg.addEdge(gfg, 1, 3);
        gfg.addEdge(gfg, 1, 4);
        gfg.printGraph(gfg);
//        gfg.BFS(2);
        gfg.DFS(2);
    }


}
