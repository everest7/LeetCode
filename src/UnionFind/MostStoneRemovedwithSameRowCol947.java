package UnionFind;

/**
 * @author Vincent
 * @Date 2019-08-06
 */
public class MostStoneRemovedwithSameRowCol947 {
    public static void main(String[] args) {
        MostStoneRemovedwithSameRowCol947 ms = new MostStoneRemovedwithSameRowCol947();

    }
    /**
     * Paraphrase the question:
     * There are stones on a plane, we can only remove the stone if there is at least one another stone that shares
     * the same row or same column.
     * Question: How many stones can we remove?
     */

    /**
     * If two stones are in the same row or same column, they form a component
     * @param stones
     * @return
     */
    public int removeStones(int[][] stones) {
        int n = stones.length;
        DSU dsu = new DSU(n);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    dsu.union(i, j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i) {
                res++;
            }
        }
        return n - res;
    }

    class DSU {
        private int[] parent;
        private int[] rank;

        public DSU (int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }

        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
                rank[rootY]++;
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return parent[x];
            }
            parent[x] = find(parent[x]);
            return parent[x];

        }
    }
}
