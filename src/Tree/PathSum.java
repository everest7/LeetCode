package Tree;
import Tree.BinaryTree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.Stack;

public class PathSum {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(5);
        bt.root.left = new TreeNode(4);
        bt.root.left.left = new TreeNode(11);
        bt.root.left.left.left = new TreeNode(7);
        bt.root.left.left.right = new TreeNode(2);
        bt.root.right = new TreeNode(8);
        bt.root.right.left = new TreeNode(13);
        bt.root.right.right = new TreeNode(4);
        bt.root.right.right = new TreeNode(1);
        PathSum ps = new PathSum();
        System.out.println(ps.hasPathSum(bt.root, 22));

    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        sum -= root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);

    }
}
