package Tree;
import Tree.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(3);
        bt.root.left = new TreeNode(9);
        bt.root.left.left = new TreeNode(10);
        bt.root.right = new TreeNode(20);
        bt.root.right.left = new TreeNode(15);
        bt.root.right.right = new TreeNode(7);


        BTLevelOrderTraversal bl = new BTLevelOrderTraversal();
        System.out.println(bl.levelOrder(bt.root));

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return null;
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        ((LinkedList<TreeNode>) queue).add(cur);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> sub = new ArrayList<>();
            for (int i = 0; i < size; i++){
                cur = queue.poll();
                sub.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            res.add(sub);
        }
        return res;

    }
}
