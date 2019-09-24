package Tree;
import Tree.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MergeTwoBinaryTrees617 {
    public static void inorder(TreeNode temp){
        if (temp == null){
            return;
        }
        inorder(temp.left);
        System.out.print(temp.val + " ");
        inorder(temp.right);
    }
    public static void main(String[] args) {
        BinaryTree bt1 = new BinaryTree(1);
        bt1.root.left = new TreeNode(3);
        bt1.root.right = new TreeNode(2);
        bt1.root.left.left = new TreeNode(5);

        BinaryTree bt2 = new BinaryTree(2);
        bt2.root.left = new TreeNode(1);
        bt2.root.right = new TreeNode(3);
        bt2.root.left.right = new TreeNode(4);
        bt2.root.right.right = new TreeNode(7);

        MergeTwoBinaryTrees617 mt = new MergeTwoBinaryTrees617();
        inorder(mt.mergeTrees(bt1.root, bt2.root));

    }
    // Using Queue
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2){
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        ((LinkedList<TreeNode>) queue1).push(t1);
        ((LinkedList<TreeNode>) queue2).push(t2);
        while (!queue1.isEmpty() || !queue2.isEmpty()){
            TreeNode cur1 = queue1.poll();
            TreeNode cur2 = queue2.poll();
            TreeNode temp = cur1;
            temp.val = cur1.val + cur2.val;

            if (cur1.left != null && cur2.left != null){
                ((LinkedList<TreeNode>) queue1).push(cur1.left);
                ((LinkedList<TreeNode>) queue2).push(cur2.left);
            } else if (cur1.left == null || cur2.left == null){
                temp.left = cur1.left == null ? cur2.left : cur1.left;
            }

            if (cur1.right != null && cur2.right != null){
                ((LinkedList<TreeNode>) queue1).push(cur1.right);
                ((LinkedList<TreeNode>) queue2).push(cur2.right);
            } else if (cur1.right == null || cur2.right == null){
                temp.right = cur1.right == null ? cur2.right : cur1.right;
            }
        }
        return t1;


    }
//    public TreeNode mergeTrees(TreeNode t1, TreeNode t2){
//        if (t1 == null) return t2;
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode cur = t1;
//        stack.push(cur);
//        stack.push(t2);
//        while (!stack.isEmpty()){
//            TreeNode[] temp = stack.pop();
//
//        }
//
//    }

    // Using Recursive
//    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//        if (t1 == null) return t2;
//        if (t2 == null) return t1;
//        TreeNode temp = new TreeNode(t1.val + t2.val);
//        temp.left = mergeTrees(t1.left, t2.left);
//        temp.right = mergeTrees(t1.right, t2.right);
//        return temp;
//
//    }
}
