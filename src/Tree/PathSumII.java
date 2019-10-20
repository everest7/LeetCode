package Tree;
import Tree.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSumII {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(5);
        bt.root.left = new TreeNode(4);
        bt.root.left.left = new TreeNode(11);
        bt.root.left.left.left = new TreeNode(7);
        bt.root.left.left.right = new TreeNode(2);
        bt.root.right = new TreeNode(8);
        bt.root.right.left = new TreeNode(13);
        bt.root.right.right = new TreeNode(4);
        bt.root.right.right.left = new TreeNode(5);
        bt.root.right.right.right = new TreeNode(1);
        PathSumII psii = new PathSumII();
        System.out.println(psii.pathSum(bt.root,22));
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, sum, res, new ArrayList<>());
        return res;
    }

    public void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> sub) {
        if (root == null) return;
        sum -= root.val;
        sub.add(root.val);
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(sub));
        }
        dfs(root.left, sum, res, sub);
        dfs(root.right, sum, res, sub);
        sum += sub.get(sub.size() - 1);
        sub.remove(sub.size() - 1);
    }

    /**
     * Using arraylist
     */
//    public List<List<Integer>> pathSum(TreeNode root, int sum) {
//        List<List<Integer>> list = new ArrayList<>();
//        List<Integer> sub = new ArrayList<>();
//        findPath(root, list, sub, sum);
//        return list;
//    }
//
//    public void findPath(TreeNode root, List<List<Integer>> list, List<Integer> sub, int sum) {
//        if (root == null) return;
//        sum -= root.val;
//        sub.add(root.val);
//        if (root.left == null && root.right == null && sum == 0) {
//            List<Integer> copy = new ArrayList<>();
//            for (int i = 0; i < sub.size(); i++) {
//                copy.add(sub.get(i));
//            }
//            list.add(copy);
//        }
//        findPath(root.left, list, sub,sum);
//        findPath(root.right, list, sub,sum);
//        sum += sub.get(sub.size() - 1);
//        sub.remove(sub.size() - 1);
//    }

    /**
     * Using Stack
     * @param root
     * @param sum
     * @return
     */
//    public List<List<Integer>> pathSum(TreeNode root, int sum) {
//        List<List<Integer>> list = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        helper(root, list, stack, 0, sum);
//        return list;
//    }
//
//    public void helper(TreeNode root, List<List<Integer>> list, Stack<TreeNode> stack, int curSum, int sum) {
//        if (root == null) return;
//        curSum += root.val;
//        stack.push(root);
//        if (root.left == null && root.right == null && curSum == sum) {
//            List<Integer> sub = new ArrayList<>();
//            for (int i = 0; i < stack.size(); i++) {
//                sub.add(stack.get(i).val);
//            }
//            list.add(sub);
//        }
//        helper(root.left, list, stack, curSum, sum);
//        helper(root.right, list, stack, curSum, sum);
////        stack.pop();
//        curSum -= stack.pop().val;
//
//    }
}
