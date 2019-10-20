package Tree;
import Tree.BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vincent
 * @Date 2019-07-18
 */
public class HouseRobberIII337 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(3);
        bt.root.left = new TreeNode(2);
        bt.root.left.right = new TreeNode(3);
        bt.root.right = new TreeNode(3);
        bt.root.right.right = new TreeNode(1);
        HouseRobberIII337 hr = new HouseRobberIII337();
        System.out.println(hr.rob(bt.root));

    }

    public int rob(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        return dfs(root, map);
    }

    public int dfs(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int val = 0;
        if (root.left != null) {
            val += dfs(root.left.left, map) + dfs(root.left.right, map);
        }
        if (root.right != null) {
            val += dfs(root.right.left, map) + dfs(root.right.right, map);
        }
        val = Math.max(val + root.val, dfs(root.left, map) + dfs(root.right, map));
        map.put(root, val);
        return val;
    }
}
