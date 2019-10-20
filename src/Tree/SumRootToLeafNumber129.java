package Tree;
import Tree.BinaryTree.TreeNode;

/**
 * @author Vincent
 * @Date 10/9/19
 */
public class SumRootToLeafNumber129 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(2);
//        bt.root.left.left = new TreeNode(1);
//        bt.root.left.right = new TreeNode(5);
//        bt.root.right = new TreeNode(3);
        System.out.println(sumNumbers(bt.root));
    }

    public static int sumNumbers(TreeNode root) {
        int[] res = new int[1];
        dfs(root, res, 0);
        return res[0];
    }

    public static void dfs(TreeNode root, int[] res, int cur) {
        if (root.left == null && root.right == null) {
            res[0] += cur * 10 + root.val;
            return;
        }
        dfs(root.left, res, cur * 10 + root.val);
        dfs(root.right, res, cur * 10 + root.val);
    }
}
