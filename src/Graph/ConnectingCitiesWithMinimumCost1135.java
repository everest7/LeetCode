package Graph;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Vincent
 * @Date 10/14/19
 */
public class ConnectingCitiesWithMinimumCost1135 {
    public static void main(String[] args) {
        ConnectingCitiesWithMinimumCost1135 cc = new ConnectingCitiesWithMinimumCost1135();
        int[][] conn = new int[][] {{1,2,5}, {2,3,1}, {1,3,6}};
        System.out.println(cc.minimumCost(3, conn));
    }

    public int minimumCost(int N, int[][] connections) {

        Arrays.sort(connections, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[2] - b[2];
            }
        });
        int res = 0;
        DSU dsu = new DSU(N);
        for (int[] edge: connections) {
            if (dsu.union(edge[0] - 1, edge[1] - 1)) {
                res += edge[2];
            }
        }
        return res;
    }

    class DSU {
        int size;
        int[] parent;
        int[] rank;

        public DSU(int n) {
            this.size = n;
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
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

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
