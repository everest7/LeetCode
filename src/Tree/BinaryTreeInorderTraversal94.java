package Tree;
import Tree.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal94 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(1);
        bt.root.right = new TreeNode(3);
        bt.root.right.left = new TreeNode(2);
        BinaryTreeInorderTraversal94 bti = new BinaryTreeInorderTraversal94();
        System.out.println(bti.inorderTraversal(bt.root));
    }
    /**
     * Iterative approach
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
    /**
     * Recursive approach
     * @param root
     * @return
     */
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        inorderTraverse(res, root);
//        return res;
//    }
//    public void inorderTraverse(List<Integer> list, TreeNode root) {
//        if (root != null) {
//
//            inorderTraverse(list, root.left);
//            list.add(root.val);
//            inorderTraverse(list, root.right);
//        }
//    }
}
