package Tree;
import Tree.BinaryTree.TreeNode;
/**
 * @author Vincent
 * @Date 2019-07-22
 */
public class DistributeCoinsinBinaryTree979 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(0);
        bt.root.left = new TreeNode(0);
        bt.root.right = new TreeNode(3);
        DistributeCoinsinBinaryTree979 dc = new DistributeCoinsinBinaryTree979();
        System.out.println(dc.distributeCoins(bt.root));
    }

    /**
     * Let dfs() denotes the extra coins for one node, that is all coins accumulated minus 1.
     *     3
     *    / \
     *   0  0
     * Base case: if the node is null, just return 0.
     * Recursion:
     * Calculate the extra of left and right subtree, plus the value of current node,
     * we can get the extra for current node = x.
     * Updating the result on the fly, that is res += (x - 1)
     *
     * @param root
     * @return
     */
    public int distributeCoins(TreeNode root) {
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }

    public int dfs(TreeNode root, int[] res) {
        if (root == null) return 0;
        int x = dfs(root.left, res) + dfs(root.right, res);
        x += root.val;
        res[0] = res[0] + Math.abs(x - 1);
        root.val = 1;
        return x - 1;
    }
}
