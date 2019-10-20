package Tree;
import Tree.BinaryTree.TreeNode;

public class BalancedBinaryTree110 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);
        bt.root.left.left = new TreeNode(8);
        bt.root.left.left.left = new TreeNode(9);
        BalancedBinaryTree110 bbl = new BalancedBinaryTree110();
        System.out.println(bbl.isBalanced(bt.root));

    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int l = height(root.left);
        int r = height(root.right);
        if (Math.abs(l - r) < 1 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }
        return false;
    }

    public int height(TreeNode node){
        if (node == null){
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
