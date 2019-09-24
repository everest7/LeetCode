package Tree;
import Tree.BinaryTree.TreeNode;

public class BinaryTreePruning814 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(1);
        bt.root.left = new TreeNode(0);
        bt.root.left.left = new TreeNode(0);
        bt.root.left.right = new TreeNode(0);
        bt.root.right = new TreeNode(1);
        bt.root.right.left = new TreeNode(0);
        bt.root.right.right = new TreeNode(1);
//        bt.inorder(bt.root);

        BinaryTreePruning814 bp = new BinaryTreePruning814();
        bt.inorder(bp.pruneTree(bt.root));

    }
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.val == 0 && root.left == null && root.right == null){
            root = null;
        }
        return root;
    }
}
