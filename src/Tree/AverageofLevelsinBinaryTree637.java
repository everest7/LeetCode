package Tree;
import Tree.BinaryTree.TreeNode;

import java.util.*;

/**
 * @author Vincent
 * @Date 2019-03-15
 */
public class AverageofLevelsinBinaryTree637 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode(3);
        bt.root.left = new TreeNode(9);
        bt.root.right = new TreeNode(20);
        bt.root.right.left = new TreeNode(15);
        bt.root.right.right = new TreeNode(7);
        AverageofLevelsinBinaryTree637 al = new AverageofLevelsinBinaryTree637();
//        System.out.println(al.averageOfLevels(bt.root));
        System.out.println(al.preorderTraversal(bt.root));
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            int num = 0;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                sum += temp.val;
                num++;
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            res.add(sum / num);
        }
        return res;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }


        }
        return res;
    }
}
