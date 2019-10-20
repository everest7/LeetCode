package UnionFind;

import java.util.Arrays;

/**
 * @author Vincent
 * @Date 2019-08-05
 */
public class RedundantConnection684 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRedundantConnection(new int[][] {{1,2},{1,3},{2,3}})));
    }

    public static int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for (int[] edge: edges) {
            if (!uf.union(edge[0] - 1, edge[1] - 1)) {
                return edge;
            }
        }
        return null;
    }

    static class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int n) {
            this.parent = new int[n];
            rank = new int[n];
        }

        public int find(int x) {
            if (parent[x] == 0) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return false;
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
    }
}
