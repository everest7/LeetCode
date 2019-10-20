package Tree;
import Tree.BinaryTree.TreeNode;

/**
 * @author Vincent
 * @Date 10/8/19
 */
public class InorderSuccessorBST285 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(1);
        bt.root.right = new TreeNode(3);
//        System.out.println(inorderSuccessor(bt.root, bt.root).val);
    }


//    static TreeNode prev = null;
//    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        return inorder(root, p);
//    }
//
//    public static TreeNode inorder(TreeNode root, TreeNode p) {
//        if (root == null) return null;
//        inorder(root.left, p);
//        if (prev != null && prev == p) {
//            return root;
//        }
//        prev = root;
//        inorder(root.right, p);
//    }
}
