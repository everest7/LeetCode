package String;
import java.util.*;
import java.util.function.Function;

/**
 * @author Vincent
 * @Date 9/21/19
 */
public class SmallestStringWithSwaps {
    public static void main(String[] args) {
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(0,3));
        pairs.add(Arrays.asList(1,2));
        System.out.println(smallestStringWithSwaps("dcab", pairs));
    }
//    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
//        final int N = s.length();
//
//        // 1a. Extract separate graphs.
//        DSU set = new DSU(N);
//        for (List<Integer> swap: pairs) {
//            set.union(swap.get(0), swap.get(1));
//        }
//
//        // 1b. Map the string’s characters to the appropriate vertices.
//        Map<Integer, List<Character>> graphs = new HashMap<>();
//        for (int i = 0; i < N; i++) {
//            int head = set.find(i);
//            List<Character> characters = graphs.computeIfAbsent(head, (dummy) -> new ArrayList<>());
//            characters.add(s.charAt(i));
//        }
//
//        // 2. Within each graph, sort the characters in **ascending** order.
//        for (List<Character> characters : graphs.values()) {
//            characters.sort(null);
//        }
//
//        // 3. Populate the output by taking the characters from the graph.
//        StringBuilder sb = new StringBuilder(N);
//        for (int i = 0; i < N; i++) {
//            // Since the lists are sorted in ascending order, take the last element.
//            // This is similar to pop_back() function of std::vector.
//            List<Character> characters = graphs.get(set.find(i));
//            char currentMax = characters.remove(0);
//            sb.append(currentMax);
//        }
//        return sb.toString();
//    }

    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        final int N = s.length();

        // 1a. Extract separate graphs.
        DisjointSet set = new DisjointSet(N);
        for (List<Integer> swap : pairs) {
            set.connect(swap.get(0), swap.get(1));
        }

        Function<Integer, Queue<Character>> newDescendingQueue = (dummy) -> new PriorityQueue<>();

        // 1b. Map the string’s characters to the appropriate vertices.
        Map<Integer, Queue<Character>> graphs = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int head = set.getParent(i);
            graphs.computeIfAbsent(head, newDescendingQueue).offer(s.charAt(i));
        }

        // 2. PriorityQueue guarantees the descending order when polling elements.
        // 3. Populate the output by taking the characters from the graph.
        StringBuilder sb = new StringBuilder(N);
        for (int i = 0; i < N; i++) {
            sb.append(graphs.get(set.getParent(i)).poll());
        }
        return sb.toString();
    }

    static class DisjointSet {
        private final int[] parents;

        DisjointSet(int size) {
            this.parents = new int[size];
            // Initially, there are `size` separate items having themselves as parents.
            for (int i = 0; i < size; i++) {
                this.parents[i] = i;
            }
        }

        void connect(int a, int b) {
            parents[getParent(b)] = getParent(a);
        }

        int getParent(int a) {
            int parent = parents[a];
            if (parent != a) {
                parent = getParent(parent);
                parents[a] = parent;
            }
            return parent;
        }
    }

//    static class DSU {
//        private int[] parent;
//        private int[] rank;
//
//        public DSU (int n) {
//            this.parent = new int[n];
//            this.rank = new int[n];
//            for (int i = 0; i < n; i++) {
//                parent[i] = i;
//            }
//
//        }
//
//        public void union(int x, int y) {
//            int rootX = find(x);
//            int rootY = find(y);
//            if (rootX == rootY) return;
//            if (rank[rootX] < rank[rootY]) {
//                parent[rootX] = rootY;
//            } else if (rank[rootX] > rank[rootY]) {
//                parent[rootY] = rootX;
//            } else {
//                parent[rootX] = rootY;
//                rank[rootY]++;
//            }
//        }
//
//        public int find(int x) {
//            if (parent[x] == x) {
//                return parent[x];
//            }
//            parent[x] = find(parent[x]);
//            return parent[x];
//
//        }
//    }
}
