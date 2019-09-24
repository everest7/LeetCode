package Tree;
import Tree.BinaryTree.TreeNode;
import jdk.nashorn.api.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SameTree100 {
    public static void main(String[] args) {
        SameTree100 st = new SameTree100();
        BinaryTree bt = new BinaryTree(1);
        bt.root.left = new TreeNode(2);
        BinaryTree bt2 = new BinaryTree(1);
        bt2.root.right = new TreeNode(2);
        System.out.println(st.isSameTree(bt.root, bt2.root));

    }
    // Using Stack
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);
        while (!stack.isEmpty()){
            TreeNode temp2 = stack.pop();
            TreeNode temp1 = stack.pop();
            if (temp1 == null && temp2 == null){
                continue;
            } else if (temp1 == null || temp2 == null || temp1.val != temp2.val){
                return false;
            }else {
                stack.push(temp1.left);
                stack.push(temp2.left);
                stack.push(temp1.right);
                stack.push(temp2.right);
            }
        }
        return true;

    }

    // Recursive way
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if (p == null && q == null) return true;
//        if (p == null || q == null) return false;
//        if (p.val != q.val){
//            return false;
//        } else {
//            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//        }
//
//    }
}
