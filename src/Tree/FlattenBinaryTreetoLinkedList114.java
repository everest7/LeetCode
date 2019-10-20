package Tree;
import Tree.BinaryTree.TreeNode;

public class FlattenBinaryTreetoLinkedList114 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(5);
        bt.root.right.right = new TreeNode(6);
        bt.root.left.left = new TreeNode(3);
        bt.root.left.right = new TreeNode(4);
        FlattenBinaryTreetoLinkedList114 ft = new FlattenBinaryTreetoLinkedList114();
        ft.flatten(bt.root);
        bt.levelorder(bt.root);

    }
    /**
     * Iterative approach
     */
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode temp = cur.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }

    }

    /**
     * Recursive approach
     * @param root
     */
//    public void flatten(TreeNode root) {
//        if (root == null) return;
//        if (root.left != null) flatten(root.left);
//        if (root.right != null) flatten(root.right);
//        TreeNode temp = root.right;
//        root.right = root.left;
//        root.left = null;
//        while (root.right != null) {
//            root = root.right;
//        }
//        root.right = temp;
//    }
}
