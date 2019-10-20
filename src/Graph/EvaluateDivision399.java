package Graph;

import java.util.*;

/**
 * @author Vincent
 * @Date 2019-07-13
 */
public class EvaluateDivision399 {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("a", "b");
        List<String> list2 = Arrays.asList("b", "c");
        List<List<String>> equations = new ArrayList<>();
        equations.add(list1);
        equations.add(list2);
        double[] values = new double[] {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        List<String> l1 = Arrays.asList("a", "c");
        List<String> l2 = Arrays.asList("b", "a");
        queries.add(l1);
        queries.add(l2);
        EvaluateDivision399 ed = new EvaluateDivision399();
        System.out.println(Arrays.toString(ed.calcEquation(equations, values, queries)));
    }

    /**
     * DFS
     * Build the graph with equations. a / b = i represented in DAG as starting from a to b, the cost is i.
     * Conversely, from b to a, the cost is 1/i.
     * With the queries: x / y
     * DFS starts from x, loop through all adjacent vertices of x, apply DFS to x's next vertex until we find y.
     * As we go through dfs, we need a tmp to keep track of the product accumulated so far.
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        double[] res = new double[queries.size()];
        Arrays.fill(res, -1);
        // Build graph
        int index = 0;
        for (List<String> st : equations) {
            String a = st.get(0);
            String b = st.get(1);
            map.putIfAbsent(a, new HashMap<>());
            map.putIfAbsent(b, new HashMap<>());
            map.get(a).put(b, values[index]);
            map.get(b).put(a, 1.0 / values[index]);
            index++;
            map.get(a).put(a, 1.0);
            map.get(b).put(b, 1.0);
        }
        // Start query
        int idx = 0;
        for (List<String> st : queries) {
            String a = st.get(0);
            String b = st.get(1);
            if (!map.containsKey(a) || !map.containsKey(b)) {
                idx++;
                continue;
            } else {
                // Every time we start a new query, we need a new visited array
                dfs(a, b, map, res, idx, new HashSet<>(), 1.0);
                idx++;
            }
        }
        return res;
    }

    public void dfs(String a, String b, Map<String, Map<String, Double>> map, double[] res, int idx, Set<String> visited, double tmp) {
        if (map.get(a) == null || map.get(a).size() == 0) {
            return;
        }
        visited.add(a);
        if (map.get(a).containsKey(b)) {
            res[idx] = map.get(a).get(b) * tmp;
            return;
        }
        for (String next : map.get(a).keySet()) {
            if (visited.contains(next)) continue;
            dfs(next, b, map, res, idx, visited, map.get(a).get(next) * tmp);
        }
    }
}
