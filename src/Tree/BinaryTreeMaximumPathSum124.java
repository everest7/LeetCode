package Tree;
import Tree.BinaryTree.TreeNode;

/**
 * @author Vincent
 * @Date 2019-08-17
 */
public class BinaryTreeMaximumPathSum124 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(-3);
        BinaryTreeMaximumPathSum124 br = new BinaryTreeMaximumPathSum124();
        System.out.println(br.maxPathSum(bt.root));
    }
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        dfs(root, res);
        return res[0];
    }

    /**
     * O
     * @param root
     * @param res
     * @return the maximum sum from leaf to current node, either choosing left subtree or right subtree.
     */
    public int dfs(TreeNode root, int[] res) {
        if (root == null) return 0;
        int left = Math.max(0, dfs(root.left, res));
        int right = Math.max(0, dfs(root.right, res));
        res[0] = Math.max(res[0], left + right + root.val); // compare with path that goes through the root.
        return Math.max(left, right) + root.val; // for upper path, we can only choose one branch
    }
}
