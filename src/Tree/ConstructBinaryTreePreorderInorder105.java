package Tree;
import Tree.BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ConstructBinaryTreePreorderInorder105 {
    public static void main(String[] args) {
        ConstructBinaryTreePreorderInorder105 ct = new ConstructBinaryTreePreorderInorder105();
        int[] pre = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        BinaryTree bt = new BinaryTree();
        bt.levelorder(ct.buildTree(pre, inorder));
    }
    /**
     * Iterative approach
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            if (map.get(preorder[i]) < map.get(stack.peek().val)) {
                stack.peek().left = node;
            } else {
                TreeNode parent = null;
                while (!stack.isEmpty() && map.get(preorder[i]) > map.get(stack.peek().val)) {
                    parent = stack.pop();
                }
                parent.right = node;
            }
            stack.push(node);
        }
        return root;
    }

    /**
     * Recursive approach
     */
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return helper(0, 0, inorder.length - 1, preorder, inorder);
//    }
//
//    public TreeNode helper(int preStart, int inStart, int inEnd, int[] pre, int[] in) {
//        if (preStart > pre.length - 1 || inStart > inEnd) return null;
//        TreeNode root = new TreeNode(pre[preStart]);
//        int inIndex = 0;
//        for (int i = inStart; i <= inEnd; i++) {
//            if (in[i] == root.val) {
//                inIndex = i;
//            }
//        }
//        root.left = helper(preStart + 1, inStart, inIndex - 1, pre, in);
//        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, pre, in);
//        return root;
//    }
}
