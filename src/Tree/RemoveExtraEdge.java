package Tree;
import Tree.BinaryTree.TreeNode;

import java.util.HashSet;

/**
 * @author Vincent
 * @Date 2019-08-15
 */
public class RemoveExtraEdge {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(1);
        TreeNode dup = new TreeNode(5);
        bt.root.left = new TreeNode(2);
        bt.root.left.left = new TreeNode(4);
        bt.root.right = new TreeNode(3);
        bt.root.left.right = dup;
        bt.root.right.left = dup;
        RemoveExtraEdge re = new RemoveExtraEdge();
        bt.levelorder(re.removeExtra(bt.root));
    }

    public TreeNode removeExtra(TreeNode node) {
        return remove(node, new HashSet<TreeNode>());
    }

    public TreeNode remove(TreeNode root, HashSet<TreeNode> set) {
        if (root == null || !set.add(root)) {
            return null;
        }
        root.left = remove(root.left, set);
        root.right = remove(root.right, set);
        return root;
    }
}
