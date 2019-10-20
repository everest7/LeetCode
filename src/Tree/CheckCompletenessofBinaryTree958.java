package Tree;
import java.util.*;

import Tree.BinaryTree.TreeNode;
/**
 * @author Vincent
 * @Date 9/18/19
 */
public class CheckCompletenessofBinaryTree958 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(3);
        bt.root.left.right= new TreeNode(5);
        bt.root.left.left = new TreeNode(4);
        bt.root.right.left = new TreeNode(6);
        System.out.println(isCompleteTree(bt.root));
    }
    public static boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        boolean nullMet = false;
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                if (nullMet) return false;
                nullMet = true;
            }
            if (cur != null && (cur.left != null || cur.right != null)) q.offer(cur.left);
            if (cur != null && (cur.left != null || cur.right != null)) q.offer(cur.right);
        }
        return true;
    }


}
