package Tree;
import Tree.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindMaxEachTreeRow515 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(1);
        bt.root.left = new TreeNode(3);
        bt.root.right = new TreeNode(2);
        bt.root.left.left = new TreeNode(5);
        bt.root.left.right = new TreeNode(3);
        bt.root.right.right = new TreeNode(9);
        FindMaxEachTreeRow515 fm = new FindMaxEachTreeRow515();
        System.out.println(fm.largestValues(bt.root));
    }
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        TreeNode head = root;
        ((LinkedList<TreeNode>) queue).add(head);
        while (!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                int num = cur.val;
                if (num > max){
                    max = num;
                }
                if (cur.left != null) ((LinkedList<TreeNode>) queue).add(cur.left);
                if (cur.right != null) ((LinkedList<TreeNode>) queue).add(cur.right);
            }
            res.add(max);
        }
        return res;
    }
}
