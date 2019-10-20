package Tree;
import Tree.BinaryTree.TreeNode;

import java.util.Stack;

/**
 * @author Vincent
 * @Date 2019-03-14
 */
public class SumofLeftLeaves404 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(3);
        bt.root.left = new TreeNode(9);
        bt.root.right = new TreeNode(20);
        bt.root.right.left = new TreeNode(15);
        bt.root.right.right = new TreeNode(7);
        SumofLeftLeaves404 sl = new SumofLeftLeaves404();
        System.out.println(sl.sumOfLeftLeaves(bt.root));
    }

    /**
     * Recursive solution
     */
//    int res = 0;
//    public int sumOfLeftLeaves(TreeNode root) {
//        if (root == null) return 0;
//
//        helper(root.left, true);
//        helper(root.right, false);
//        return res;
//    }
//    public void helper(TreeNode root, boolean left) {
//        if (root == null) return;
//        if (root.left == null && root.right == null && left) {
//            res += root.val;
//        }
//        helper(root.left, true);
//        helper(root.right, false);
//
//    }

    /**
     * Iterative solution
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int res = 0;
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.left != null) {
                if (temp.left.left == null && temp.left.right == null) {
                    res += temp.left.val;
                } else {
                    stack.push(temp.left);
                }
            }
            if (temp.right != null) {
                if (temp.right.left != null || temp.right.right != null) {
                    stack.push(temp.right);
                }
            }
        }
        return res;
    }
}
