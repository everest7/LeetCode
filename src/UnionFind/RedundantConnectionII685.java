package UnionFind;

import java.util.Arrays;

/**
 * @author Vincent
 * @Date 2019-08-06
 */
public class RedundantConnectionII685 {
    public static void main(String[] args) {
        RedundantConnectionII685 rc = new RedundantConnectionII685();
        System.out.println(Arrays.toString(rc.findRedundantDirectedConnection(new int[][] {{1,2}, {1,3}, {2,3}})));
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int cycleMakeEdge = -1, twoParEdge = -1;
        int len = edges.length;
        UnionFind uf = new UnionFind(len + 1);
        int[] parents = new int[len + 1];
        // Check vertex with two parents
        for (int i = 0; i < len; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (parents[v] != 0) {
                twoParEdge = i;
                break;
            } else {
                parents[v] = u;
            }
        }
        // Check edge that form a cycle
        for (int i = 0; i < len; i++) {
            if (i == twoParEdge) continue;
            int u = edges[i][0];
            int v = edges[i][1];
            if (!uf.union(u, v)) {
                cycleMakeEdge = i;
                break;
            }
        }
        if (cycleMakeEdge != -1 && twoParEdge != -1) {
            int v = edges[twoParEdge][1];
            int u = parents[v];
            return new int[] {u, v};
        }
        if (twoParEdge != -1) {
            return edges[twoParEdge];
        }

        if (cycleMakeEdge != -1) {
            return edges[cycleMakeEdge];
        }
        return new int[] {0,0};
    }

    class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;

        public UnionFind(int len) {
            this.parent = new int[len + 1];
            this.rank = new int[len + 1];
            this.count = len;
            for (int i = 1; i <= len; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            parent[x] = find(parent[x]);
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return false;;
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
                rank[rootY]++;
            }
            return true;
        }

        public int count() {
            return this.count;
        }
    }
}
