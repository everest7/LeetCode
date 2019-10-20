package Graph;

import java.util.*;

/**
 * @author Vincent
 * @Date 2019-07-22
 */
public class CourseSchedule207 {
    public static void main(String[] args) {
        CourseSchedule207 cs = new CourseSchedule207();
        System.out.println(cs.canFinish(2, new int[][] {{1,0},{0,1}}));
    }

    /**
     * DFS detect cycle.
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] preq : prerequisites) {
            graph.get(preq[1]).add(preq[0]);
        }
        for (int u = 0; u < numCourses; u++) {
            for (int neighbor: graph.get(u)) {
                if (!dfs(graph, visited, neighbor)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> graph, int[] visited, int cur) {
        visited[cur] = 1;
        for (int neig: graph.get(cur)) {
            if (visited[neig] == 1) {
                return false;
            } else if (visited[neig] == 0) {
                if (!dfs(graph, visited, neig)){
                    return false;
                }
            }
        }
        visited[cur] = 2;
        return true;
    }

    /**
     * Topological sort
     */
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        int[] indegree = new int[numCourses];
//        Map<Integer, List<Integer>> graph = new HashMap<>();
//        for (int i = 0; i < numCourses; i++) {
//            graph.put(i, new ArrayList<>());
//        }
//        for (int[] pre : prerequisites) {
//            graph.get(pre[1]).add(pre[0]);
//            indegree[pre[0]]++;
//        }
//        Queue<Integer> q = new LinkedList<>();
//        for (int i = 0; i < numCourses; i++) {
//            if (indegree[i] == 0) q.add(i);
//        }
//        while (!q.isEmpty()) {
//            int tmp = q.poll();
//            for (int next : graph.get(tmp)) {
//                indegree[next]--;
//                if (indegree[next] == 0) {
//                    q.add(next);
//                }
//            }
//        }
//        for (int i = 0; i < numCourses; i++) {
//            if (indegree[i] != 0) return false;
//        }
//        return true;
//    }
}
