package Tree;
import Tree.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView199 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(1);
        bt.root.left = new TreeNode(2);
        bt.root.left.right = new TreeNode(5);
        bt.root.right = new TreeNode(3);
        bt.root.right.right = new TreeNode(4);
        BinaryTreeRightSideView199 btr = new BinaryTreeRightSideView199();
        System.out.println(btr.rightSideView(bt.root));

    }

    /**
     * Using DFS
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res, 0);
        return res;
    }
    public void traverse(TreeNode root, List<Integer> res, int level) {
        if (root == null) return;
        if (res.size() <= level) {
            res.add(root.val);
        }
        traverse(root.right, res, level + 1);
        traverse(root.left, res, level + 1);
    }

    /**
     * Using BFS
     * @param root
     * @return
     */
//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if (root == null) return res;
//        Queue<TreeNode> queue = new LinkedList<>();
//        ((LinkedList<TreeNode>) queue).push(root);
//        while (!queue.isEmpty()) {
//            res.add(((LinkedList<TreeNode>) queue).peekLast().val);
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode temp = queue.poll();
//                if (temp.left != null) {
//                    ((LinkedList<TreeNode>) queue).offer(temp.left);
//                }
//                if (temp.right != null) {
//                    ((LinkedList<TreeNode>) queue).offer(temp.right);
//                }
//            }
//
//        }
//        return res;
//    }
}
