package Tree;
import Tree.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


public class InvertBinaryTree226 {
    public static void preorder(TreeNode temp){
        if (temp == null){
            return;
        }
        System.out.print(temp.val + " ");
        preorder(temp.left);
        preorder(temp.right);
    }
    public static void inorder(TreeNode temp){
        if (temp == null){
            return;
        }
        inorder(temp.left);
        System.out.print(temp.val + " ");
        inorder(temp.right);
    }
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(4);
        bt.root.left = new TreeNode(2);
        bt.root.right = new TreeNode(7);
        bt.root.right.left = new TreeNode(6);
        bt.root.right.right = new TreeNode(9);
        bt.root.left.left = new TreeNode(1);
        bt.root.left.right = new TreeNode(3);
        InvertBinaryTree226 ib = new InvertBinaryTree226();
        ib.invertTree(bt.root);
        bt.preorder(bt.root);
        System.out.println();
        bt.levelorder(bt.root);
    }
    // Iterative way
    public TreeNode invertTree(TreeNode root){
        TreeNode cur = root;
        Queue<TreeNode> queue = new LinkedList<>();
        ((LinkedList<TreeNode>) queue).add(cur);
        while (!queue.isEmpty()){
            cur = queue.poll();
            TreeNode temp = cur.right;
            cur.right = cur.left;
            cur.left = temp;
            if (cur.left != null) ((LinkedList<TreeNode>) queue).add(cur.left);
            if (cur.right != null) ((LinkedList<TreeNode>) queue).add(cur.right);
        }
        return root;
    }

    // Recursive way
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null){
//            return null;
//        }
//        TreeNode left = invertTree(root.left);
//        TreeNode right = invertTree(root.right);
//        root.left = right;
//        root.right = left;
//        return root;
//    }
}
