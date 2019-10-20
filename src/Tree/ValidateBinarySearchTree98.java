package Tree;
import Tree.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Vincent
 * @Date 2019-03-18
 */
public class ValidateBinarySearchTree98 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(1);
//        bt.root.right = new TreeNode(3);
        ValidateBinarySearchTree98 vb = new ValidateBinarySearchTree98();
        System.out.println(vb.isValidBST(bt.root));
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) return true;
//        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//
//    public boolean helper(TreeNode root, long low, long high) {
//        if (root == null) {
//            return true;
//        }
//        if (root.val >= low && root.val <= high) {
//            return true;
//        }
//        return helper(root.left, low, root.val) && helper(root.right, root.val, high);
//    }

    /**
     * Inorder traversal
     * Element in the list will be in a ascending order.
     */
//    public boolean isValidBST(TreeNode root) {
//        Stack<TreeNode> stack = new Stack();
//        List<Integer> in = new ArrayList<>();
//        inorder(root, in);
//        for (int i = 1; i < in.size(); i++) {
//            if (in.get(i - 1) >= in.get(i)) return false;
//        }
//        return true;
//    }
//    public void inorder(TreeNode root, List<Integer> in) {
//        if (root == null) return;
//        inorder(root.left, in);
//        in.add(root.val);
//        inorder(root.right, in);
//    }
}
