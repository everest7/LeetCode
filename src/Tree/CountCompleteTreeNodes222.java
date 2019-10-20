package Tree;
import Tree.BinaryTree.TreeNode;

public class CountCompleteTreeNodes222 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(1);
        bt.root.left = new TreeNode(2);
        bt.root.left.left = new TreeNode(4);
        bt.root.left.right = new TreeNode(5);
        bt.root.right = new TreeNode(3);
        bt.root.right.left = new TreeNode(6);
        CountCompleteTreeNodes222 cc = new CountCompleteTreeNodes222();
        System.out.println(cc.countNodes(bt.root));
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int lheight = left(root.left);
        int rheight = right(root.right);
        if (lheight == rheight) return (int) Math.pow(2, rheight) - 1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    public int left(TreeNode root) {
        if (root == null) return 0;
        return 1 + left(root.left);
    }

    public int right(TreeNode root) {
        if (root == null) return 0;
        return 1 + right(root.right);
    }
//    public int countNodes(TreeNode root) {
//        TreeNode left = root, right = root;
//        int lheight = 0, rheight = 0;
//        while (left != null) {
//            lheight++;
//            left = left.left;
//        }
//        while (right != null) {
//            rheight++;
//            right = right.right;
//        }
//        if (lheight == rheight) {
//            return (int)Math.pow(2, lheight) - 1;
//        } else {
//            return countNodes(root.left) + countNodes(root.right) + 1;
//        }
//    }
}
