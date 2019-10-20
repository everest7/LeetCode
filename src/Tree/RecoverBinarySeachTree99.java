package Tree;
import Tree.BinaryTree.TreeNode;
/**
 * @author Vincent
 * @Date 2019-07-20
 */
public class RecoverBinarySeachTree99 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(3);
        bt.root.left = new TreeNode(1);
        bt.root.right = new TreeNode(4);
        bt.root.right.left = new TreeNode(2);
        RecoverBinarySeachTree99 rs = new RecoverBinarySeachTree99();
        rs.recoverTree(bt.root);
        bt.inorder(bt.root);
    }

    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev == null) {
            prev = root;
        } else {
            if (prev.val > root.val) {
                if (first == null) first = prev;
                second = root;
            }
            prev = root; // Must be set before enter next recursion
        }
        inorder(root.right);
    }

//    TreeNode first = null;
//    TreeNode second = null;
//    TreeNode prev = new TreeNode(-1);
//    public void recoverTree(TreeNode root) {
//        inorder(root);
//        int tmp = first.val;
//        first.val = second.val;
//        second.val = tmp;
//    }
//
//    public void inorder(TreeNode root) {
//        if (root == null) return;
//        inorder(root.left);
//        if (first == null && prev.val > root.val) {
//            first = root;
//        }
//        if (first != null && prev.val > root.val) {
//            second = root;
//        }
//        prev = root;
//        inorder(root.right);
//    }
}
