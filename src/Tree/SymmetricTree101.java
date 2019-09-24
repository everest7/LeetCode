package Tree;
import Tree.BinaryTree.TreeNode;
import jdk.nashorn.api.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTree101 {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(1);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(2);
        bt.root.left.right = new TreeNode(3);
        bt.root.left.left = new TreeNode(4);
        bt.root.right.left = new TreeNode(3);
        bt.root.right.right = new TreeNode(4);
        SymmetricTree101 st = new SymmetricTree101();
        System.out.println(st.isSymmetric(bt.root));

    }

    // Iterative way
    public boolean isSymmetric(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        ((LinkedList<TreeNode>) queue).push(root);
        ((LinkedList<TreeNode>) queue).push(root);
        while (!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null){
                continue;
            }
            if (t1 == null || t2 == null){
                return false;
            }
            if (t1.val != t2.val) return false;
            ((LinkedList<TreeNode>) queue).push(t1.left);
            ((LinkedList<TreeNode>) queue).push(t2.right);
            ((LinkedList<TreeNode>) queue).push(t1.right);
            ((LinkedList<TreeNode>) queue).push(t2.left);
        }
        return true;
    }
//    public boolean isSymmetric(TreeNode root){
//        inorderList(root);
//        for (int i = 0, j = list.size() - 1; i < j; i++, j--){
//            if (list.get(i) != list.get(j)){
//                return false;
//            }
//        }
//        return true;
//
//    }
//    List<Integer> list = new ArrayList<>();
//    public void inorderList(TreeNode root){
//        if (root == null){
//            return ;
//        }
//        inorderList(root.left);
//        list.add(root.val);
//        inorderList(root.right);
//
//    }

    // Recursive way
//    public boolean isSymmetric(TreeNode root) {
//        return isMirror(root, root);
//    }
//    public boolean isMirror(TreeNode node1, TreeNode node2){
//        if (node1 == null && node2 == null){
//            return true;
//        }
//        if (node1 == null || node2 == null){
//            return false;
//        }
//        return node1.val == node2.val && isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
//    }
}
