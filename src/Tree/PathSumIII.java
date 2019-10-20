package Tree;

import Tree.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PathSumIII {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(10);
        bt.root.left = new TreeNode(5);
        bt.root.right = new TreeNode(-3);
        bt.root.right.right = new TreeNode(11);
        bt.root.left.left = new TreeNode(3);
        bt.root.left.right = new TreeNode(2);
        bt.root.left.right.right = new TreeNode(1);
        bt.root.left.left.left = new TreeNode(3);
        bt.root.left.left.right = new TreeNode(-2);
//        bt.inorder(bt.root);
        PathSumIII ps = new PathSumIII();
        System.out.println(ps.pathSum(bt.root, 8));

    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return helper(root, sum) + helper(root.left, sum) + helper(root.right, sum);
    }

    /**
     *
     * @param root
     * @param sum
     * @return number of
     */
    public int helper(TreeNode root, int sum) {
        if (root == null) return 0;
        int self = sum == root.val ? 1 : 0;
        int left = helper(root.left, sum - root.val);
        int right = helper(root.right, sum - root.val);
        return self + left + right;
    }


//    public int pathSum(TreeNode root, int sum) {
//        if (root == null) return 0;
//        Stack<TreeNode> queue = new Stack<>();
//        int res = 0;
//        helper(root, queue, 0, sum, res);
//        return res;
//    }
//
//    // Why res is set to 0 after some pop()
//    public void helper(TreeNode root, Stack<TreeNode> queue, int curSum, int sum, int res) {
//        if (root == null) return;
//        curSum += root.val;
//        queue.push(root);
//        if (curSum == sum) {
//            ++res;
//        }
//        int t = curSum;
//        for (int i = 0; i < queue.size() - 1; i++) {
//            t -= queue.get(i).val;
//            if (t == sum) {
//                ++res;
//            }
//        }
//        helper(root.left, queue, curSum, sum, res);
//        helper(root.right, queue, curSum, sum, res);
//        queue.pop();
//    }

    /**
     * DFS
     * @param root
     * @param sum
     * @return
     */
//    public int pathSum(TreeNode root, int sum) {
//        if (root == null) return 0;
//        return pathFrom(root, sum) + pathFrom(root.left, sum) + pathFrom(root.right, sum);
//    }
//
//    public int pathFrom(TreeNode root, int sum) {
//        if (root == null) return 0;
//        return (root.val == sum ? 1 : 0) + pathFrom(root.left, sum - root.val) + pathFrom(root.right,
//                sum - root.val);
//    }



}
