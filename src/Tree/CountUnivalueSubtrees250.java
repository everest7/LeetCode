package Tree;
import Tree.BinaryTree.TreeNode;

/**
 * @author Vincent
 * @Date 2019-03-18
 */
public class CountUnivalueSubtrees250 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(5);
        bt.root.left = new TreeNode(1);
        bt.root.left.left = new TreeNode(5);
        bt.root.left.right = new TreeNode(5);
        bt.root.right = new TreeNode(5);
        bt.root.right.right = new TreeNode(5);
        CountUnivalueSubtrees250 cu = new CountUnivalueSubtrees250();
        System.out.println(cu.countUnivalSubtrees(bt.root));
    }
    int res;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        isUni(root);
        return res;
    }

    public boolean isUni(TreeNode root) {
        if (root == null) return true;
        boolean left = isUni(root.left);
        boolean right = isUni(root.right);
        if (left && right) {
            if (root.left != null && root.val != root.left.val) {
                return false;
            }
            if (root.right != null && root.val != root.right.val) {
                return false;
            }
            res++;
            return true;
        }
        return false;
    }

    /**
     *
     */
//    int res;
//    public int countUnivalSubtrees(TreeNode root) {
//        if (root == null) return 0;
//        if (isUni(root, root.val)) res++;
//        countUnivalSubtrees(root.left);
//        countUnivalSubtrees(root.right);
//        return res;
//    }
//    public boolean isUni(TreeNode root, int val) {
//        if (root == null) return true;
//        return root.val == val && isUni(root.left, root.val) && isUni(root.right, root.val);
//    }
}
