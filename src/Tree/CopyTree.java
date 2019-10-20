package Tree;
import Tree.BinaryTree.TreeNode;
import java.util.*;
/**
 * @author Vincent
 * @Date 10/10/19
 */
public class CopyTree {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(2);
        bt.root.left.left = new TreeNode(4);
        bt.root.right = new TreeNode(3);
        bt.levelorder(copyTree(bt.root));
    }

    public static TreeNode copyTree(TreeNode root){
        Map<TreeNode, TreeNode> map = new HashMap<>();
        return helper(root, map, 1);
    }

    public static TreeNode helper(TreeNode root, Map<TreeNode, TreeNode> map, int level) {
        if (root == null) return null;
        if (map.containsKey(root)) return map.get(root);
        TreeNode node = new TreeNode(root.val + level);
        map.put(root, node);
        node.left = helper(root.left, map, level + 1);
        node.right = helper(root.right, map, level + 1);
        return map.get(root);
    }
}
