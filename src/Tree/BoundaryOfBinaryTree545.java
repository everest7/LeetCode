package Tree;
import Tree.BinaryTree.TreeNode;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-08-17
 */
public class BoundaryOfBinaryTree545 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);
        BoundaryOfBinaryTree545 bf = new BoundaryOfBinaryTree545();
        System.out.println(bf.boundaryOfBinaryTree(bt.root));
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Set<TreeNode> set = new HashSet<>();
        TreeNode cur = root;
        while (cur != null) {
            set.add(cur);
            cur = cur.left;
        }

        leaves(set, root);
        rightBoundary(set, root);
        for (TreeNode node : set) {
            res.add(node.val);
        }
        return res;
    }

    public void rightBoundary(Set<TreeNode> set, TreeNode root) {
        if (root == null) return;
        rightBoundary(set, root.right);
        set.add(root);
    }

    public void leaves(Set<TreeNode> set, TreeNode root) {
        if (root == null) return;
        leaves(set, root.left);
        if (root.left == null && root.right == null) {
            set.add(root);
            return;
        }
        leaves(set, root.right);
    }
}
