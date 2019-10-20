package Graph;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-07-29
 */
public class MinimumHeightTrees310 {
    public static void main(String[] args) {
        MinimumHeightTrees310 mh = new MinimumHeightTrees310();
        System.out.println(mh.findMinHeightTrees(1, new int[][]{}));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Arrays.asList(0);
        if (n == 2) return Arrays.asList(0, 1);
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                q.offer(i);
            }
        }
        while (n > 2) {
            int size = q.size();
            n -= size;
            for (int i = 0; i < size; i++) {
                int tmp = q.poll();
                for (int neighbor: graph.get(tmp)) {
                    graph.get(neighbor).remove(Integer.valueOf(tmp));
                    if (graph.get(neighbor).size() == 1) {
                        q.offer(neighbor);
                    }
                }
            }
        }
        while (!q.isEmpty()) {
            res.add(q.poll());
        }
        return res;
    }
}
