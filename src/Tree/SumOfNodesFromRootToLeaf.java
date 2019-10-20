package Tree;

import Tree.BinaryTree.TreeNode;

import java.util.*;

/**
 * @author Vincent
 * @Date 9/26/19
 */
public class SumOfNodesFromRootToLeaf {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(2);
        bt.root.left = new TreeNode(3);
        bt.root.left.left = new TreeNode(1);
        bt.root.left.right = new TreeNode(5);
        bt.root.right = new TreeNode(5);
        System.out.println(sumNodes(bt.root));
    }

    public static List<Integer> sumNodes(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;

    }

    public static void dfs(TreeNode root, List<Integer> res, int cur) {
        if (root.left == null && root.right == null) {
            res.add(cur + root.val);
            return;
        }
        dfs(root.left, res, cur + root.val);
        dfs(root.right, res, cur + root.val);
    }
}
